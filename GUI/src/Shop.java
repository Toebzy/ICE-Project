public class Shop {

    private int item1;      //food
    private int item2;
    private int item3;
    private int item4;
    private int item5;      //cosmetic 1
    private int item6;      //cosmetic 2


    public void buy(int itemNumber){
        int balance = 0;// = Gnoxi.getGold();
        int price = 0;

        if (itemNumber == 1){
            price = 5;
            if (balance>price) {
                item1++;
            }
        }
        if (itemNumber == 2){
            price = 5;
            if (balance>price) {
                item2++;
            }
        }
        if (itemNumber == 3){
            price = 10;
            if (balance>price) {
                item3++;
            }
        }
        if (itemNumber == 4){
            price = 20;
            if (balance>price) {
                item4++;
            }
        }
        if (itemNumber == 5){
            price = 50;
            if (balance>price) {
                item5++;
            }
        }
        if (itemNumber == 6){
            price = 100;
            if (balance>price) {
                item6++;
            }
        }

        balance =- price;

    }



}
