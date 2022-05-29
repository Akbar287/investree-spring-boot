package com.investree.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "payment_history")
public class PaymentHistory implements Serializable {

    private static final long serialVersionUID = 5267477974389610043L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;

    @Column(name = "pembayaran_ke")
    private int pembayaranKe;

    @Column(name = "jumlah")
    private Double jumlah;

    @Column(name = "bukti_pembayaran")
    private String bukti_pembayaran;
}
