package Model;

public class Item {
    private String id;
    private String name;
    private String itemType;



    private int price;
    private static int NUM_ITEMS = 0;

    public Item(String id, String name, String itemType, int price) {
        ++NUM_ITEMS;
        this.id = "0".repeat(4 - String.valueOf(NUM_ITEMS).length()) + String.valueOf(NUM_ITEMS);
        this.name = name;
        this.itemType = itemType;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemType() {
        return itemType;
    }
     @Override
    public String toString() {
        return "ID: " + id + "\t" +
                "Name: " + name + "\t" +
                "Item type: " + itemType + "\t" +
                "Price: " + price ;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getNumItems() {
        return NUM_ITEMS;
    }

    public static void setNumItems(int numItems) {
        NUM_ITEMS = numItems;
    }
}
