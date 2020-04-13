package com.ea.miushop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Roles")
public class Role {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long role_id=null;
	 
	 private String role_name;

      
	public Long getRole_id() {
			return role_id;
		}

	public void setRole_id(Long role_id) {
			this.role_id = role_id;
		}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


	 
}
