package com.example.sklep.service;

import com.example.sklep.Cart;
import com.example.sklep.ItemOperation;
import com.example.sklep.model.Item;
import com.example.sklep.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class CartService {

  private final ItemRepository itemRepository;
  private final Cart cart;

  @Autowired
  public CartService(ItemRepository itemRepository, Cart cart) {
    this.itemRepository = itemRepository;
    this.cart = cart;
  }

  public List<Item> getAllItems() {

    return itemRepository.findAll();
  }

  public void itemOperation(Long itemId, ItemOperation itemOperation) {
    Optional<Item> oItem = itemRepository.findById(itemId);
    if (oItem.isPresent()) {
      Item item = oItem.get();
      switch (itemOperation) {
        case INCREASE -> cart.addItem(item);
        case DECREASE -> cart.decreaseItem(item);
        case REMOVE -> cart.removeAllItems(item);
        default -> throw new IllegalArgumentException();
      }
    }
  }


}
