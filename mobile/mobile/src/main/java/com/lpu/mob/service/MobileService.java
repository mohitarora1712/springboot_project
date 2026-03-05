package com.lpu.mob.service;

import com.lpu.mob.dto.MobileDTO;
import com.lpu.mob.entity.Mobile;
import com.lpu.mob.exception.ResourceNotFoundException;
import com.lpu.mob.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileService {

    @Autowired
    private MobileRepository repository;

    private Mobile convertToEntity(MobileDTO dto) {
        Mobile mobile = new Mobile();
        mobile.setBrandName(dto.getBrandName());
        mobile.setModelName(dto.getModelName());
        mobile.setPrice(dto.getPrice());
        mobile.setRam(dto.getRam());
        mobile.setStorage(dto.getStorage());
        mobile.setColor(dto.getColor());
        return mobile;
    }

    public Mobile addMobile(MobileDTO dto) {
        return repository.save(convertToEntity(dto));
    }

    @Cacheable("mobiles")
    public List<Mobile> getAllMobiles() {
        return repository.findAll();
    }

    public Mobile getMobileById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Mobile not found with id: " + id));
    }

    public Mobile updateMobile(Long id, MobileDTO dto) {

        Mobile mobile = getMobileById(id);

        mobile.setBrandName(dto.getBrandName());
        mobile.setModelName(dto.getModelName());
        mobile.setPrice(dto.getPrice());
        mobile.setRam(dto.getRam());
        mobile.setStorage(dto.getStorage());
        mobile.setColor(dto.getColor());

        return repository.save(mobile);
    }

    @CacheEvict(value = "mobiles", allEntries = true)
    public void deleteMobile(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Mobile not found with id: " + id);
        }

        repository.deleteById(id);
    }

    public List<Mobile> searchByBrand(String brandName) {
        return repository.findByBrandNameIgnoreCase(brandName);
    }
}