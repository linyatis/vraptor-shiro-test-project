package br.com.teste.controller;

import javax.inject.Inject;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.security.AuthorizationRestrictionListener;
import br.com.caelum.vraptor.view.Results;

@Controller
public class AuthController implements AuthorizationRestrictionListener {

	@Inject
	private Result result;
	@Inject
	private Subject currentUser;
	@Inject
	private Session session;

	@Post("/login")
	public void login(String username, String password, boolean remember) {
		try {
			System.out.println("<<<<< INÍCIO AuthController.login() >>>>>");

			currentUser.login(new UsernamePasswordToken(username, password,
					remember));
			session.setAttribute("username", username);

			System.out.println("Session: " + session.getId());

			result.include("msg",
					"Usuário: " + session.getAttribute("username"));
			result.redirectTo(IndexController.class).index();

			System.out.println("<<<<< FIM AuthController.login() >>>>>");

		} catch (AuthenticationException e) {
			result.include("error", "Erro na autenticação");
			result.redirectTo(AuthController.class).formLogin();
		}
	}

	@Get("/login")
	public void formLogin() {
	}

	@Get("/logout")
	public void logout() {
		currentUser.logout();
		result.redirectTo(AuthController.class).formLogin();
	}

	@Override
	public void onAuthorizationRestriction(AuthorizationException e) {
		result.use(Results.status()).forbidden(e.toString());
	}
}
