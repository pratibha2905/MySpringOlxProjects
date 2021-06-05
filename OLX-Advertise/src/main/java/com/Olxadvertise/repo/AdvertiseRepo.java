package com.Olxadvertise.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Olxadvertise.entity.AdvertiseEntity;

public interface AdvertiseRepo extends JpaRepository<AdvertiseEntity, Long>{
	
	public List<AdvertiseEntity> findByUsername(String username);
}
