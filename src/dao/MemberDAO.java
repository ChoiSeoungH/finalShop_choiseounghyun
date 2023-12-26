package dao;

import dto.Item;
import dto.Member;

import java.util.ArrayList;
import java.util.Collection;

public class MemberDAO {
  private static MemberDAO instance = new MemberDAO();
  private static Collection<Member> memberList = new ArrayList<>();

  private MemberDAO() {
  }

  public static MemberDAO getInstance() {
    return instance;
  }

  public static Collection<Member> getMemberList() {
    return memberList;
  }

  public static void loadFromData(String data) {
    String[] temp = data.split("\n");
    for (String s : temp) {
      String[] info = s.split("/");
      memberList.add(new Member(Integer.parseInt(info[0]), info[1],
          info[2], info[3]));
    }

  }//eom
}
