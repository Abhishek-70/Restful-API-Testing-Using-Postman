package com.web_App_2.EntityClass;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="application_data")
public class ApplicationData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int S_NO_;
	
	@NotEmpty
	@Size(min=2,message="Name Should Have at least 2 charecter in the available format")
	@Column(name="student",length=145)
	private String Name;
	@Column(name="school",length=145)
	private String School;
	
	@Email
	@Column(name="email_id",length=145)
	private String email;
	
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
	@Column(name="contact",length=120)
	private String phone;
	public int getS_NO_() {
		return S_NO_;
	}
	public void setS_NO_(int s_NO_) {
		S_NO_ = s_NO_;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSchool() {
		return School;
	}
	public void setSchool(String school) {
		School = school;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
