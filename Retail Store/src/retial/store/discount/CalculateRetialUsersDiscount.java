package retial.store.discount;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import retial.store.dataModel.ElectronicDevice;
import retial.store.dataModel.Groceries;
import retial.store.dataModel.PurchaseObject;
import retial.store.dataModel.ServersPC;
import retial.store.dataModel.User;
import retial.store.dataModel.UserTypes;

/**
 * If the user is an employee of the store, he gets a 30% discount 2. If the
 * user is an affiliate of the store, he gets a 10% discount 3. If the user has
 * been a customer for over 2 years, he gets a 5% discount. 4. For every $100 on
 * the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a
 * discount). 5. The percentage based discounts do not apply on groceries. 6. A
 * user can get only one of the percentage based discounts on a bill. Write a
 * program in a programming language of your choice with test cases such that
 * given a bill, it finds the net payable amount. Please note the stress is on
 * object oriented approach and test coverage. User interface is not required.
 * What we care about: Required Activities • Object oriented programming
 * approach, provide a high level UML class diagram of all the key classes in
 * your solution. This can either be on paper or using a CASE tool • Unit tests
 * to achieve good code coverage, good use of Mocking • Code to be generic and
 * simple • Leverage today's best coding practices • Clear README.md that
 * explains how the code and the test can be run and how the coverage reports
 * can be generated Bonus Activities • Create scripts, e.g. Maven, etc. to: o
 * build the project from the command-line o run static code analysis such as
 * linting o run unit tests and code coverage • SonarQube report for the code
 * showing its quality summary
 */
public class CalculateRetialUsersDiscount {
	private SimpleDateFormat dateFormat;

	public CalculateRetialUsersDiscount() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}

	/**
	 * 
	 * @param user
	 * @return percentage dicount
	 */
	public double calculatePrecentageDiscount(User user) {
		double discountprecent = 0;
		long yearTimeStamp = 1 * 360 * 24 * 60 * 60;
		if (user != null)
			switch (user.getUserType()) {
			case EMPLOYEE:
				discountprecent = 30;
				break;
			case AFFILIATE:
				discountprecent = 10;
				break;
			case CUSTOMER:
				long currentDate = Instant.now().getEpochSecond();
				long userJoinDate = currentDate;
				if (user.getStoreJoinDate() != null)
					userJoinDate = user.getStoreJoinDate().toInstant().getEpochSecond();
				long joinInterval = currentDate - userJoinDate;
				boolean validCustomer = (joinInterval / yearTimeStamp) >= 2;
				if (validCustomer)
					discountprecent = 5;
				break;
			}
		return discountprecent;
	}

	public List<PurchaseObject> getUserShoppingCart() throws Exception {
		List<PurchaseObject> userCart = new ArrayList<PurchaseObject>();
		Groceries tom = new Groceries();
		tom.setProductName("Tomatos");
		tom.setQuantity(3);
		tom.setprice(10);
		userCart.add(tom);
		Groceries rice = new Groceries();
		rice.setProductName("Rice");
		rice.setQuantity(5);
		rice.setprice(60);
		userCart.add(rice);
		
		ServersPC xeon = new ServersPC();
		xeon.setProductName("server Intel");
		xeon.setServerRamSize(16);
		xeon.setServerProcessor("XEON");
		xeon.setprice(20000);
		userCart.add(xeon);
		
		ServersPC i7 = new ServersPC();
		i7.setProductName("Server Oracle");
		i7.setServerRamSize(32);
		i7.setServerProcessor("i7");
		i7.setprice(15000);
		userCart.add(i7);
		
		ElectronicDevice device1 = new ElectronicDevice();
		device1.setProductName("Sumsung j7");
		device1.setDeviceCategory("A");
		device1.setProduceingDate(dateFormat.parse("2016-05-15"));
		device1.setprice(4500);
		userCart.add(device1);
		
		ElectronicDevice device2 = new ElectronicDevice();
		device2.setProductName("Sumsung S10");
		device2.setDeviceCategory("A");
		device2.setProduceingDate(dateFormat.parse("2019-03-15"));
		device2.setprice(15000);
		userCart.add(device2);
		return userCart;
	}

	public double calculateBills(User user) {
		double userdiscountPrecent = calculatePrecentageDiscount(user);
		double billTotalAmt = 0;
		double electroniceTotalCost = 0;
		double groceriesTotalCost = 0;
		for (PurchaseObject purchase : user.getPurchaseObjects()) {
			if (!(purchase instanceof Groceries))
				electroniceTotalCost += purchase.getprice();
			else
				groceriesTotalCost += purchase.getprice();
		}
		// Percentage discount
		if (electroniceTotalCost > 0 && userdiscountPrecent > 0) {
			double dicountAmount = electroniceTotalCost * (userdiscountPrecent / 100);
			electroniceTotalCost = electroniceTotalCost - dicountAmount;
		}
		// 100 Dollar Discount
		billTotalAmt = electroniceTotalCost + groceriesTotalCost;
		int hundredDollarDiscount = ((int) (billTotalAmt / 100)) * 5;
		billTotalAmt = billTotalAmt - hundredDollarDiscount;
		return billTotalAmt;
	}

	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}
}
