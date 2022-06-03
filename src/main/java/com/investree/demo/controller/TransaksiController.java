package com.investree.demo.controller;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.investree.demo.dto.TransaksiCreateRequestDTO;
import com.investree.demo.model.Transaksi;
import com.investree.demo.view.TransaksiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transaksi")
public class TransaksiController {
    @Autowired
    private TransaksiService transaksiService;

    @GetMapping("/list")
    public ResponseEntity<Page<Transaksi>> list(@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "3") int size, @RequestParam(value="status", required=false) String status) {
        Page<Transaksi> map = transaksiService.list(page, size, status);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @PostMapping
    public ResponseEntity<Map> save(@RequestBody TransaksiCreateRequestDTO dto) throws URISyntaxException {
        Map<Integer, Transaksi> map = transaksiService.save(dto);
        Map<String, Object> response = new HashMap<>();
        response.put("data", map);
        response.put("status", "sukses");
        response.put("code", "200");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<Map> updateStatus(@PathVariable("transaksiId") Long transaksiId) {
        Map<Integer, Transaksi> map = transaksiService.update(transaksiId);
        Map<String, Object> response = new HashMap<>();
        response.put("data", map);
        response.put("status", "sukses");
        response.put("code", "200");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
