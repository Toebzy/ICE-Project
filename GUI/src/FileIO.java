import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileIO {

    Scanner scan = new Scanner("Data/GnoxiData.csv");

    public boolean checkForGnoxi()
    {
        scan.nextLine();
        if(scan.hasNext()) {

            return false;
        }

        return true;
    }
    public void writeNewGnoxiToCSV(String name)
    {
      writeWithoutOverwrite(name + "0, 10, 0, 0, 10, " + System.currentTimeMillis());
    }

    public void createOldGnoxi()
    {
        try {
            BufferedReader read = new BufferedReader(new FileReader("Data/GnoxiData.csv"));
            read.readLine();
            String str = read.readLine();
            str = str.replace(" ", "");
            String gnoxi[] = str.split(",");
            String name = gnoxi[0];
            for(String s : gnoxi)
            {
                System.out.println(s);
            }
            int age = Integer.parseInt(gnoxi[1]);
            int happiness = Integer.parseInt(gnoxi[2]);
            int hunger = Integer.parseInt(gnoxi[3]);
            int poop = Integer.parseInt(gnoxi[4]);
            int energy = Integer.parseInt(gnoxi[5]);
            long birthday = Long.parseLong(gnoxi[6]);
            Gnoxi gnoxi1 = new Gnoxi(name, age, happiness, hunger, poop, energy, birthday);
            System.out.println(gnoxi1.getName() + " " + gnoxi1.getAge() + " " + gnoxi1.getBirthDate());
        }
        catch(IOException e){
            System.out.println(e);
        }

    }


    public void writeWithoutOverwrite(String str)
    {
        try {
            FileWriter fileWriter = new FileWriter("Data/GnoxiData.csv",true);
            BufferedWriter out = new BufferedWriter(fileWriter);
            out.write("\n" + str);
            out.close();
        }
        catch(IOException e){
            System.out.println(e);
        }

    }

}