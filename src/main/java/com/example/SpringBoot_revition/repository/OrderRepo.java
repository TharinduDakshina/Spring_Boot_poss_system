package com.example.SpringBoot_revition.repository;

import com.example.SpringBoot_revition.entity.Orders;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {

}
