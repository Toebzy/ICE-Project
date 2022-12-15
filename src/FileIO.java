import java.io.*;
import java.util.Scanner;

public class FileIO {
    static File gnoxiFile = new File("Data/GnoxiData.csv");
    static Scanner scan;
    static Scanner scan2;
    static Scanner scan3;

    public static void checkForGnoxi() {
        try {
        scan2 = new Scanner(gnoxiFile);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
        if (scan2.hasNextLine()) {
            GUI.oldGnoxi(); //loads old gnoxi if csv is written
        }
        else {
            GUI.newGnoxi(); //opposite ;))
        }
    }
    public static String saveExists(){
        try {
            scan3 = new Scanner(gnoxiFile);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
       if(scan3.hasNextLine()){
           return ("Continue game");
       }                            //changes start game button if there is a save
       return ("Start new game");
    }

    public static void writeGnoxi(Gnoxi p) {
        try {
            FileWriter writer = new FileWriter("Data/GnoxiData.csv");           //writes new gnoxi to csv
            writer.write("name, age, happiness, hunger, energy, birthDate, gold, isSleeping, gnoxiType, closingTime, bow, tophat, scarf");
            writer.write("\n" + p.getName() + ",0,100,100,100," + System.currentTimeMillis()+",0,false,gnoxiType,false,false,false");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void deleteSave(){
        try {                           //deletes everything from csv
            new FileWriter("Data/GnoxiData.csv", false).close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public static Gnoxi createOldGnoxi() {
        try {                                       //sets csv data to Gnoxi.currentGnoxi
            scan = new Scanner(gnoxiFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scan.nextLine();
        String[] values = scan.nextLine().split(",");
        Gnoxi p = new Gnoxi(values[0], Calculator.calcAge(Integer.parseInt(values[1])), Calculator.calcHappiness(Integer.parseInt(values[2])), Calculator.calcHunger(Integer.parseInt(values[3])), Calculator.calcEnergy(Integer.parseInt(values[4])), Long.parseLong(values[5]), Integer.parseInt(values[6]),Boolean.parseBoolean(values[7]), values[8], Boolean.parseBoolean(values[10]), Boolean.parseBoolean(values[11]), Boolean.parseBoolean(values[12]));
        return p;
    }
    public long getTimeDifference() {       //gets time between program launches
        try {
            Scanner scanner = new Scanner(gnoxiFile);
            scanner.nextLine();
            String[] values = scanner.nextLine().split(",");
            return System.currentTimeMillis() - Long.parseLong(values[9]);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}