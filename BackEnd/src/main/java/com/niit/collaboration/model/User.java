package com.niit.collaboration.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




@Entity(name="User")
public class User implements Serializable {
	@Id
	private String	Username;
	private String	Password;
	transient private String Cpassword;
	private String	Name;
	private String	Email;
	private boolean active;
	
	public User()
	{
		
	}
	
	public void setActive(boolean active) {
		this.active = true;
	}
	
	
	public boolean isActive() {
		return  true;
	}
	


	public String getUsername() {
		return Username;
	}
	public String getPassword()
	{
		return Password;
	}
	public String getCpassword() {
		return Cpassword;
	}
	public String getName() {
		return Name;
	}
	public String getEmail() {
		return Email;
	}
	
	public void setUsername(String username) {
		Username = username;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setCpassword(String cpassword) {
		Cpassword = cpassword;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
