public class Item {

    private String name;
    private int id;
    private Money price;
    private int quantity;

    public Item(int id, int price, int quantity, String name) {
        this.id = id;
        this.price = new Money();
        this.price.setShekel(price);
        this.quantity = quantity;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price.getShekel();
    }

    public void setPrice(int price) {
        this.price.setShekel(price);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
