public class Order {
    Item item;

    public Order() {
    }

    public Order(Item item, MoneyHash moneyHash) {
        this.item = item;
        this.moneyHash = moneyHash;
    }

    public MoneyHash getMoneyHash() {
        return moneyHash;
    }

    public void setMoneyHash(MoneyHash moneyHash) {
        this.moneyHash = moneyHash;
    }

    MoneyHash moneyHash;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    public void print() {
        System.out.print(toString());
    }

    @Override
    public String toString() {
        return "Order{" +
                "item=" + item.toString() +
                ", moneyHash=" + moneyHash.toString() +
                '}';
    }
}
