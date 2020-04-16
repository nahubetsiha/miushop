package com.ea.miushop.aspect;

import com.ea.miushop.domain.Inventory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InventoryAspect {

    @Pointcut("within(com.ea.miushop.service..*)")
    public void printOutServices() {}

    @Pointcut("args(inventory)")
    public void argsInventory(Inventory inventory) {}

    @Before("printOutServices() && argsInventory(inventory)")
    public void logResourceName(JoinPoint joinPoint, Inventory inventory ) {
        System.out.println();
        System.out.println( "   **********     METHOD NAME (by DGH) : " +
                joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName() +
                "    **********");
        System.out.println( "      ********   USER NAME (by DGH) : " +
                inventory.getInventoryId() + " " + inventory.getVersion() +
                "   ********");
    }

}
