package com.investree.demo.view;

import java.util.Map;

import com.investree.demo.model.Transaksi;

public interface TransaksiService {
    public void save(Map<Integer, Transaksi> transaksi);
    public void update(Map<Integer, Transaksi> transaksi);
}
