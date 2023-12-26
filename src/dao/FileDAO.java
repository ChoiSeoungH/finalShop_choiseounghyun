package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDAO {

  private final String CUR_PATH = System.getProperty("user.dir")+"\\src\\files\\";
  private static final FileDAO instance = new FileDAO();

  private FileDAO() {
  }

  static public FileDAO getInstance() {
    return instance;
  }

  private void createFile(FileName name) {
    Path path = Paths.get("src/files/" + name.getName());
    try {
      Files.createFile(path);
    } catch (IOException e) {
      //System.out.println("파일이 이미 있음");
    }
  }

  private void init() {

    createFile(FileName.BOARD);
    createFile(FileName.MEMBER);
    createFile(FileName.ITEM);
    createFile(FileName.CART);

  }

  enum FileName {
    BOARD("board.txt"), MEMBER("member.txt"), ITEM("item.txt"), CART("cart.txt");
    private final String name;

    FileName(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }


  }

  private String loadFile(String fileName) {
    String data = "";

    try (BufferedReader br = new BufferedReader(new FileReader(CUR_PATH+fileName))){
      while (true) {
        String line = br.readLine();
        if (line==null) break;
        data += line+"\n";
      }
      return data;
    } catch (Exception e) {
      System.out.println("로드 실패");
    }
    return data;
  }
  public void loadData() {
    String boardData = loadFile(FileName.BOARD.name);
    String cartData = loadFile(FileName.CART.name);
    String itemData = loadFile(FileName.ITEM.name);
    String memberData = loadFile(FileName.MEMBER.name);

    BoardDAO.loadFromData(boardData);
    CartDAO.loadFromData(cartData);
    ItemDAO.loadFromData(itemData);
    MemberDAO.loadFromData(memberData);
    System.out.println("== 데이터 로드 완료 ==");
  }

  public void saveData() {



  }

  public void saveFile() {

  }

}
