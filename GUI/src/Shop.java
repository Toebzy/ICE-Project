public class Shop {



    public void buy(int itemNumber){
        int balance = GUI.currentGnoxi.getGold();
        int price = 0;

        if (itemNumber == 1){
            price = 5;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }

        }
        if (itemNumber == 2){
            price = 15;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }

        }
        if (itemNumber == 3){
            price = 10;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }

        }
        if (itemNumber == 4){
            price = 20;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }

        }
        if (itemNumber == 5){
            price = 50;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }

        }
        if (itemNumber == 6){
            price = 100;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }

        }

        int newBalance = balance - price;
        GUI.currentGnoxi.setGold(newBalance);
    }



}
