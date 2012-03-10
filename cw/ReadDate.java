import java.io.*;
import java.util.Date;

public class ReadDate {

  public static void main(String argv[]) throws Exception {
    FileInputStream fis = new FileInputStream("dates.out");
    ObjectInputStream ois = new ObjectInputStream(fis);
      Date[] date = new Date[10];
      for(int x=0;x<10;x++){
          date[x] = (Date) ois.readObject();
      }
      
      for(int x=0;x<date.length;x++){
          System.out.println("The date is: "+date[x]);
      }
    
    ois.close();
    fis.close();
  }
}
