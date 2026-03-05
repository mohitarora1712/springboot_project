package com.lpu.mob.controller;

import com.lpu.mob.dto.MobileDTO;
import com.lpu.mob.entity.Mobile;
import com.lpu.mob.service.MobileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mobiles")
public class MobileController {

    @Autowired
    private MobileService service;

    @PostMapping
    public ResponseEntity<Mobile> addMobile(@Valid @RequestBody MobileDTO dto) {
        return new ResponseEntity<>(service.addMobile(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Mobile>> getAll() {
        return ResponseEntity.ok(service.getAllMobiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mobile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getMobileById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mobile> update(
            @PathVariable Long id,
            @Valid @RequestBody MobileDTO dto) {

        return ResponseEntity.ok(service.updateMobile(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteMobile(id);
        return ResponseEntity.ok("Mobile deleted successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Mobile>> search(
            @RequestParam String brandName) {

        return ResponseEntity.ok(service.searchByBrand(brandName));
    }
}