package com.investree.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.investree.demo.model.Transaksi;
import com.investree.demo.model.Users;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.repository.UserRepository;
import com.investree.demo.view.TransaksiService;

public class TestingController {

    @InjectMocks
    TransaksiService transaksiService;

    @Mock
    TransaksiRepository transaksiRepository;
    
    @Autowired
    private UserRepository userRepository;

    public void restTemplateSave () {
        Users meminjam = userRepository.findById(1L).orElseThrow(()->new Error("user.not.found"));
        Users peminjam = userRepository.findById(2L).orElseThrow(()->new Error("user.not.found"));

        Transaksi transaksi = new Transaksi();
        transaksi.setBunga_persen(5.0);
        transaksi.setMeminjam(meminjam);
        transaksi.setPeminjam(peminjam);
        transaksi.setStatus("LUNAS");
        transaksi.setTenor(3);
        transaksi.setTotal_pinjaman(3000000.0);
        verify(transaksiRepository, times(1));
    }
}
