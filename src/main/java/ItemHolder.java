import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemHolder {

    private static ItemHolder holder;
    private static List<Item> itemList = new ArrayList<>();

    public static ItemHolder getInstance(){
        if (holder == null)
            holder = new ItemHolder();


        for (int i=1 ; i<6 ; i++ ){
            Random rn = new Random();
            Item item = new Item(i , rn.nextInt(10)+1  ,rn.nextInt(10)+1 );
            itemList.add(item);
        }//end for loop

        return holder;
    }

    public  int getPrice(int id){
        Item item = itemList.get(id-1);
        return item.getPrice();
    }

    public  void remove( int id){
        Item item = itemList.get(itemList.indexOf(id));
        int quantity = itemList.get(itemList.indexOf(id)).getQuantity();
        if (quantity > 1)
            itemList.get(itemList.indexOf(id)).setQuantity(quantity - 1);
    }


}
