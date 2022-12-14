public class Main {
    public static void main(String args[]) {

        Runtime.getRuntime().addShutdownHook(new Gnoxi.Shutdown()); //saves progress if program closes
        Menu.musicPlayer("Limerence");
        new Menu();
        //FileIO.checkForGnoxi(); //runs without menu
    }
}
