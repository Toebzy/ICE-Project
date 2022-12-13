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
    private int poop;          //0-100
    private int energy;        //0-100


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

    public int getPoop() {
        return poop;
    }

    public int getEnergy() {
        return energy;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }



    public Gnoxi(String name, int age, int happiness, int hunger, int poop, int energy, long birthDate, int gold) {

        this.name = name;
        this.age = age;
        this.happiness = happiness;
        this.hunger = hunger;
        this.poop = poop;
        this.energy = energy;
        this.birthDate = birthDate;
        this.gold = gold;

    }

    public static String gnoxiType(){
        int i = (int) (Math.random()*10);
        if(i==1 || i==2 || i==3){
            return ("Media/Gnoxi/gnoxiDuck.png"); //30%
        }
        if(i==4 || i==5 || i==6 || i==7){
            return ("Media/Gnoxi/gnoxiBear.png");   //40%
        }
        if(i==8){
            int k = (int) (Math.random()*10);
            System.out.println(k);
            if(k==10) {
                return ("Media/Gnoxi/gnoxiGnoxi.png"); //1%
            }               //easter egg
            else{
                return ("Media/Gnoxi/gnoxiBear.png");   //9%
            }
        }
        return ("Media/Gnoxi/gnoxiRabbit.png");     //20%
    }

    public void doSleep() {
        energy += 9;
        doActivity();
        randomEvent();
        System.out.println(name + "is well rested");

    }

    public void doActivity() {
        happiness++;
        if (happiness == 0) {
          //  GUI.death();
        }
        energy--;
        if (energy < 10) {
            energy = 10;
        }
        hunger++;
        if (hunger < 10) {
            hunger = 10;
        }
        poop++;
        if (poop <= 10) {
            doPoop();
        }
    }

    public void doPoop() {
        if (poop < 10) {
            poop = 10;
        }
        if (poop < 4) {
            System.out.println(name + "does not need to poop");
        } else if (poop >= 4 && poop < 10 ) {
            if (poop <= 8){
                happiness--;
            }

            poop =0;
            happiness ++;
            hunger ++;
            energy --;
            System.out.println(name + " is pooping");
        } else if (poop == 10) {
            happiness =-7;
            poop = 0;
            System.out.println(name + "shat his silly pants");
        }
    }

    public int getAge() {
        long a = (System.currentTimeMillis() - this.birthDate) / 1000;
        int currentAge = (int) a / 60 / 60 / 24;
        return currentAge;
    }

    private void randomEvent() {
        switch ((int) (Math.random() * 20)) {   //random number 0-20

            case 1: {
                System.out.println(name + " is feeling sick");
                energy --;
                happiness --;
                poop ++;
                hunger ++;
            }
            case 2: happiness ++;
            case 3: happiness --;
            case 4: hunger ++;
            case 5: poop ++;
            case 6: energy ++;
            case 7: energy --;
            case 8: gold++;

            default: break;
        }
    }
    static class Shutdown extends Thread{
        public void run() {
            try {
                FileWriter writer = new FileWriter("Data/GnoxiData.csv");
                writer.write("name, age, happiness, hunger, poop, energy, birthDate, gold, closingTime");
                writer.write("\n"+ GUI.currentGnoxi.name+ "," +GUI.currentGnoxi.age+","+GUI.currentGnoxi.happiness+","+GUI.currentGnoxi.hunger+","+GUI.currentGnoxi.poop+","+GUI.currentGnoxi.energy+"," + GUI.currentGnoxi.birthDate + ","+ GUI.currentGnoxi.gold+"," + System.currentTimeMillis());
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}