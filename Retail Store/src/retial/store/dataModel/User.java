package retial.store.dataModel;

import java.util.Date;
import java.util.List;

public class User {
	private String fristName;
	private String lastName;
	private Date storeJoinDate;
	private UserTypes userType;
	private List<PurchaseObject> purchaseObjects;

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getStoreJoinDate() {
		return storeJoinDate;
	}

	public void setStoreJoinDate(Date storeJoinDate) {
		this.storeJoinDate = storeJoinDate;
	}

	public UserTypes getUserType() {
		return userType;
	}

	public void setUserType(UserTypes userType) {
		this.userType = userType;
	}

	public List<PurchaseObject> getPurchaseObjects() {
		return purchaseObjects;
	}

	public void setPurchaseObjects(List<PurchaseObject> purchaseObjects) {
		this.purchaseObjects = purchaseObjects;
	}

}
