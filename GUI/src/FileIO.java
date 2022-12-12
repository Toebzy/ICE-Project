import java.io.*;
import java.util.Scanner;

public class FileIO {
    static File gnoxiFile = new File("Data/GnoxiData.csv");
    static Scanner scan;

    static {
        try {
            scan = new Scanner(gnoxiFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

   public static int getGold() {

       String[] values = new String[0];
       try {
           Scanner scan = new Scanner(gnoxiFile);
           scan.nextLine();
           values = scan.nextLine().split(",");

       } catch (IOException e) {
           System.out.println(e);
       }
       return Integer.parseInt(values[7]);
   }



    public static void checkForGnoxi() {
        if (scan.hasNextLine()) {
            GUI.oldGnoxi();
        }
        else {
            GUI.newGnoxi();
        }
    }

    public static void writeGnoxi(Gnoxi p) {
        try {
            FileWriter writer = new FileWriter("Data/GnoxiData.csv");
            writer.write("name, age, happiness, hunger, poop, energy, birthDate, gold");
            writer.write("\n" + p.getName() + ",0,100,100,0,100," + System.currentTimeMillis()+",5000");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Gnoxi createOldGnoxi() {
        scan.nextLine();
        String[] values = scan.nextLine().split(",");
        Gnoxi p = new Gnoxi(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), Long.parseLong(values[6]), Integer.parseInt(values[7]));
        return p;
    }
}