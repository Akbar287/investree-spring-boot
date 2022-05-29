package com.investree.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "transaksi")
@Data
public class Transaksi implements Serializable{

    private static final long serialVersionUID = 5267477979559610248L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "transaksi")
    private List<PaymentHistory> paymentHistory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_peminjam")
    private Users peminjam;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_meminjam")
    private Users meminjam;

    @Column(name = "tenor")
    private int tenor;

    @Column(name = "total_pinjaman")
    private Double total_pinjaman;

    @Column(name = "bunga_persen")
    private Double bunga_persen;

    @Column(name = "status")
    private String status;
}
