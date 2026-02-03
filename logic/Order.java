package logic;

import java.util.ArrayList;

public class Order {
	// attributes
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;

	// constructors
	public Order() {
		// initialize orderItemList
		this.orderItemList = new ArrayList<OrderItem>() ;
		// assign orderNumber as totalOrderCount
		this.orderNumber = totalOrderCount ;
		// increment totalOrderCount by 1
		totalOrderCount++ ;
	}

	// another methods
	public OrderItem addItem(Item item, int amount) {
		// TODO
			// Loop the orderItemList to find if item of any orderItem equals to the given item
			// if there is orderItem with given item, increase that orderItem itemAmount with amount
			// and return that orderItem

		for (int pos = 0 ; pos < orderItemList.size() ; pos++) { // use loop count instead for changing value from index
			// define eachOrderItem for easier cmd
			OrderItem eachOrderItem = orderItemList.get(pos) ;
			// check condition if same name
			if ( eachOrderItem.getItem().getName().equals(item.getName()) ) { // use .equals() instead of ==
				// exist in OrderItemList , increment itemAmount -> don't forget to check if amount >= 0
				if (amount >= 0) eachOrderItem.setItemAmount( eachOrderItem.getItemAmount() + amount );
				// return back that OrderItem
				return eachOrderItem ;
			}
		}

		// else create new orderItem with given item and amount, then return the new orderItem
			// add new OrderItem to ArrayList
			OrderItem newOrderItem = new OrderItem(item , amount) ;
			orderItemList.add( newOrderItem ) ; // add **new** item
			return newOrderItem ;
	}

	public int calculateOrderTotalPrice() {
		// TODO
			// Calculate total price of the order by summing total price of each orderItem in orderItemList
		int totalOrderPrice = 0 ;
		// loop add value
		for (OrderItem eachOrderItem : orderItemList) {
			totalOrderPrice += eachOrderItem.calculateTotalPrice();
		}
		// return totalOrderPrice
		return totalOrderPrice ;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}

}
