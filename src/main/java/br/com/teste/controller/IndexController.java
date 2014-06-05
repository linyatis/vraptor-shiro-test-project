package br.com.teste.controller;

import javax.inject.Inject;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	@Inject
	private Subject currentUser;
	@Inject
	private Session session;
	@Inject
	private Result result;

	@Path("/")
	public void index() {
		System.out.println("<<<<< INÍCIO IndexController.index() >>>>>");

		System.out.println("Session: " + session.getId());
		System.out.println("Session (currentUser): "
				+ currentUser.getSession().getId());

		result.include("msg_index", "Usuário: " + session.getAttribute("username"));
		
		System.out.println("<<<<< FIM IndexController.index() >>>>>");
	}

}
