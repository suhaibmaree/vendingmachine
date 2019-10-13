import java.util.List;

public class VendingMachine implements VendingInterface {

    public static int mOrder = 0;
    public static Money mInsertedMoney = new Money();
    public static String menu = "Enter your order number please\n1. Coffee\n2. NesCafe\n3. Milk\n4. Tea\n5. Water";

    public static JFrameDisplay display = JFrameDisplay.getInstance();
    public static ItemHolder itemHolder = ItemHolder.getInstance();
    public static MoneyWallet wallet = MoneyWallet.getInstance();


    public Money askUserForMoney() {

        int c1 = display.Question("Enter shekel coin", "");
        int c2 = display.Question("Enter two shekel coin", "");
        int c5 = display.Question("Enter five shekel coin", "");
        int c10 = display.Question("Enter ten shekel coin", "");
        int c20 = display.Question("Enter twenty shekel coin", "");
        int c50 = display.Question("Enter fifty shekel coin", "");
        int c100 = display.Question("Enter hundred shekel coin", "");
        return mInsertedMoney = interMoney(c1, c2, c5, c10, c20, c50, c100);
    }

    public Order collect(MoneyHash money, int input) throws CustomException {
        int insertMoney = money.getAmount();
        MoneyHash customerChange = new MoneyHash();

        if (!(insertMoney < itemHolder.getPrice(input))) {

            int change = money.getAmount() - itemHolder.getPrice(input);
            if (wallet.getMyMoney().getAmount() > change) {

                if (customerChange.getAmount() <= change) {

                    while (wallet.getMyMoney().getHundredShekel() > 1) {
                        if (customerChange.getAmount() + 100 <= change) {
                            int hundredshekel = customerChange.getHundredShekel();
                            customerChange.setHundredShekel(hundredshekel + 1);
                            hundredshekel = wallet.getMyMoney().getHundredShekel();
                            if (hundredshekel > 0)
                                wallet.getMyMoney().setHundredShekel(hundredshekel - 1);
                        }
                        break;
                    } // end hundred shekel

                    while (wallet.getMyMoney().getFiftyShekel() > 1) {
                        if (customerChange.getAmount() + 50 <= change) {
                            int fiftyShekel = customerChange.getFiftyShekel();
                            customerChange.setFiftyShekel(fiftyShekel + 1);
                            fiftyShekel = wallet.getMyMoney().getFiftyShekel();
                            if (fiftyShekel > 0)
                                wallet.getMyMoney().setFiftyShekel(fiftyShekel - 1);
                        } else
                            break;
                    } // end fifty shekel

                    while (wallet.getMyMoney().getTwentyShekel() > 1) {
                        if (customerChange.getAmount() + 20 <= change) {
                            int twentyShekel = customerChange.getTwentyShekel();
                            customerChange.setTwentyShekel(twentyShekel + 1);
                            twentyShekel = wallet.getMyMoney().getTwentyShekel();
                            if (twentyShekel > 0)
                                wallet.getMyMoney().setTwentyShekel(twentyShekel - 1);
                        } else
                            break;
                    } // end twenty shekel

                    while (wallet.getMyMoney().getTenShekel() > 1) {
                        if (customerChange.getAmount() + 10 <= change) {
                            int tenShekel = customerChange.getTenShekel();
                            customerChange.setTenShekel(tenShekel + 1);
                            tenShekel = wallet.getMyMoney().getTenShekel();
                            if (tenShekel > 0)
                                wallet.getMyMoney().setTenShekel(tenShekel - 1);
                        } else
                            break;
                    } // end ten shekel

                    while (wallet.getMyMoney().getFiveShekel() > 1) {
                        if (customerChange.getAmount() + 5 <= change) {
                            int fiveShekel = customerChange.getFiveShekel();
                            customerChange.setFiveShekel(fiveShekel + 1);
                            fiveShekel = wallet.getMyMoney().getFiveShekel();
                            if (fiveShekel > 0)
                                wallet.getMyMoney().setFiveShekel(fiveShekel - 1);
                        } else
                            break;
                    } // end five shekel

                    while (wallet.getMyMoney().getTwoShekel() > 1) {
                        if (customerChange.getAmount() + 2 <= change) {
                            int twoshekel = customerChange.getTwoShekel();
                            customerChange.setTwoShekel(twoshekel + 1);
                            twoshekel = wallet.getMyMoney().getTwoShekel();
                            if (twoshekel > 0)
                                wallet.getMyMoney().setTwoShekel(twoshekel - 1);
                        } else
                            break;
                    } // end two shekel

                    while (wallet.getMyMoney().getShekel() > 1) {
                        if (customerChange.getAmount() + 1 <= change) {
                            int shekel = customerChange.getShekel();
                            customerChange.setShekel(shekel + 1);
                            shekel = wallet.getMyMoney().getShekel();
                            if (shekel > 0)
                                wallet.getMyMoney().setShekel(shekel - 1);
                        } else
                            break;
                    } // end one shekel

                }// loop for add money to customer change money object


                if (customerChange.getAmount() == change) {

                    Item item = itemHolder.getItem(input);
                    itemHolder.removeItem(item);
                    return new Order(itemHolder.getItem(input), customerChange);

                } else {
                    // how to rollback ???
                    wallet.rollback(customerChange);
                    throw new CustomException("Sorry there is no Change enough");
                }

            }// if check is there wallet money for change
            else
            throw new CustomException("Sorry there is no Change enough");

        }// end if statement for the insert money is more than the order price
        else
            throw new CustomException("Inserted money not enough for your order");

    }// end check method

    public Money interMoney(int c1, int c2, int c5, int c10, int c20, int c50, int c100) {
        return new Money(c1, c2, c5, c10, c20, c50, c100);
    }

    public boolean checkOrder(int order) {
        if (order < 0 || order > 5)
            //display.information(String.valueOf(order) + " is wrong");
            return false;

        if (itemHolder.getItemList().get(order).getQuantity() > 0)
            return false;
        //display.information(String.valueOf("Your choice is: " + order + " click okay to continue"));
        return true;
    }

    public int selectOrder() {
        int order = display.Question(menu,
                "");
        return order;
    }

    public void welcoming() {
        display.information(" Hello this is Vending Machine to start press Okay");
    }

    @Override
    public String insert(MoneyHash moneyHash) {
        if (moneyHash.getAmount() > 0){
            wallet.rollback(moneyHash);
            return "Money inserted";
        }
        else return "Money not inserted";
    }

    @Override
    public Boolean selectItem(int input) {

        for (int i = 0; i < itemHolder.getItemList().size(); i++) {
            if (itemHolder.getItemList().get(i).getId() == input)
                if (itemHolder.getItemList().get(i).getQuantity() > 0)
                    return true;
        }
        return false;
    }

    @Override
    public void setItemList(List<Item> itemList) {
        itemHolder.setItemList(itemList);
    }

    @Override
    public String printInventory() {
        String items = "";
        for (Item item : itemHolder.getItemList()) {
            items += item.getName() + " : " + item.getQuantity() + "\n";
        }
        return items;
    }


    public void printWallet() {

        String s = wallet.toString();
        System.out.println(s);
    }
}
