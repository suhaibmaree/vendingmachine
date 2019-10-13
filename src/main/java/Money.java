public class Money {
    private int shekel;
    private int twoShekel;
    private int fiveShekel;
    private int tenShekel;
    private int twentyShekel;
    private int fiftyShekel;
    private int hundredShekel;
    public String message;

    public Money() {
        this.shekel = 0;
        this.twoShekel = 0;
        this.fiveShekel = 0;
        this.tenShekel = 0;
        this.twentyShekel = 0;
        this.fiftyShekel = 0;
        this.hundredShekel = 0;
    }

    public Money(int shekel, int twoShekel, int fiveShekel, int tenShekel,
                 int twentyShekel, int fiftyShekel, int hundredShekel) {

        this.shekel = shekel;
        this.twoShekel = twoShekel;
        this.fiveShekel = fiveShekel;
        this.tenShekel = tenShekel;
        this.twentyShekel = twentyShekel;
        this.fiftyShekel = fiftyShekel;
        this.hundredShekel = hundredShekel;
    }

    public int getAmount() {
        int amount = (shekel*1)+(twoShekel*2)+(fiveShekel*5)+(tenShekel*10)+
                (twentyShekel*20)+(fiftyShekel*50)+(hundredShekel*100);

        return amount;
    }

    public int getShekel() {
        return shekel;
    }

    public void setShekel(int shekel) {
        this.shekel = shekel;
    }

    public int getTwoShekel() {
        return twoShekel;
    }

    public void setTwoShekel(int twoShekel) {
        this.twoShekel = twoShekel;
    }

    public int getFiveShekel() {
        return fiveShekel;
    }

    public void setFiveShekel(int fiveShekel) {
        this.fiveShekel = fiveShekel;
    }

    public int getTenShekel() {
        return tenShekel;
    }

    public void setTenShekel(int tenShekel) {
        this.tenShekel = tenShekel;
    }

    public int getTwentyShekel() {
        return twentyShekel;
    }

    public void setTwentyShekel(int twentyShekel) {
        this.twentyShekel = twentyShekel;
    }

    public int getFiftyShekel() {
        return fiftyShekel;
    }

    public void setFiftyShekel(int fiftyShekel) {
        this.fiftyShekel = fiftyShekel;
    }

    public int getHundredShekel() {
        return hundredShekel;
    }

    public void setHundredShekel(int hundredShekel) {
        this.hundredShekel = hundredShekel;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
