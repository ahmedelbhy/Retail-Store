package retial.store.discount;

import java.util.List;

import retial.store.dataModel.PurchaseObject;
import retial.store.dataModel.User;
import retial.store.dataModel.UserTypes;

public class UserRetailStoreBills {

	public static void main(String[] args) throws Exception {
		CalculateRetialUsersDiscount retailUser = new CalculateRetialUsersDiscount();

		List<PurchaseObject> userCart = retailUser.getUserShoppingCart();

		User employee = new User();
		employee.setfirstName("ahmed");
		employee.setLastName("Elbhy");
		employee.setStoreJoinDate(retailUser.getDateFormat().parse("2015-06-01"));
		employee.setUserType(UserTypes.EMPLOYEE);
		employee.setPurchaseObjects(userCart);
		System.out.println(retailUser.calculateBills(employee));

		User affiliate = new User();
		affiliate.setfirstName("aml");
		affiliate.setLastName("kamal");
		affiliate.setStoreJoinDate(retailUser.getDateFormat().parse("2017-08-01"));
		affiliate.setUserType(UserTypes.AFFILIATE);
		affiliate.setPurchaseObjects(userCart);
		System.out.println(retailUser.calculateBills(affiliate));

		User customerJoinRecently = new User();
		customerJoinRecently.setfirstName("ahmed1");
		customerJoinRecently.setLastName("Elbhy1");
		customerJoinRecently.setStoreJoinDate(retailUser.getDateFormat().parse("2019-01-01"));
		customerJoinRecently.setUserType(UserTypes.CUSTOMER);
		customerJoinRecently.setPurchaseObjects(userCart);
		System.out.println(retailUser.calculateBills(customerJoinRecently));

		User customerJoinBefore2years = new User();
		customerJoinBefore2years.setfirstName("ahmed2");
		customerJoinBefore2years.setLastName("Elbhy1");
		customerJoinBefore2years.setStoreJoinDate(retailUser.getDateFormat().parse("2015-06-01"));
		customerJoinBefore2years.setUserType(UserTypes.CUSTOMER);
		customerJoinBefore2years.setPurchaseObjects(userCart);
		System.out.println(retailUser.calculateBills(customerJoinBefore2years));
		
		User customerWithNullJoinDate = new User();
		customerWithNullJoinDate.setfirstName("ahmed2");
		customerWithNullJoinDate.setLastName("Elbhy1");
		customerWithNullJoinDate.setStoreJoinDate(null);
		customerWithNullJoinDate.setUserType(UserTypes.CUSTOMER);
		customerWithNullJoinDate.setPurchaseObjects(userCart);
		System.out.println(retailUser.calculateBills(customerWithNullJoinDate));

	}
}
