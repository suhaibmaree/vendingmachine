import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemHolder {

    private static ItemHolder holder;
    public static List<Item> itemList = new ArrayList<>();

    public static ItemHolder getInstance() {
        if (holder == null) {
            holder = new ItemHolder();
        }

        return holder;
    }

    public int getPrice(int id) {
        Item item = itemList.get(id - 1);
        return item.getPrice();
    }

    public void remove(int id) {
        Item item = itemList.get(itemList.indexOf(id));
        int quantity = itemList.get(itemList.indexOf(id)).getQuantity();
        if (quantity > 1)
            itemList.get(itemList.indexOf(id)).setQuantity(quantity - 1);
    }


    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        ItemHolder.itemList = itemList;
    }

}
