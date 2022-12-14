import java.io.FileWriter;
import java.io.IOException;

public class Gnoxi {

    public int gold;           //balance
    public String gnoxiType;
    private String name;
    private int age;
    private int hunger;        //0-100
    private long birthDate;
    private int happiness;     //0-100
    private int energy;        //0-100
    private boolean sleeping;
    private boolean bow;
    private boolean tophat;
    private boolean scarf;



    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public int getHappiness() {
        return happiness;
    }
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }



    public int getEnergy() {
        return energy;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean getSleeping() {
        return sleeping;
    }

    public void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }

    public Gnoxi(String name, int age, int happiness, int hunger, int energy, long birthDate, int gold, boolean sleeping, String gnoxiType, boolean bow, boolean tophat, boolean scarf) {

        this.name = name;
        this.age = age;
        this.happiness = happiness;
        this.hunger = hunger;
        this.energy = energy;
        this.birthDate = birthDate;
        this.gold = gold;
        this.sleeping=sleeping;
        this.gnoxiType=gnoxiType;
        this.bow = bow;
        this.tophat = tophat;
        this.scarf = scarf;

    }

    public static String gnoxiType(){
        int i = (int) (Math.random()*10);
        if(i==1 || i==2 || i==3){
            return ("gnoxiDuck"); //30%   (39%total)
        }
        if(i==4 || i==5 || i==6 || i==7){
            return ("gnoxiBear");   //40%
        }
        if(i==8){
            int k = (int) (Math.random()*10);
            if(k==10) {
                return ("gnoxiGnoxi"); //1%
            }               //easter egg
            else{
                return ("gnoxiDuck");   //9%
            }
        }
        return ("gnoxiRabbit");     //20%
    }


    public boolean isBow() {
        return bow;
    }
    public boolean isTophat() {
        return tophat;
    }
    public boolean isScarf() {
        return scarf;
    }

    public void setBow(boolean bow) {
        this.bow = bow;
    }
    public void setTophat(boolean tophat) {
        this.tophat = tophat;
    }
    public void setScarf(boolean scarf) {
        this.scarf = scarf;
    }

    public int getAge() {
        return age;
    }
    public static void save() {
        try {
            if(GUI.currentGnoxi !=null) {
                FileWriter writer = new FileWriter("Data/GnoxiData.csv");
                writer.write("name, age, happiness, hunger, energy, birthDate, gold, isSleeping, gnoxiType, closingTime, bow, tophat, scarf");
                writer.write("\n" + GUI.currentGnoxi.name + "," + GUI.currentGnoxi.age + "," + GUI.currentGnoxi.happiness + "," + GUI.currentGnoxi.hunger + "," + GUI.currentGnoxi.energy + "," + GUI.currentGnoxi.birthDate + "," + GUI.currentGnoxi.gold + "," + GUI.currentGnoxi.sleeping + "," + GUI.currentGnoxi.gnoxiType + "," + System.currentTimeMillis() + "," + GUI.currentGnoxi.bow+ "," + GUI.currentGnoxi.tophat+ "," + GUI.currentGnoxi.scarf);
                writer.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static class Shutdown extends Thread{
        public void run() {
            try {
                if(GUI.currentGnoxi !=null) {
                    FileWriter writer = new FileWriter("Data/GnoxiData.csv");
                    writer.write("name, age, happiness, hunger, energy, birthDate, gold, isSleeping, gnoxiType, closingTime, bow, tophat, scarf");
                    writer.write("\n" + GUI.currentGnoxi.name + "," + GUI.currentGnoxi.age + "," + GUI.currentGnoxi.happiness + "," + GUI.currentGnoxi.hunger + "," + GUI.currentGnoxi.energy + "," + GUI.currentGnoxi.birthDate + "," + GUI.currentGnoxi.gold + "," + GUI.currentGnoxi.sleeping + "," + GUI.currentGnoxi.gnoxiType + "," + System.currentTimeMillis() + "," + GUI.currentGnoxi.bow+ "," + GUI.currentGnoxi.tophat+ "," + GUI.currentGnoxi.scarf);
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
