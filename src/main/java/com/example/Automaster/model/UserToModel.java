package com.example.Automaster.model;

import com.example.Automaster.entity.UserEntity;

public class UserToModel {
	private Long id;
	private String email;
	private String login;

	public static UserToModel toModel(UserEntity entity) {
		UserToModel model = new UserToModel();
		model.setId(entity.getId());
		model.setEmail(entity.getEmail());
		model.setLogin(entity.getLogin());
		return model;
	}

	public UserToModel(){

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
