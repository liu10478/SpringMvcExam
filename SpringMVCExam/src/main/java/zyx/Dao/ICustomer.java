package zyx.Dao;

import java.util.List;

import zyx.entity.Customer;
import zyx.entity.Page;

public interface ICustomer {
	public List<Customer> list();
	public void addCustomer(Customer customer);
	public void deleteCustomer(int customer_id);
	public Customer queryCustomerById(int customer_id);
	public Customer queryCustomerByFirstname(String first_name);
	public List<Customer> getCustomerByPage(Page page);
	public int getCustomerCount();
	public void updateCustomer(Customer customer);

}
