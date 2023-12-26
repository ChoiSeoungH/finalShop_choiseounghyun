package dao;

import dto.Board;
import dto.Cart;

import java.util.ArrayList;
import java.util.Collection;

public class CartDAO {
  private static CartDAO instance = new CartDAO();
  private static Collection<Cart> cartList = new ArrayList<>();
  private CartDAO() {
  }

  public static CartDAO getInstance() {
    return instance;
  }

  public Collection getCartList() {
    return cartList;
  }

  public static void loadFromData(String data) {
      String[] temp = data.split("\n");
      for (String s : temp) {
        String[] info = s.split("/");
        cartList.add(new Cart(Integer.parseInt(info[0]), info[1],
            Integer.parseInt(info[2]), Integer.parseInt(info[3])));
      }

    }//eom
}
