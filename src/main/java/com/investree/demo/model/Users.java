package com.investree.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class Users implements Serializable{

    private static final long serialVersionUID = 5914477974389610248L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    @OneToMany(mappedBy = "peminjam")
    private List<Transaksi> peminjam;

    @OneToMany(mappedBy = "meminjam")
    private List<Transaksi> meminjam;

    @OneToOne(mappedBy = "user")
    private UserDetail userDetail;

    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "is_active")
    private Boolean is_active;
}
