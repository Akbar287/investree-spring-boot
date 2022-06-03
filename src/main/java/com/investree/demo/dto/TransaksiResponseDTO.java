package com.investree.demo.dto;

import java.util.Map;

import com.investree.demo.model.Transaksi;

public class TransaksiResponseDTO {
    private String status;
    private String code;
    private Map<Integer, Transaksi> map;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Map<Integer, Transaksi> getMap() {
        return map;
    }
    public void setMap(Map<Integer, Transaksi> map) {
        this.map = map;
    }
}
