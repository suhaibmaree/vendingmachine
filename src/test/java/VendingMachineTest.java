import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineTest {

    public static MoneyWallet wallet = MoneyWallet.getInstance();
    public static ItemHolder itemHolder = ItemHolder.getInstance();


    @Test
    public void checkValidOrderTest() throws Exception {

        Item Coffee = new Item(1, 5, 0);
        Item Nescafe = new Item(2, 6, 5);
        Item Milk = new Item(3, 12, 5);
        Item Tea = new Item(5, 3, 0);
        Item Water = new Item(6, 3, 5);

        List<Item> itemList = new ArrayList<>();
        itemList.add(Coffee);
        itemList.add(Nescafe);
        itemList.add(Milk);
        itemList.add(Tea);
        itemList.add(Water);
        itemHolder.setItemList(itemList);

        Money money = new Money(1, 4, 0, 1, 0, 0, 0);
        wallet.setMyMoney(new Money(100, 100, 100, 100, 100, 100, 100));

        boolean itemstate = VendingMachine.checkOrder(100);

        Assert.assertEquals(false, itemstate);

    }

    @Test
    public void InsertEnoughMoneyAndEnoughWallet() throws Exception { // fails

        Money money = new Money(1, 4, 0, 1, 0, 0, 0);
        wallet.setMyMoney(new Money(100, 100, 100, 100, 100, 100, 100));

        Money result = VendingMachine.checkForChange(money, 5);

        String message = result.message;
        Assert.assertEquals(message, "his change is: 15");

    }

    @Test
    public void InsertEnoughMoneyAndNoEnoughWallet() throws Exception {

        Money money = new Money(1, 4, 0, 1, 0, 0, 0);
        wallet.setMyMoney(new Money(0, 0, 0, 0, 0, 0, 0));

        Money result = VendingMachine.checkForChange(money, 5);

        String message = result.message;
        Assert.assertEquals(message, "Sorry there is no Change enough");

    }


    @Test
    public void LowMoneyInserted() throws Exception {

        Money money = new Money(0, 0, 0, 0, 0, 0, 0);
        wallet.setMyMoney(new Money(100, 50, 10, 10, 10, 10, 10));

        Money result = VendingMachine.checkForChange(money, 5);

        String message = result.message;
        Assert.assertEquals(message, "Inserted money not enough for your order");

    }

    @Test
    public void enoughAmountAndNoCoin() throws Exception {

        Money money = new Money(0, 0, 0, 10, 0, 0, 0);
        wallet.setMyMoney(new Money(0, 0, 0, 0, 0, 0, 100));

        Money result = VendingMachine.checkForChange(money, 5);

        String message = result.message;
        Assert.assertEquals(message, "Sorry there is no Change enough");

    }

    @Test
    public void sequentialOrders() {

        Item Coffee = new Item(0, 5, 0);
        Item Nescafe = new Item(1, 6, 5);
        Item Milk = new Item(2, 12, 5);
        Item Tea = new Item(3, 3, 0);
        Item Water = new Item(4, 3, 5);

        List<Item> itemList = new ArrayList<>();
        itemList.add(Coffee);
        itemList.add(Nescafe);
        itemList.add(Milk);
        itemList.add(Tea);
        itemList.add(Water);
        itemHolder.setItemList(itemList);

        wallet.setMyMoney(new Money(50, 20, 0, 1, 0, 0, 10));

        Money coffeeResult;
        Money teaResult;
        Money milkResult;
        String message;

        int coffeID = itemHolder.getItemList().get(0).getId();
        if (VendingMachine.checkOrder(coffeID)) {

            Money money = new Money(1, 4, 0, 1, 2, 0, 0);
            int coffeePrice = itemHolder.getItemList().get(0).getPrice();
            coffeeResult = VendingMachine.checkForChange(money, coffeePrice);
            message = coffeeResult.message;
            Assert.assertEquals(message, "his change is: 54");
        }

        int teaID = itemHolder.getItemList().get(3).getId();
        if (VendingMachine.checkOrder(teaID)) {

            Money money = new Money(2, 4, 0, 1, 0, 0, 1);
            int teaPrice = itemHolder.getItemList().get(3).getPrice();
            teaResult = VendingMachine.checkForChange(money, teaPrice);
            message = teaResult.message;
            Assert.assertEquals(message, "his change is: 117");
        }


        int nesCafeID = 100;
        boolean state =true;
        if (VendingMachine.checkOrder(nesCafeID)) {

            Money money = new Money(2, 4, 0, 1, 0, 0, 1);
            int teaPrice = itemHolder.getItemList().get(1).getPrice();
            teaResult = VendingMachine.checkForChange(money, teaPrice);
            message = teaResult.message;

        }
        else
            state = false;

        Assert.assertEquals(state, false);

    }


}