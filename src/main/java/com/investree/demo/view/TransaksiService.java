package com.investree.demo.view;

import java.util.Map;

import com.investree.demo.dto.TransaksiCreateRequestDTO;
import com.investree.demo.model.Transaksi;

public interface TransaksiService {
    public Map<Integer, Transaksi> save(TransaksiCreateRequestDTO dto);
    public Map<Integer, Transaksi>update(Long transaksiId);
}
