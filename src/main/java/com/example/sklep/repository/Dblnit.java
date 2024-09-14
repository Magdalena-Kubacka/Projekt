package com.example.sklep.repository;

import com.example.sklep.model.Item;
import com.example.sklep.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration

public class Dblnit  implements CommandLineRunner {
  private final ItemRepository itemRepository;
@Autowired
  public Dblnit(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  @Override
  public void run(String... args) throws Exception {
  itemRepository.saveAll(List.of(
    new Item("Drzewko bonsai", new BigDecimal("60"), "https://swiat-bonsai.pl/118845-home_default/sosna-drobnokwiatowa.jpg"),
    new Item("Różowa landryna", new BigDecimal("55"), "https://polki.pl/foto/4_3_LARGE/drzewa-kwitnace-na-rozowo-ozdobne-drzewka-z-rozowymi-kwiatami-2468283.webp"),
    new Item("Różowa trawa pompasowa", new BigDecimal("10"), "https://wodne-rosliny.pl/galeria_Zdj/1_1.jpg")
));
  }
}
