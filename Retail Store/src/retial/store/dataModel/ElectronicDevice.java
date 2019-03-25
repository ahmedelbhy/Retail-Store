package retial.store.dataModel;

import java.util.Date;

public class ElectronicDevice implements PurchaseObject {
	private String productName;
	private String deviceCategory;
	private Date producingDate;
	private double price;

	@Override
	public String getProductName() {
		return productName;
	}

	@Override
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public double getprice() {
		return price;
	}

	@Override
	public void setprice(double price) {
		this.price = price;
	}

	public String getDeviceCategory() {
		return deviceCategory;
	}

	public void setDeviceCategory(String deviceCategory) {
		this.deviceCategory = deviceCategory;
	}

	public Date getProduceingDate() {
		return producingDate;
	}

	public void setProduceingDate(Date produceingDate) {
		this.producingDate = produceingDate;
	}
}
