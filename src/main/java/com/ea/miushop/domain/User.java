package com.ea.miushop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="USER")
public class User {

	   @Id @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name = "USER_ID")
	    private Long userid = null;


	    @Column(name = "FIRSTNAME", nullable = false)
	    private String firstName;


	    @Column(name = "LASTNAME", nullable = false)
	    private String lastName;


	    @Column(name = "EMAIL", nullable = false)
	    private String email;
	    
		@OneToOne(fetch=FetchType.LAZY,  cascade = CascadeType.ALL) 
		@JoinColumn(name="userId") 
		private UserCredentials userCredentials;
		
		@ManyToMany(mappedBy="users",fetch=FetchType.EAGER) //, cascade= {CascadeType.PERSIST,CascadeType.MERGE })
		private List<User_Role> usersRoles = new ArrayList<User_Role>();

		public Long getUserid() {
			return userid;
		}

		public void setUserid(Long userid) {
			this.userid = userid;
		}
		

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public UserCredentials getUserCredentials() {
			return userCredentials;
		}

		public void setUserCredentials(UserCredentials userCredentials) {
			this.userCredentials = userCredentials;
		}

		public List<User_Role> getUsersRoles() {
			return usersRoles;
		}

		public void setUsersRoles(List<User_Role> usersRoles) {
			this.usersRoles = usersRoles;
		}

		
		
		
		

//=======
//import javax.persistence.*;
//
//
//@Entity
//<<<<<<<< HEAD:src/main/java/com/ea/miushop/domain/User.java
//public class User {
//========
//@Table(name = "users")
//public class Customer {
//>>>>>>>> master:src/main/java/com/ea/miushop/domain/Customer.java
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long userId;
//
//    private String firstName;
//
//    private String lastName;
//
//    private String email;
//
//    @OneToOne
//    @JoinColumn(name = "user_credentials_id")
//    private UserCredentials userCredentials;
//
//    public User() {
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public UserCredentials getUserCredentials() {
//        return userCredentials;
//    }
//
//    public void setUserCredentials(UserCredentials userCredentials) {
//        this.userCredentials = userCredentials;
//    }
//>>>>>>> master
}
