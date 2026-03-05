package com.lpu.mob.repository;

import com.lpu.mob.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MobileRepository extends JpaRepository<Mobile, Long> {

    List<Mobile> findByBrandNameIgnoreCase(String brandName);
}