package dao;

import dto.Cart;
import dto.Item;

import java.util.ArrayList;
import java.util.Collection;

public class ItemDAO {
  private static ItemDAO instance = new ItemDAO();
  private static Collection<Item> itemList = new ArrayList<>();
  private ItemDAO() {
  }

  public static ItemDAO getInstance() {
    return instance;
  }

  public Collection<Item> getItemList() {
    return itemList;
  }

  public static void loadFromData(String data) {
    String[] temp = data.split("\n");
    for (String s : temp) {
      String[] info = s.split("/");
      itemList.add(new Item(Integer.parseInt(info[0]), info[1],
          info[2], Integer.parseInt(info[3])));
    }

  }//eom
}
