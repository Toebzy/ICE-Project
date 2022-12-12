public class Shop {

    private int item1;      //food
    private int item2;
    private int item3;
    private int item4;
    private int item5;      //cosmetic 1
    private int item6;      //cosmetic 2

    public int getItem1() {
        return item1;
    }

    public int getItem2() {
        return item2;
    }

    public int getItem3() {
        return item3;
    }

    public int getItem4() {
        return item4;
    }

    public int getItem5() {
        return item5;
    }

    public int getItem6() {
        return item6;
    }

    public void buy(int itemNumber){
        int balance = FileIO.getGold();
        System.out.println("current balance = "+balance);
        int price = 0;

        if (itemNumber == 1){
            price = 5;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }
            item1++;
        }
        if (itemNumber == 2){
            price = 5;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }
            item2++;
        }
        if (itemNumber == 3){
            price = 10;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }
            item3++;
        }
        if (itemNumber == 4){
            price = 20;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }
            item4++;
        }
        if (itemNumber == 5){
            price = 50;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }
            item5++;
        }
        if (itemNumber == 6){
            price = 100;
            if (balance<price) {
                System.out.println("not enough gold");
                return;
            }
            item6++;
        }

        int newBalance = balance - price;
        System.out.println("Item"+ itemNumber +" bought");
        System.out.println("new balance = " + newBalance);
        GUI.currentGnoxi.setGold(newBalance);
    }



}
