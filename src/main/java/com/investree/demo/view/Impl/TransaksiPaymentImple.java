package com.investree.demo.view.Impl;

import java.util.HashMap;
import java.util.Map;

import com.investree.demo.dto.TransaksiCreateRequestDTO;
import com.investree.demo.model.Transaksi;
import com.investree.demo.model.Users;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.repository.UserRepository;
import com.investree.demo.view.TransaksiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaksiPaymentImple implements TransaksiService{

    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Map<Integer, Transaksi> save(TransaksiCreateRequestDTO dto) {
        Users peminjam = userRepository.findById(dto.getPeminjam()).orElseThrow();
        Users meminjam = userRepository.findById(dto.getMeminjam()).orElseThrow();

        Transaksi transaksi = new Transaksi();
        transaksi.setPeminjam(peminjam);
        transaksi.setMeminjam(meminjam);
        transaksi.setBunga_persen(dto.getBunga_persen());
        transaksi.setTenor(dto.getTenor());
        transaksi.setStatus("BELUM LUNAS");
        transaksi.setTotal_pinjaman(dto.getTotal_pinjaman());
        transaksiRepository.save(transaksi);
        
        Map<Integer, Transaksi> map = new HashMap<>();
        map.put(1, transaksi);
        return map;
    }

    @Override
    public Map<Integer, Transaksi> update(Long transaksiId) {
        Transaksi transaksi = transaksiRepository.findById(transaksiId).orElseThrow();
        transaksi.setStatus("LUNAS");
        transaksiRepository.save(transaksi);
        
        Map<Integer, Transaksi> map = new HashMap<>();
        map.put(1, transaksi);
        return map;
    }
    
    
    @Override
    public Page<Transaksi> list(int page, int size, String status) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Transaksi> transaksis;
        transaksis = transaksiRepository.findAll(pageable);
        return transaksis;
    }
    
}
