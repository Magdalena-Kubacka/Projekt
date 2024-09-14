package com.example.sklep.repository;

import com.example.sklep.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
