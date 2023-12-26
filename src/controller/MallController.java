package controller;

import _mall.MenuCommand;
import menu_admin.AdminBoard;
import menu_admin.AdminItem;
import menu_admin.AdminMember;
import menu_admin._AdminMain;
import menu_mall.MallJoin;
import menu_mall.MallLogin;
import menu_mall._MallMain;
import menu_memeber.*;

import java.util.HashMap;
import java.util.Map;

public class MallController {
  static private final MallController instance = new MallController();
  public Map<String, MenuCommand> mapCont;
  private String loginId;
  private String next;
  private MenuCommand menuCom;
  private MallController() {
  }

  static public MallController getInstance() {
    return instance;
  }

  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public void init() {
    mapCont = new HashMap<>();
    mapCont.put("MallMain", new _MallMain());
    mapCont.put("MallJoin", new MallJoin());
    mapCont.put("MallLogin", new MallLogin());
    mapCont.put("AdminBoard", new AdminBoard());
    mapCont.put("AdminItem", new AdminItem());
    mapCont.put("AdminMain", new _AdminMain());
    mapCont.put("AdminMember", new AdminMember());
    mapCont.put("MemberBoard", new MemberBoard());
    mapCont.put("MemberCart", new MemberCart());
    mapCont.put("MemberInfo", new MemberInfo());
    mapCont.put("MemberMain", new _MemberMain());
    mapCont.put("MemberShopping", new MemberShopping());
    mapCont.put("MemberQuit", new MemberQuit());

    menuCom = mapCont.get("MallMain");
    menuCom.init();
    update();

  }

  public void update() {
    while (true) {
      if (!menuCom.update()) {
        if (next != null) {
          menuCom = mapCont.get(next);
          menuCom.init();
        } else {
          return;
        }
      }
    }
  }

}
