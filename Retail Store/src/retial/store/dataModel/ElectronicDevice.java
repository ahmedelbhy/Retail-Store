package retial.store.dataModel;

import java.util.Date;

public class ElectronicDevice implements PurchaseObject {
	private String productName;
	private String deviceCategory;
	private Date produceingDate;
	private double price;

	public String getDeviceCategory() {
		return deviceCategory;
	}

	public void setDeviceCategory(String deviceCategory) {
		this.deviceCategory = deviceCategory;
	}

	public Date getProduceingDate() {
		return produceingDate;
	}

	public void setProduceingDate(Date produceingDate) {
		this.produceingDate = produceingDate;
	}

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

}
