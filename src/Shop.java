public class Shop {
    public boolean buy(int itemNumber){
        int balance = GUI.currentGnoxi.getGold();
        int price = 0;

        if (itemNumber == 1){
            price = 5;
            if (balance<price) {
                return false;
            }

        }
        if (itemNumber == 2){
            price = 15;
            if (balance<price) {
                return false;
            }

        }
        if (itemNumber == 3){
            price = 25;
            if (balance<price) {
                return false;
            }

        }
        if (itemNumber == 4){
            price = 20;
            if (balance<price) {
                return false;
            }

        }
        if (itemNumber == 5){
            price = 500;
            if (balance<price) {
                return false;
            }

        }
        if (itemNumber == 6){
            price = 1200;
            if (balance<price) {
                return false;
            }

        }
        int newBalance = balance - price;
        GUI.currentGnoxi.setGold(newBalance);
        return true;
    }
}
