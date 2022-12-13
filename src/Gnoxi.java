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

    public Gnoxi(String name, int age, int happiness, int hunger, int energy, long birthDate, int gold, boolean sleeping) {

        this.name = name;
        this.age = age;
        this.happiness = happiness;
        this.hunger = hunger;
        this.energy = energy;
        this.birthDate = birthDate;
        this.gold = gold;
        this.sleeping=sleeping;

    }

    public static String gnoxiType(){
        int i = (int) (Math.random()*10);
        if(i==1 || i==2 || i==3){
            return ("Media/Gnoxi/gnoxiDuck.png"); //30%
        }
        if(i==4 || i==5 || i==6 || i==7){
            return ("Media/Gnoxi/gnoxiBear.png");   //40%     (49%total)
        }
        if(i==8){

            int k = (int) (Math.random()*10);
            if(k==10) {
                return ("Media/Gnoxi/gnoxiGnoxi.png"); //1%
            }               //easter egg
            else{
                return ("Media/Gnoxi/gnoxiBear.png");   //9%
            }
        }
        return ("Media/Gnoxi/gnoxiRabbit.png");     //20%
    }


    public int getAge() {
        long a = (System.currentTimeMillis() - this.birthDate) / 1000;
        int currentAge = (int) a / 60 / 60 / 24;
        return currentAge;
    }

    static class Shutdown extends Thread{
        public void run() {
            try {
                FileWriter writer = new FileWriter("Data/GnoxiData.csv");
                writer.write("name, age, happiness, hunger, energy, birthDate, gold, isSleeping, closingTime");
                writer.write("\n"+ GUI.currentGnoxi.name+ "," +GUI.currentGnoxi.age+","+GUI.currentGnoxi.happiness+","+GUI.currentGnoxi.hunger+","+GUI.currentGnoxi.energy+"," + GUI.currentGnoxi.birthDate + ","+ GUI.currentGnoxi.gold+","+GUI.currentGnoxi.sleeping+"," + System.currentTimeMillis());
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
