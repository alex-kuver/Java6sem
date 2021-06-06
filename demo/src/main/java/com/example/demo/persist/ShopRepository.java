package com.example.demo.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ShopRepository extends JpaRepository<ShopProgram, Long>
{
}
