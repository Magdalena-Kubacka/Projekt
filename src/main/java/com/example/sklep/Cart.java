package com.example.sklep;

import com.example.sklep.model.Item;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.spi.ToolProvider.findFirst;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart {
  private List<CartItem> cartItems = new ArrayList<>();
  private int counter = 0;
  private BigDecimal sum = BigDecimal.ZERO;

  public void addItem(Item item) {
    getCartItemByItem(item).ifPresentOrElse(
      CartItem::increaseCounter,
      () -> cartItems.add(new CartItem(item))
    );
    recalculatePriceAndCounter();
//    boolean notFound = true;
//
//    for(CartItem ci:cartItems){
//      if (ci.getItem().getId().equals(item.getId())){
//        notFound = false;
//        ci.increaseCounter();
//        recalculatePriceAndCounter();
//        break;
//      }
//    }
//    if (notFound){
//      cartItems.add(new CartItem(item));
//      recalculatePriceAndCounter();
//    }
  }

  public void decreaseItem(Item item) {
    Optional<CartItem> oCartItem = getCartItemByItem(item);
    if(oCartItem.isPresent()){
      CartItem cartItem = oCartItem.get();
      cartItem.decreaseCounter();
      if(cartItem.hasZeroItems()) {
        removeAllItems(item);
      }else {
        recalculatePriceAndCounter();
      }
    }
  }



  public void removeAllItems(Item item) {
    cartItems.removeIf(i -> i.idEquals(item));
    recalculatePriceAndCounter();
  }

  //    for (CartItem ci: cartItems){
//      if (ci.getItem().getId().equals(item.getId())){
//        ci.decreaseCounter();
//        if (ci.hasZeroItems()){
//          cartItems.remove(ci);
//        }
//        recalculatePriceAndCounter();
//        break;
//      }
//    }
//  }

  private void recalculatePriceAndCounter() {
    sum = cartItems.stream().map(CartItem::getPrice)
      .reduce(BigDecimal.ZERO, BigDecimal::add);
    counter = cartItems.stream().mapToInt(CartItem::getCounter)
      .reduce(0, (a, b) -> a + b);
  }
//  int tempCounter = 0;
//  BigDecimal tempPrice = BigDecimal.ZERO;
//    for(
//  CartItem ci:cartItems)
//  {
//    tempCounter += ci.getCounter();
//    tempPrice = tempPrice.add(ci.getPrice());
//  }
//    this.counter=tempCounter;
//    this.sum =tempPrice;
//}

  private Optional<CartItem> getCartItemByItem(Item item) {
    return cartItems.stream()
      .filter(i -> i.idEquals(item))
      .findFirst();
  }

  public void cleanCart() {
    cartItems.clear();
    counter = 0;
    sum = BigDecimal.ZERO;
  }

}

