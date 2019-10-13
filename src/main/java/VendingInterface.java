import java.util.List;

public interface VendingInterface {

    Money askUserForMoney();

    Order collect(MoneyHash money, int price) throws CustomException;

    Money interMoney(int c1, int c2, int c5, int c10, int c20, int c50, int c100);

    boolean checkOrder(int order);

    int selectOrder();

    void welcoming();

    String insert(MoneyHash moneyHash);

    Boolean selectItem(int input);

    void setItemList(List<Item> itemList);

    String printInventory();
}
