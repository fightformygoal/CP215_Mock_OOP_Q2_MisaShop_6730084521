package logic;

public class OrderItem {
    // attributes
    private Item item ;
    private int itemAmount ;

    // constructors
    public OrderItem(Item item , int itemAmount) {
        setItem(item) ;
        setItemAmount(itemAmount) ;
    }

    // getter - setter methods
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public int getItemAmount() {
        return itemAmount;
    }
    public void setItemAmount(int itemAmount) {
        if (itemAmount < 0) this.itemAmount = 0 ;
        else this.itemAmount = itemAmount;
    }

    // another methods
    public void increaseItemAmount(int amount) {
        if (amount >= 0) setItemAmount( getItemAmount() + amount ); // get ItemA
    }
    public int calculateTotalPrice() {
        // totalPrice = pricePerPiece * itemAmount
        return item.getPricePerPiece() * getItemAmount() ;
    }

}
