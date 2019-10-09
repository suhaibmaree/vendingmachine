
public class MoneyWallet {

    private Money myMoney;
    private static MoneyWallet moneyWallet;


    public static MoneyWallet getInstance(){
        if (moneyWallet == null)
            moneyWallet = new MoneyWallet();
        return moneyWallet;
    }

    public Money getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(Money myMoney) {
        this.myMoney = myMoney;
    }

}
