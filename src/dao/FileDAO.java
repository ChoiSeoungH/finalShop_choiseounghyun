package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDAO {


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


}
