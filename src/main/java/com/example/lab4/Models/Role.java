package com.example.lab4.Models;

import jakarta.persistence.*;
import java.util.Set;
@Entity
        @Table(name = "status")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role")
    private int id;

    @Column(name = "role")
    private String role;

    @Column(name = "request")
    private int request;

    @OneToMany(mappedBy = "role")
    private Set<Users> user;

    public String getRoleStatus(){
        return role;
    }

    public void setRoleStatus(String roleStatus) {
        this.role = roleStatus;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }
}
