package com.ea.miushop.domain;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "pickup_time")
public class PickupTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pickupTimeId;

    private LocalTime pickupTime;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "pickup_schedule_id")
    private PickupSchedule pickupSchedule;

    public PickupTime() {
    }

    public Long getPickupTimeId() {
        return pickupTimeId;
    }

    public void setPickupTimeId(Long pickupTimeId) {
        this.pickupTimeId = pickupTimeId;
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PickupSchedule getPickupSchedule() {
        return pickupSchedule;
    }

    public void setPickupSchedule(PickupSchedule pickupSchedule) {
        this.pickupSchedule = pickupSchedule;
    }
}
