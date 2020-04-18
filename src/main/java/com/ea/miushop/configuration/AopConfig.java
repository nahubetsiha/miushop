package com.ea.miushop.configuration;

import com.ea.miushop.aspect.InventoryAspect;
import com.ea.miushop.domain.Inventory;
import com.ea.miushop.service.InventoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

//    @Bean
//    public InventoryService inventoryService() {
//        return new InventoryService() {
//        };
//    }

    @Bean
    public InventoryAspect myAspect() {
        return new InventoryAspect();
    }
}
