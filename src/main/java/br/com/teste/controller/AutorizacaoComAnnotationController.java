package br.com.teste.controller;

import javax.inject.Inject;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.security.annotation.Secured;

@Secured
@Controller
public class AutorizacaoComAnnotationController {

	@Inject
	private Result result;

	@RequiresPermissions("add")
	@Get("/add")
	public void permissaoAdd() {
		result.include("msg", "Possui add");
		result.redirectTo(IndexController.class).index();
	}

	@RequiresPermissions("edit")
	@Get("/edit")
	public void permissaoEdit() {
		result.include("msg", "Possui edit");
		result.redirectTo(IndexController.class).index();
	}

	@RequiresPermissions("delete")
	@Get("/delete")
	public void permissaoDelete() {
		result.include("msg", "Possui delete");
		result.redirectTo(IndexController.class).index();
	}

	@RequiresPermissions("read")
	@Get("/read")
	public void permissaoRead() {
		result.include("msg", "Possui read");
		result.redirectTo(IndexController.class).index();
	}

}
