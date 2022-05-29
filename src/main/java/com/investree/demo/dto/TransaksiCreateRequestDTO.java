package com.investree.demo.dto;

public class TransaksiCreateRequestDTO {
    private Long peminjam;
    private Long meminjam;
    private int tenor;
    private Double total_pinjaman;
    private Double bunga_persen;
    public Long getPeminjam() {
        return peminjam;
    }
    public void setPeminjam(Long peminjam) {
        this.peminjam = peminjam;
    }
    public Long getMeminjam() {
        return meminjam;
    }
    public void setMeminjam(Long meminjam) {
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
}
