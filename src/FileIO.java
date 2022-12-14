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
            writer.write("name, age, happiness, hunger, energy, birthDate, gold, isSleeping, gnoxiType, closingTime");
            writer.write("\n" + p.getName() + ",0,100,100,100," + System.currentTimeMillis()+",500,false, gnoxiType");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static Gnoxi createOldGnoxi() {
        scan.nextLine();
        String[] values = scan.nextLine().split(",");
        Gnoxi p = new Gnoxi(values[0], Calculator.calcAge(Integer.parseInt(values[1])), Calculator.calcHapiness(Integer.parseInt(values[2])), Calculator.calcHunger(Integer.parseInt(values[3])), Calculator.calcEnergy(Integer.parseInt(values[4])), Long.parseLong(values[5]), Integer.parseInt(values[6]),Boolean.parseBoolean(values[7]), values[8]);
        return p;
    }
    public long getTimeDifference() {
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
   /* public static Gnoxi createOldGnoxi() {
        scan.nextLine();
        String[] values = scan.nextLine().split(",");
        Gnoxi p = new Gnoxi(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), Long.parseLong(values[6]), Integer.parseInt(values[7]));
        return p;
    }*/
}