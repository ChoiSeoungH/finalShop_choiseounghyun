package menu_mall;

import _mall.MenuCommand;
import dao.MemberDAO;
import dto.Member;
import util.Util;

public class MallJoin implements MenuCommand {


  @Override
  public void init() {

  }

  @Override
  public boolean update() {
    while (true) {

      System.out.println("=====[ 회원가입]=====");
      String id = Util.getInstance().getValue("▶ 아이디 입력 : ");
      for (Member member : MemberDAO.getMemberList()) {
        if (member.getId().equals(id)) {
          System.out.println("이미 사용하는 아이디");
          return false;
        }
      }
      String pw = Util.getInstance().getValue("▶ 비밀번호 입력 : ");
      String name = Util.getInstance().getValue("▶ 이름 입력 : ");
      MemberDAO.getMemberList().add(new Member(id, pw, name));
      System.out.println(MemberDAO.getMemberList());
      return false;
    }

  }

}
