import java.util.HashMap;

public class MoneyHash {

    HashMap<MONEYENUM, Integer> coins = new HashMap<MONEYENUM, Integer>();
     String message = "";

    public MoneyHash() {
        coins.put(MONEYENUM.SHEKEL, 0);
        coins.put(MONEYENUM.TWOSHEKEL, 0);
        coins.put(MONEYENUM.FIVESHEKEL, 0);
        coins.put(MONEYENUM.TENSHEKEL, 0);
        coins.put(MONEYENUM.TWENTYSHEKEL, 0);
        coins.put(MONEYENUM.FIFTYSHEKEL, 0);
        coins.put(MONEYENUM.HUNDREDSHEKEL, 0);
    }

    public MoneyHash(int shekel, int twoShekel, int fiveShekel, int tenShekel,
                     int twentyShekel, int fiftyShekel, int hundredShekel) {
        coins.put(MONEYENUM.SHEKEL, shekel);
        coins.put(MONEYENUM.TWOSHEKEL, twoShekel);
        coins.put(MONEYENUM.FIVESHEKEL, fiveShekel);
        coins.put(MONEYENUM.TENSHEKEL, tenShekel);
        coins.put(MONEYENUM.TWENTYSHEKEL, twentyShekel);
        coins.put(MONEYENUM.FIFTYSHEKEL, fiftyShekel);
        coins.put(MONEYENUM.HUNDREDSHEKEL, hundredShekel);
    }

    public MoneyHash(HashMap<MONEYENUM, Integer> coins) {
        this.coins = coins;
    }

    public HashMap<MONEYENUM, Integer> getCoins() {
        return coins;
    }

    public void setCoins(HashMap<MONEYENUM, Integer> coins) {
        this.coins = coins;
    }

    public int getAmount() {
        int amount = (coins.get(MONEYENUM.SHEKEL)) + (coins.get(MONEYENUM.TWOSHEKEL) * 2) + (coins.get(MONEYENUM.FIVESHEKEL) * 5)
                + (coins.get(MONEYENUM.TENSHEKEL) * 10) + (coins.get(MONEYENUM.TWENTYSHEKEL) * 20) +
                (coins.get(MONEYENUM.FIFTYSHEKEL) * 50) + (coins.get(MONEYENUM.HUNDREDSHEKEL) * 100);

        return amount;
    }

    public int getShekel() {
        return coins.get(MONEYENUM.SHEKEL);
    }

    public void setShekel(int shekel) {
        this.coins.put(MONEYENUM.SHEKEL, shekel);
    }

    public int getTwoShekel() {
        return coins.get(MONEYENUM.TWOSHEKEL);
    }

    public void setTwoShekel(int twoShekel) {
        this.coins.put(MONEYENUM.TWOSHEKEL, twoShekel);
    }

    public int getFiveShekel() {
        return coins.get(MONEYENUM.FIVESHEKEL);
    }

    public void setFiveShekel(int fiveShekel) {
        this.coins.put(MONEYENUM.FIVESHEKEL, fiveShekel);
    }

    public int getTenShekel() {
        return coins.get(MONEYENUM.TENSHEKEL);
    }

    public void setTenShekel(int tenShekel) {
        this.coins.put(MONEYENUM.TENSHEKEL, tenShekel);
    }

    public int getTwentyShekel() {
        return coins.get(MONEYENUM.TWENTYSHEKEL);
    }

    public void setTwentyShekel(int twentyShekel) {
        this.coins.put(MONEYENUM.TWENTYSHEKEL, twentyShekel);
    }

    public int getFiftyShekel() {
        return coins.get(MONEYENUM.FIFTYSHEKEL);
    }

    public void setFiftyShekel(int fiftyShekel) {
        this.coins.put(MONEYENUM.FIFTYSHEKEL, fiftyShekel);
    }

    public int getHundredShekel() {
        return coins.get(MONEYENUM.HUNDREDSHEKEL);
    }

    public void setHundredShekel(int hundredShekel) {
        this.coins.put(MONEYENUM.HUNDREDSHEKEL, hundredShekel);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MoneyHash{" +
                "coins=" + coins +
                '}';
    }
}
