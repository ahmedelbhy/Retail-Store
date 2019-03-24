package retial.store.dataModel;

public class Groceries implements PurchaseObject {

	private String productName;
	private double price;
	private double quantity;

	@Override
	public double getprice() {
		return price;
	}

	@Override
	public void setprice(double price) {
		this.price = price;

	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
