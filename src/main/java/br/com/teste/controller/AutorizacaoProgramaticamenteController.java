package br.com.teste.controller;

import javax.inject.Inject;

import org.apache.shiro.subject.Subject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class AutorizacaoProgramaticamenteController {

	@Inject
	Subject subject;
	@Inject
	private Result result;

	@Get("/add2")
	public void permissaoAdd() {
		if(subject.isPermitted("add")) {
			result.include("msg", "Possui add");
			result.redirectTo(IndexController.class).index();
		} else {
			result.include("msg", "Não possui add =(");
			result.redirectTo(IndexController.class).index();
		}
	}

	@Get("/edit2")
	public void permissaoEdit() {
		if(subject.isPermitted("edit")) {
			result.include("msg", "Possui edit");
			result.redirectTo(IndexController.class).index();
		} else {
			result.include("msg", "Não possui edit =(");
			result.redirectTo(IndexController.class).index();
		}
	}

	@Get("/delete2")
	public void permissaoDelete() {
		if(subject.isPermitted("delete")) {
			result.include("msg", "Possui delete");
			result.redirectTo(IndexController.class).index();
		} else {
			result.include("msg", "Não possui delete =(");
			result.redirectTo(IndexController.class).index();
		}
	}

	@Get("/read2")
	public void permissaoRead() {
		if(subject.isPermitted("read")) {
			result.include("msg", "Possui read");
			result.redirectTo(IndexController.class).index();
		} else {
			result.include("msg", "Não possui read =(");
			result.redirectTo(IndexController.class).index();
		}
	}

}
