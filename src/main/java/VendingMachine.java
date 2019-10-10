public class VendingMachine {

    public static int mOrder = 0;
    public static Money mInsertedMoney = new Money();
    public static String menu = "Enter your order number please\n1. Coffee\n2. Nescafe\n3. Milk\n4. Tea\n5. Water";

    public static Display display = Display.getInstance();
    public static ItemHolder itemHolder = ItemHolder.getInstance();
    public static MoneyWallet wallet = MoneyWallet.getInstance();

    public static void main(String[] args) {

        wallet.setMyMoney(new Money(100, 100, 100, 100, 100, 100, 100));

        while (true) {

            wellcoming();
            mOrder = selectOrder();

            if (checkOrder(mOrder)) {
                int price = itemHolder.getPrice(mOrder);
                display.information("Your item price is: " + price);
                mInsertedMoney = askUserForMoney();
                checkForChange(mInsertedMoney, price);


            }//end check if


        }//end while


    }//end main method

    private static Money askUserForMoney() {

        int c1 = display.Question("Enter shekel coin", "");
        int c2 = display.Question("Enter two shekel coin", "");
        int c5 = display.Question("Enter five shekel coin", "");
        int c10 = display.Question("Enter ten shekel coin", "");
        int c20 = display.Question("Enter twenty shekel coin", "");
        int c50 = display.Question("Enter fifty shekel coin", "");
        int c100 = display.Question("Enter hundred shekel coin", "");
        return mInsertedMoney = interMoney(c1, c2, c5, c10, c20, c50, c100);
    }

    private static void checkForChange(Money money, int price) {
        int insertmoney = money.getAmount();
        if (!(insertmoney < price)) {


            int change = money.getAmount() - price;
            if (wallet.getMyMoney().getAmount() > change) {
                Money customerchange = new Money();

                while (customerchange.getAmount() <= change) {

                    while (true) {

                        if (wallet.getMyMoney().getHundredShekel() > 1) {
                            if (customerchange.getAmount() + 100 <= change) {

                                int hundredshekel = customerchange.getHundredShekel();
                                customerchange.setHundredShekel(hundredshekel + 1);
                                hundredshekel = wallet.getMyMoney().getHundredShekel();
                                wallet.getMyMoney().setHundredShekel(hundredshekel - 1);
                            }
                            break;
                        } else
                            break;

                    } // end hundred shekel

                    while (true) {

                        if (wallet.getMyMoney().getFiftyShekel() > 1) {
                            if (customerchange.getAmount() + 50 <= change) {

                                int fiftyShekel = customerchange.getFiftyShekel();
                                customerchange.setFiftyShekel(fiftyShekel + 1);
                                fiftyShekel = wallet.getMyMoney().getFiftyShekel();
                                wallet.getMyMoney().setFiftyShekel(fiftyShekel - 1);
                            } else
                                break;
                        } else
                            break;
                    } // end fifty shekel

                    while (true) {
                        if (wallet.getMyMoney().getTwentyShekel() > 1) {
                            if (customerchange.getAmount() + 20 <= change) {

                                int twentyShekel = customerchange.getTwentyShekel();
                                customerchange.setTwentyShekel(twentyShekel + 1);
                                twentyShekel = wallet.getMyMoney().getTwentyShekel();
                                wallet.getMyMoney().setTwentyShekel(twentyShekel - 1);
                            } else
                                break;
                        } else
                            break;
                    } // end twenty shekel

                    while (true) {
                        if (wallet.getMyMoney().getTenShekel() > 1) {
                            if (customerchange.getAmount() + 10 <= change) {

                                int tenShekel = customerchange.getTenShekel();
                                customerchange.setTenShekel(tenShekel + 1);
                                tenShekel = wallet.getMyMoney().getTenShekel();
                                wallet.getMyMoney().setTenShekel(tenShekel - 1);
                            } else
                                break;
                        } else
                            break;
                    } // end ten shekel

                    while (true) {
                        if (wallet.getMyMoney().getFiveShekel() > 1) {
                            if (customerchange.getAmount() + 5 <= change) {

                                int fiveShekel = customerchange.getFiveShekel();
                                customerchange.setFiveShekel(fiveShekel + 1);
                                fiveShekel = wallet.getMyMoney().getFiveShekel();
                                wallet.getMyMoney().setFiveShekel(fiveShekel - 1);
                            } else
                                break;
                        } else
                            break;
                    } // end five shekel

                    while (true) {
                        if (wallet.getMyMoney().getFiveShekel() > 1) {
                            if (customerchange.getAmount() + 2 <= change) {

                                int twoshekel = customerchange.getFiveShekel();
                                customerchange.setFiveShekel(twoshekel + 1);
                                twoshekel = wallet.getMyMoney().getTwoShekel();
                                wallet.getMyMoney().setFiveShekel(twoshekel - 1);
                            } else
                                break;
                        } else
                            break;
                    } // end two shekel

                    while (true) {
                        if (wallet.getMyMoney().getShekel() > 1) {
                            if (customerchange.getAmount() + 1 <= change) {

                                int shekel = customerchange.getShekel();
                                customerchange.setShekel(shekel + 1);
                                shekel = wallet.getMyMoney().getShekel();
                                wallet.getMyMoney().setShekel(shekel - 1);
                            } else
                                break;
                        } else
                            break;
                    } // end one shekel

                    break;
                }// loop for add money to customer change money object

                int CC = customerchange.getAmount();
                if (CC == change) {
                    display.information("Thanks for ordering, Your change is: " +
                            "\nShekel: " + customerchange.getShekel() +
                            "\nTwo shekel: " + customerchange.getTwoShekel() +
                            "\nFive Shekel: " + customerchange.getFiveShekel() +
                            "\nTen Shekel: " + customerchange.getTenShekel() +
                            "\ntwenty Shekel: " + customerchange.getTwentyShekel() +
                            "\nFifty Shekel: " + customerchange.getFiftyShekel() +
                            "\nHundred Shekel: " + customerchange.getHundredShekel());
                } else {

                }

            }// if check is there wallet money for change
            else
                display.information("Sorry there is no Change enough");
        }// end if statement for the insert money is more than the order price
        else
            display.information("Inserted money not enough for your order");


    }// end check method

    private static Money interMoney(int c1, int c2, int c5, int c10, int c20, int c50, int c100) {
        return new Money(c1, c2, c5, c10, c20, c50, c100);
    }

    private static boolean checkOrder(int order) {
        if (order < 0 || order > 5) {
            display.information(String.valueOf(order) + " is wrong");
            return false;
        } else
            display.information(String.valueOf("Your choice is: " + order + " click okay to continue"));
        return true;
    }

    private static int selectOrder() {
        int order = display.Question(menu,
                "");
        return order;
    }

    public static void wellcoming() {
        display.information(" Hello this is Vending Machine to start press Okay");
    }


}
