package retial.store.discount.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import retial.store.dataModel.PurchaseObject;
import retial.store.dataModel.User;
import retial.store.dataModel.UserTypes;
import retial.store.discount.CalculateRetialUsersDiscount;

@TestInstance(value = Lifecycle.PER_CLASS)
public class userBillTest {

	SimpleDateFormat df = null;
	List<PurchaseObject> userCart = null;

	@BeforeAll
	private void setup() throws Exception {
		df = new SimpleDateFormat("yyyy-MM-dd");
		userCart = CalculateRetialUsersDiscount.getUserShoppingCart();
	}

	@Test
	public void calulateEmpolyeeBill() throws ParseException {
		User employee = new User();
		employee.setFristName("ahmed");
		employee.setLastName("Elbhy");
		employee.setStoreJoinDate(df.parse("2015-06-01"));
		employee.setUserType(UserTypes.EMPLOYEE);
		employee.setPurchaseObjects(userCart);

		double billAmount = CalculateRetialUsersDiscount.calculateBills(employee);

		assertEquals(billAmount, 36310.0);

	}

	@Test
	public void calulateAffiliateBill() throws ParseException {
		User affiliate = new User();
		affiliate.setFristName("aml");
		affiliate.setLastName("kamal");
		affiliate.setStoreJoinDate(df.parse("2017-08-01"));
		affiliate.setUserType(UserTypes.AFFILIATE);
		affiliate.setPurchaseObjects(userCart);

		double billAmount = CalculateRetialUsersDiscount.calculateBills(affiliate);

		assertEquals(billAmount, 46665.0);
	}

	@Test
	public void calulateCustomerJoinBefore2yearBill() throws ParseException {
		User customer2 = new User();
		customer2.setFristName("ahmed2");
		customer2.setLastName("Elbhy1");
		customer2.setStoreJoinDate(df.parse("2015-06-01"));
		customer2.setUserType(UserTypes.CUSTOMER);
		customer2.setPurchaseObjects(userCart);

		double billAmount = CalculateRetialUsersDiscount.calculateBills(customer2);

		assertEquals(billAmount, 49255.0);
	}

	@Test
	public void calulateCustomerJoinlessThan2yearsBill() throws ParseException {

		User customer1 = new User();
		customer1.setFristName("ahmed1");
		customer1.setLastName("Elbhy1");
		customer1.setStoreJoinDate(df.parse("2019-01-01"));
		customer1.setUserType(UserTypes.CUSTOMER);
		customer1.setPurchaseObjects(userCart);
		double billAmount = CalculateRetialUsersDiscount.calculateBills(customer1);

		assertEquals(billAmount, 51845.0);
	}
}
