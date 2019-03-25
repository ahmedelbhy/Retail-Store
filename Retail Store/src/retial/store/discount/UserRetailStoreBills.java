package retial.store.discount;

import java.util.List;

import retial.store.dataModel.PurchaseObject;
import retial.store.dataModel.User;
import retial.store.dataModel.UserTypes;

public class UserRetailStoreBills {

	public static void main(String[] args) throws Exception {
		List<PurchaseObject> userCart = CalculateRetialUsersDiscount.getUserShoppingCart();

		User employee = new User();
		employee.setFristName("ahmed");
		employee.setLastName("Elbhy");
		employee.setStoreJoinDate(CalculateRetialUsersDiscount.df.parse("2015-06-01"));
		employee.setUserType(UserTypes.EMPLOYEE);
		employee.setPurchaseObjects(userCart);

		System.out.println(CalculateRetialUsersDiscount.calculateBills(employee));

		User affiliate = new User();
		affiliate.setFristName("aml");
		affiliate.setLastName("kamal");
		affiliate.setStoreJoinDate(CalculateRetialUsersDiscount.df.parse("2017-08-01"));
		affiliate.setUserType(UserTypes.AFFILIATE);
		affiliate.setPurchaseObjects(userCart);

		System.out.println(CalculateRetialUsersDiscount.calculateBills(affiliate));

		User customer1 = new User();
		customer1.setFristName("ahmed1");
		customer1.setLastName("Elbhy1");
		customer1.setStoreJoinDate(CalculateRetialUsersDiscount.df.parse("2019-01-01"));
		customer1.setUserType(UserTypes.CUSTOMER);
		customer1.setPurchaseObjects(userCart);

		System.out.println(CalculateRetialUsersDiscount.calculateBills(customer1));

		User customer2 = new User();
		customer2.setFristName("ahmed2");
		customer2.setLastName("Elbhy1");
		customer2.setStoreJoinDate(CalculateRetialUsersDiscount.df.parse("2015-06-01"));
		customer2.setUserType(UserTypes.CUSTOMER);
		customer2.setPurchaseObjects(userCart);

		System.out.println(CalculateRetialUsersDiscount.calculateBills(customer2));

	}
}
