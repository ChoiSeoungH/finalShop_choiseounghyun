package dao;

import dto.Board;
import util.Util;

import java.util.ArrayList;
import java.util.Collection;

public class BoardDAO {
  private BoardDAO instance = new BoardDAO();
  private static Collection<Board> boardList = new ArrayList<>();

  public BoardDAO getInstance() {
    return instance;
  }

  public static Collection<Board> getBoardList() {
    return boardList;
  }

  private  BoardDAO() {
  }

  public static void loadFromData(String data) {
    String[] temp = data.split("\n");
    for (String s : temp) {
      String[] info = s.split("/");
      boardList.add(new Board(Integer.parseInt(info[0]), info[1], info[2],
          info[3],info[4], Integer.parseInt(info[5])));
    }

  }//eom
}
