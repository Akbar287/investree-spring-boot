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

@Entity
@Table(name = "transaksi")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PaymentHistory> getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(List<PaymentHistory> paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public Users getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(Users peminjam) {
        this.peminjam = peminjam;
    }

    public Users getMeminjam() {
        return meminjam;
    }

    public void setMeminjam(Users meminjam) {
        this.meminjam = meminjam;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public Double getTotal_pinjaman() {
        return total_pinjaman;
    }

    public void setTotal_pinjaman(Double total_pinjaman) {
        this.total_pinjaman = total_pinjaman;
    }

    public Double getBunga_persen() {
        return bunga_persen;
    }

    public void setBunga_persen(Double bunga_persen) {
        this.bunga_persen = bunga_persen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
