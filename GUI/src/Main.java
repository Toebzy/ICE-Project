public class Main {
    public static void main(String args[]) {
        Thread thread = new Thread(new Runnable() {
            @Override
           public void run() {
                decreaseNumbers();
            }
        });

        // Start the thread
        thread.start();

        // Run other functions here
        new Menu(); //starts menu
        // Wait for the thread to finish before ending the program
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void decreaseNumbers() {
        int number = 0;
        while (true) {
            // Increase the number by 1
            number++;

            // Print the number
            System.out.println(number);

            // Wait for 10 seconds
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
