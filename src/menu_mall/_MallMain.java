package menu_mall;

import _mall.MenuCommand;
import controller.MallController;
import dao.FileDAO;
import util.Util;

public class _MallMain implements MenuCommand {


  @Override
  public void init() {
    FileDAO.getInstance().loadData();
  }

  @Override
  public boolean update() {
    System.out.println("=====[쇼핑몰]=====");
    System.out.println("[1] 회원가입\n[2] 로그인\n[0] 종료");
    System.out.println("=================================");
    int menu = Util.getInstance().getValue("▶ 메뉴 입력[0-2] 입력 : ", 0, 2);
    switch (menu) {
      case 0:
        System.out.println("종료");
        System.exit(0);
      case 1:
        MallController.getInstance().setNext("MallJoin");
        break;
      case 2:
        MallController.getInstance().setNext("MallLogin");
        break;
    }

    return false;
  }

}
