import java.io.*;
import java.util.Date;
import java.net.*;

public class SaveDate {

  public static void main(String argv[]) throws Exception {
    FileOutputStream fos = new FileOutputStream("dates.out");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
      Date[] dates = new Date[10];
      for(int x=0;x<10;x++){
          dates[x] = new Date();
          oos.writeObject(dates[x]);
      }
    oos.flush();
    oos.close();
    fos.close();
  }
}
