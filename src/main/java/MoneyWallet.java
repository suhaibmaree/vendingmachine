
public class MoneyWallet {

    private Money myMoney = new Money(); // try build a hashmap
    private static MoneyWallet moneyWallet;


    public static MoneyWallet getInstance(){
        if (moneyWallet == null)
            moneyWallet = new MoneyWallet();
        return moneyWallet;
    }

    private MoneyWallet() {
        this.myMoney = new Money();
    }

    public Money getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(Money myMoney) {
        this.myMoney = myMoney;
    }

}
