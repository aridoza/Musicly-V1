package com.ga.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Column(unique = true, nullable = false)
    private String name;
    
    @JsonIgnore
	@OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
	private List<User> users;
	
	public void setUsers(List<User> users) { this.users = users; }

    public List<User> getUsers() { return users; }
    

    public UserRole() {}

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}