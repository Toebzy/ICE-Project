public class Calculator {
    private static FileIO fileIO = new FileIO();

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
    public static int calcHapiness(int hapiness)
    {
        int newHapiness = (int)Math.round(hapiness - (fileIO.getTimeDifference() /1000/60/601.38888888889));
        return newHapiness;
    }

    public static int calcPoop(int poop)
    {
        int newPoop = (int)Math.round(poop + (fileIO.getTimeDifference() /1000/60/601.38888888889));
        return newPoop;
    }

    public static int calcEnergy(int energy)
    {
        int newEnergy = (int)Math.round(energy - (fileIO.getTimeDifference() /1000/60/601.38888888889));
        return newEnergy;
    }
}
