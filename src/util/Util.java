package util;


import java.util.Scanner;

public class Util {
  private static final Scanner sc = new Scanner(System.in);

  private static Util instance = new Util();
  private Util() {
  }

  public static Util getInstance() {
    return instance;
  }

  public String getValue(String msg) {
    System.out.print(msg);
    return sc.next();
  }//eom
  public int getValue(String msg,int start,int end) {
    while (true) {
      try {
        System.out.print(msg);
        int val = sc.nextInt();
        if (val<start || val>end) {
          System.out.printf("[%d ~ %d]사이의 값 입력",start,end);
          continue;
        }
        return val;
      } catch (Exception e) {
        sc.nextLine();
        System.out.println("정수값을 입력하세요");
      }//eot
    }//eow
  }//eom



  public static void closeScanner() {
    sc.close();
  }//eom

}//eoc
