public class VendingMachine {

    public static int mOrder = 0;
    public static Money mInsertedMoney = new Money();
    public static String menu = "Enter your order number please\n1. Coffee\n2. Nescafe\n3. Milk\n4. Tea\n5. Water";

    public static Display display = Display.getInstance();
    public static ItemHolder itemHolder = ItemHolder.getInstance();
    public static MoneyWallet wallet = MoneyWallet.getInstance();


    public static void main(String[] args) {


        while (true) {

            wellcoming();
            mOrder = selectOrder();

            if (checkOrder(mOrder)) {
                int price = itemHolder.getPrice(mOrder);
                display.information("Your item price is: " + price);

                mInsertedMoney = interMony(5, 3, 7, 9, 4, 2, 3);

                checkForChange(mInsertedMoney, price);


            }//end check if


        }//end while


    }//end main method

    private static void checkForChange(Money money, int price) {
        if (!(money.getAmount() < price)) {


            int change = money.getAmount() - price;
            if (wallet.getMyMoney().getAmount() > change) {
                Money customerchange = new Money();

                while (customerchange.getAmount() <= change) {

                    while (true) {

                        if (wallet.getMyMoney().getHundredShekel() > 1) {
                            if (customerchange.getAmount() + 100 <= price) {

                                int hundredshekel = customerchange.getHundredShekel();
                                customerchange.setHundredShekel(hundredshekel + 1);
                                hundredshekel = wallet.getMyMoney().getHundredShekel();
                                wallet.getMyMoney().setHundredShekel(hundredshekel - 1);
                            }
                        } else
                            break;
                    } // end hundred shekel

                    while (true) {

                        if (wallet.getMyMoney().getFiftyShekel() > 1) {
                            if (customerchange.getAmount() + 50 <= price) {

                                int fiftyShekel = customerchange.getFiftyShekel();
                                customerchange.setFiftyShekel(fiftyShekel + 1);
                                fiftyShekel = wallet.getMyMoney().getFiftyShekel();
                                wallet.getMyMoney().setFiftyShekel(fiftyShekel - 1);
                            }
                        } else
                            break;
                    } // end fifty shekel

                    while (true) {
                        if (wallet.getMyMoney().getTwentyShekel() > 1) {
                            if (customerchange.getAmount() + 20 <= price) {

                                int twentyShekel = customerchange.getTwentyShekel();
                                customerchange.setTwentyShekel(twentyShekel + 1);
                                twentyShekel = wallet.getMyMoney().getTwentyShekel();
                                wallet.getMyMoney().setTwentyShekel(twentyShekel - 1);
                            }
                        } else
                            break;
                    } // end twenty shekel

                    while (true) {
                        if (wallet.getMyMoney().getTenShekel() > 1) {
                            if (customerchange.getAmount() + 10 <= price) {

                                int tenShekel = customerchange.getTenShekel();
                                customerchange.setTenShekel(tenShekel + 1);
                                tenShekel = wallet.getMyMoney().getTenShekel();
                                wallet.getMyMoney().setTenShekel(tenShekel - 1);
                            }
                        } else
                            break;
                    } // end ten shekel

                    while (true) {
                        if (wallet.getMyMoney().getFiveShekel() > 1) {
                            if (customerchange.getAmount() + 5 <= price) {

                                int fiveShekel = customerchange.getFiveShekel();
                                customerchange.setFiveShekel(fiveShekel + 1);
                                fiveShekel = wallet.getMyMoney().getFiveShekel();
                                wallet.getMyMoney().setFiveShekel(fiveShekel - 1);
                            }
                        } else
                            break;
                    } // end five shekel

                    while (true) {
                        if (wallet.getMyMoney().getFiveShekel() > 1) {
                            if (customerchange.getAmount() + 2 <= price) {

                                int twoshekel = customerchange.getFiveShekel();
                                customerchange.setFiveShekel(twoshekel + 1);
                                twoshekel = wallet.getMyMoney().getTwoShekel();
                                wallet.getMyMoney().setFiveShekel(twoshekel - 1);
                            }
                        } else
                            break;
                    } // end two shekel

                    while (true) {
                        if (wallet.getMyMoney().getShekel() > 1) {
                            if (customerchange.getAmount() + 1 <= price) {

                                int shekel = customerchange.getShekel();
                                customerchange.setShekel(shekel + 1);
                                shekel = wallet.getMyMoney().getShekel();
                                wallet.getMyMoney().setShekel(shekel - 1);
                            }
                        } else
                            break;
                    } // end two shekel


                }// loop for add money to customer change money object

                if (customerchange.getAmount() == change) {
                    //return change
                } else {
                    //return no charge
                }

            }// for check is there wallet money for change

        }// end if statement for the insert money is more than the order price

    }// end check method

    private static Money interMony(int c1, int c2, int c5, int c10, int c20, int c50, int c100) {
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
