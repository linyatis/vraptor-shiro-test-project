package br.com.teste.service;

import java.util.HashSet;
import java.util.Set;

import br.com.caelum.vraptor.security.Permission;
import br.com.caelum.vraptor.security.User;

public class AuthService implements Permission {

	@Override
	public User getUserByUsername(String username) {
		return new User(username, "123456");
	}

	@Override
	public Set<String> getRolesByUser(String user) {
		Set<String> roles = new HashSet<>();

		if (user.equals("admin")) {
			roles.add("admin");
		}
		roles.add("user");

		return roles;
	}

	@Override
	public Set<String> getPermissionsByRole(String role) {
		Set<String> permissions = new HashSet<>();
		if (role.equals("admin")) {
			permissions.add("add");
			permissions.add("edit");
			permissions.add("delete");
			permissions.add("read");
		} else {
			permissions.add("read");
		}

		return permissions;
	}

}
