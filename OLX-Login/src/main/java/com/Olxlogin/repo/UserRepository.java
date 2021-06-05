package com.Olxlogin.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Olxlogin.Entity.UserEntity;



@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	List<UserEntity> findByUserName(String userName);
}
