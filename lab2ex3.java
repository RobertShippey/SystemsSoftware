//Using a space separated value file write a program to read music tracks into the program and let the user select / edit details about the tracks before writing the modified file back to disk. The file should follow the format: Track Name Genre Length(seconds).
//4. Modify the program in 3 to allow the user to add a ‘rating’, ‘cost’ and ‘played count’ to the track information. Give the user the option to select tracks under a certain value.
import java.util.*;
import java.io.*;

public class lab2ex3 {
    
    public static void main(String[] args) throws FileNotFoundException{
        List<track> tracksLL = new ArrayList<track>();
        BufferedReader filein = new BufferedReader(new FileReader("tracks.txt"));
       
        String t;
        try{
        while(filein.ready()){
            try{
                track m = new track();
            t = filein.readLine();
            System.out.println(t);
            m.setName(t.substring(0,t.indexOf(' ')));
            t = t.substring(t.indexOf(' '));
            t = t.trim();
            m.setGenre(t.substring(0,t.indexOf(' ')));
            t = t.substring(t.indexOf(' '));
            t = t.trim();
            m.setDuration(Integer.parseInt(t));
                          
            tracksLL.add(m);
            } catch (IOException ex){
                continue;
            }catch (StringIndexOutOfBoundsException sioobe) {
                System.err.println("There's some line endings trailing after the text. Get rid!");
                continue;
            }
        }}catch (IOException e){}

        track tracks[] = tracksLL.toArray(new track[tracksLL.size()]);
        
        System.out.println("Select a track:");
        for(int x =0;x<tracks.length;x++){
            System.out.println(x + ") " + tracks[x].getName());
        }
        
    }
    
}