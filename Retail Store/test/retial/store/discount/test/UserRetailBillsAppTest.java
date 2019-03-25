package retial.store.discount.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import retial.store.dataModel.PurchaseObject;
import retial.store.dataModel.User;
import retial.store.dataModel.UserTypes;
import retial.store.discount.CalculateRetialUsersDiscount;

@TestInstance(Lifecycle.PER_CLASS)
public class UserRetailBillsAppTest {
	List<PurchaseObject> userCart = null;
	private CalculateRetialUsersDiscount retailUser;

	@BeforeAll
	private void setup() throws Exception {
		retailUser = new CalculateRetialUsersDiscount();
		userCart = retailUser.getUserShoppingCart();
	}

	private User getUserEmployeeType() throws ParseException {
		User employee = new User();
		employee.setfirstName("ahmed");
		employee.setLastName("Elbhy");
		employee.setStoreJoinDate(retailUser.getDateFormat().parse("2015-06-01"));
		employee.setUserType(UserTypes.EMPLOYEE);
		employee.setPurchaseObjects(userCart);
		return employee;
	}

	private User getUserAffiliateType() throws ParseException {
		User affiliate = new User();
		affiliate.setfirstName("aml");
		affiliate.setLastName("kamal");
		affiliate.setStoreJoinDate(retailUser.getDateFormat().parse("2017-08-01"));
		affiliate.setUserType(UserTypes.AFFILIATE);
		affiliate.setPurchaseObjects(userCart);
		return affiliate;
	}

	private User getUserCustomerTypeJoinBefore2year() throws ParseException {
		User customer = new User();
		customer.setfirstName("ahmed2");
		customer.setLastName("Elbhy1");
		customer.setStoreJoinDate(retailUser.getDateFormat().parse("2015-06-01"));
		customer.setUserType(UserTypes.CUSTOMER);
		customer.setPurchaseObjects(userCart);
		return customer;
	}

	private User getUserCustomerTypeJoinLessThan2year() throws ParseException {
		User customer = new User();
		customer.setfirstName("ahmed1");
		customer.setLastName("Elbhy1");
		customer.setStoreJoinDate(retailUser.getDateFormat().parse("2019-01-01"));
		customer.setUserType(UserTypes.CUSTOMER);
		customer.setPurchaseObjects(userCart);
		return customer;
	}

	private User getUserCustomerTypeJoinNullDate() throws ParseException {
		User customer = new User();
		customer.setfirstName("ahmed1");
		customer.setLastName("Elbhy1");
		customer.setStoreJoinDate(retailUser.getDateFormat().parse("2019-01-01"));
		customer.setUserType(UserTypes.CUSTOMER);
		customer.setPurchaseObjects(userCart);
		return customer;
	}

	@Test
	public void getDiscountPrecentageForEmployeeType() throws ParseException {
		User employee = getUserEmployeeType();
		double discountPrecent = retailUser.calculatePrecentageDiscount(employee);
		assertEquals(discountPrecent, 30.0);
	}

	@Test
	public void getDiscountPrecentageForAffiliateType() throws ParseException {
		User affiliate = getUserAffiliateType();
		double discountPrecent = retailUser.calculatePrecentageDiscount(affiliate);
		assertEquals(discountPrecent, 10.0);
	}

	@Test
	public void getDiscountPrecentageForCustomerJoinBefore2yearType() throws ParseException {
		User customer = getUserCustomerTypeJoinBefore2year();
		double discountPrecent = retailUser.calculatePrecentageDiscount(customer);
		assertEquals(discountPrecent, 5.0);
	}

	@Test
	public void getDiscountPrecentageForCustomerJoinlessThan2yearsType() throws ParseException {
		User customer = getUserCustomerTypeJoinLessThan2year();
		double discountPrecent = retailUser.calculatePrecentageDiscount(customer);
		assertEquals(discountPrecent, 0.0);
	}

	@Test
	public void getDiscountPrecentageForCustomerwithNullJoinDateType() throws ParseException {
		User customer3 = getUserCustomerTypeJoinNullDate();
		double discountPrecent = retailUser.calculatePrecentageDiscount(customer3);
		assertEquals(discountPrecent, 0.0);
	}

	@Test
	public void calulateEmployeeBill() throws ParseException {
		User employee = getUserEmployeeType();
		double billAmount = retailUser.calculateBills(employee);
		assertEquals(billAmount, 36310.0);
	}

	@Test
	public void calulateAffiliateBill() throws ParseException {
		User affiliate = getUserAffiliateType();
		double billAmount = retailUser.calculateBills(affiliate);

		assertEquals(billAmount, 46665.0);
	}

	@Test
	public void calulateCustomerJoinBefore2yearBill() throws ParseException {
		User customer = getUserCustomerTypeJoinBefore2year();
		double billAmount = retailUser.calculateBills(customer);
		assertEquals(billAmount, 49255.0);
	}

	@Test
	public void calulateCustomerJoinlessThan2yearsBill() throws ParseException {
		User customer = getUserCustomerTypeJoinLessThan2year();
		double billAmount = retailUser.calculateBills(customer);
		assertEquals(billAmount, 51845.0);
	}

	@Test
	public void calulateCustomerBillwithNullJoinDate() throws ParseException {
		User customer3 = getUserCustomerTypeJoinNullDate();
		double billAmount = retailUser.calculateBills(customer3);
		assertEquals(billAmount, 51845.0);
	}
}
