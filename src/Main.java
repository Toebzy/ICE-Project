public class Main {
    public static void main(String args[]) {
        Runtime.getRuntime().addShutdownHook(new Gnoxi.Shutdown());
        //Plays music
        //Menu.musicPlayer("Limerence");   //Titles = Cascade - Limerence - It's okay
        new Menu();
        //FileIO.checkForGnoxi(); //runs without menu
    }
}
