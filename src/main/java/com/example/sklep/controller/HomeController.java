package com.example.sklep.controller;

import ch.qos.logback.core.model.Model;
import com.example.sklep.Cart;
import com.example.sklep.ItemOperation;
import com.example.sklep.model.Item;
import com.example.sklep.repository.ItemRepository;
import com.example.sklep.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

  private final CartService cartService;

  @Autowired
  public HomeController(CartService cartService) {
    this.cartService = cartService;
  }

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("items", cartService.getAllItems());
    return "home";
  }

  @GetMapping("/add/{itemId}")
  public String addItemToCart(@PathVariable("itemId") Long itemId, Model model) {
    cartService.itemOperation(itemId, ItemOperation.INCREASE);
    model.addAttribute("items", cartService.getAllItems());
    return "home";
  }
}


