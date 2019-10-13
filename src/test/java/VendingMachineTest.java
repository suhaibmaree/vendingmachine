import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachineTest {


    private VendingMachine vm = new VendingMachine();


    @Test
    public void flowTest() {

        HashMap<MONEYENUM, Integer> coins = new HashMap<>();

        coins.put(MONEYENUM.SHEKEL, 1);
        coins.put(MONEYENUM.TWOSHEKEL, 4);
        coins.put(MONEYENUM.FIVESHEKEL, 0);
        coins.put(MONEYENUM.TENSHEKEL, 1);
        coins.put(MONEYENUM.TWENTYSHEKEL, 0);
        coins.put(MONEYENUM.FIFTYSHEKEL, 0);
        coins.put(MONEYENUM.HUNDREDSHEKEL, 0);

        MoneyHash insertedMoney = new MoneyHash(coins);

        MoneyHash wallet = new MoneyHash(100, 100, 100,
                100, 100, 100, 100);

        VendingMachine.wallet.setMyMoney(wallet);

        Item Coffee = new Item(1, 5, 1, "Coffee");
        Item NesCafe = new Item(2, 6, 5, "NesCafe");
        Item Milk = new Item(3, 12, 5, "Milk");
        Item Tea = new Item(5, 3, 0, "Tea");
        Item Water = new Item(6, 3, 5, "Water");

        List<Item> itemList = new ArrayList<>();
        itemList.add(Coffee);
        itemList.add(NesCafe);
        itemList.add(Milk);
        itemList.add(Tea);
        itemList.add(Water);

        vm.setItemList(itemList);

        int input = 1;//coffee

        // Insert
        String insert = vm.insert(insertedMoney);
        Assert.assertEquals("Money inserted", insert);

        //Select
        Boolean aBoolean = vm.selectItem(input);
        Assert.assertEquals(true, aBoolean);

        vm.printInventory();


        try {

            Order customOrder = vm.collect(insertedMoney, input);
            customOrder.print();

            System.out.println("**************");
            System.out.print(vm.printInventory());
            vm.printWallet();
        } catch (CustomException e) {
            e.printStackTrace();
        }
        //Collect

        //inventory
        String inventory = vm.printInventory();
        Assert.assertEquals("Coffee : 0\n" +
                "NesCafe : 5\n" +
                "Milk : 5\n" +
                "Tea : 0\n" +
                "Water : 5\n", inventory);
    }


}