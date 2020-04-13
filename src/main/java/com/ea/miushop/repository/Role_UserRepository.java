package com.ea.miushop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ea.miushop.domain.Category;

public interface Role_UserRepository extends JpaRepository<Category, Long> {

}
