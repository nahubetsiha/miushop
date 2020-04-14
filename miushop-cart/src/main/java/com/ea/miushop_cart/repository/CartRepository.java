package com.ea.miushop_cart.repository;

import com.ea.miushop_cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
