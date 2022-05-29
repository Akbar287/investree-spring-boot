package com.investree.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user_detail")
public class UserDetail implements Serializable{

    private static final long serialVersionUID = 5267477974389610248L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private Users user;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat", columnDefinition = "TEXT")
    private String alamat;
}
