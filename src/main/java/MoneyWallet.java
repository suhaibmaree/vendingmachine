
public class MoneyWallet {

    private MoneyHash myMoney = new MoneyHash();
    private static MoneyWallet moneyWallet;


    public static MoneyWallet getInstance(){
        if (moneyWallet == null)
            moneyWallet = new MoneyWallet();
        return moneyWallet;
    }

    private MoneyWallet() {
        this.myMoney = new MoneyHash();
    }

    public MoneyHash getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(MoneyHash myMoney) {
        this.myMoney = myMoney;
    }

    public void rollback(MoneyHash customerChange) {
       myMoney.setShekel( myMoney.getShekel()+customerChange.getShekel());
       myMoney.setTwoShekel(myMoney.getTwoShekel()+customerChange.getTwoShekel());
       myMoney.setFiveShekel(myMoney.getFiveShekel()+customerChange.getFiveShekel());
       myMoney.setTenShekel(myMoney.getTenShekel()+customerChange.getTenShekel());
       myMoney.setTwentyShekel(myMoney.getTwentyShekel()+customerChange.getTwentyShekel());
       myMoney.setFiftyShekel(myMoney.getFiftyShekel()+customerChange.getFiftyShekel());
       myMoney.setHundredShekel(myMoney.getHundredShekel()+customerChange.getHundredShekel());

    }

    @Override
    public String toString() {
        return "MoneyWallet{" +
                "myMoney=" + myMoney +
                '}';
    }


}
