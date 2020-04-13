package com.ea.miushop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ea.miushop.domain.Category;

public interface UserRepository extends JpaRepository<Category, Long> {

}
