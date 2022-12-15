public class Calculator {
    private static FileIO fileIO = new FileIO();
                                                        //calculates new status levels based on offline time
    public static int calcHunger(int hunger)
    {
        int newHunger = (int)Math.round(hunger - (fileIO.getTimeDifference() /1000/60/601.38888888889));
        return newHunger;
    }

    public static int calcAge(int age)
    {
        int newAge = (int)Math.round(age + (fileIO.getTimeDifference()/86400000));
        return newAge;
    }
    public static int calcHappiness(int happiness)
    {
        int newHapiness = (int)Math.round(happiness - (fileIO.getTimeDifference() /1000/60/601.38888888889));
        return newHapiness;
    }
    public static int calcEnergy(int energy)
    {
        int newEnergy = (int)Math.round(energy - (fileIO.getTimeDifference() /1000/60/601.38888888889));
        return newEnergy;
    }
}
