package retial.store.dataModel;

public class ServersPC implements PurchaseObject {

	private String productName;
	private String serverProcessor;
	private int serverRamSize;
	private double price;

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

	public int getServerRamSize() {
		return serverRamSize;
	}

	public void setServerRamSize(int serverRamSize) {
		this.serverRamSize = serverRamSize;
	}

	public String getServerProcessor() {
		return serverProcessor;
	}

	public void setServerProcessor(String serverProcessor) {
		this.serverProcessor = serverProcessor;
	}

}
