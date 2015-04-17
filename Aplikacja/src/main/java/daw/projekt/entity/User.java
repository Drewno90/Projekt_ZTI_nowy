package daw.projekt.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import daw.projekt.annotation.UniqueUsername;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=3, message="Nazwa musi zawierac conajmniej 3 znaki!")
	@Column(unique=true)
	@UniqueUsername(message="Taka nazwa uzytkownika juz istnieje!")
	private String name;
	
	@Size(min=1, message="Niprawidłowy adres email!")
	@Email(message="Niprawidłowy adres email!")
	private String email;
	
	@Size(min=5, message="Haslo musi zawierac conajmniej 5 znaki!")
	private String password;
	
	private boolean enabled;
	

	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
	private List<Blog> blogs;
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
