package com.ea.miushop_cart.repository;

import com.ea.miushop_cart.model.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<OrderedItem, Long> {
}
