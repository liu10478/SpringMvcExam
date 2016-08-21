package zyx.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zyx.Dao.IAddress;
import zyx.Dao.ICustomer;
import zyx.Dao.IStore;
import zyx.entity.Address;
import zyx.entity.Customer;
import zyx.entity.Page;

@Controller
public class CustomerService {
	@Resource
	private ICustomer icustomer;
	@Resource
	private IStore istore;
	@Resource
	private IAddress iaddress;
	
//	测试ajax json
	@RequestMapping("/testajax")
	@ResponseBody
	public Map<String,Object> testajax(Integer pagenum){
		int count=icustomer.getCustomerCount();
		int countpage;
		if(count%20==0){
			countpage=count/20;
		}
		else{
			countpage=count/20+1;
		}
		int begin=(pagenum-1)*20;
		int num=20;
		Page page=new Page();
		page.setBegin(begin);
		page.setNum(num);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("count", count);
		map.put("countpage", countpage);
		map.put("customers", icustomer.getCustomerByPage(page));
		map.put("nowpage", pagenum);
		return map;
		
	}
	
	@RequestMapping("/logout")
	public String logoutCustomer(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = "/updatecustomer", method = RequestMethod.POST)
	public String updateCustomer(int customer_id,Map<String, Object> map) {
		map.put("customer", icustomer.queryCustomerById(customer_id));
		map.put("stores", istore.list());
		map.put("addresses", iaddress.list());
		
		return "inputcustomer";
	}

	@RequestMapping(value = "/deletecustomer", method = RequestMethod.POST)
	public String deleteCustomer(int customer_id) {
		icustomer.deleteCustomer(customer_id);
		return "redirect:/customerlist";
	}

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public String addcustomersave(@Valid Customer customer, BindingResult result, Map<String, Object> map) {
		
		if (result.getErrorCount() > 0) {
			System.out.println("出错");
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + " " + error.getDefaultMessage());
			}
			map.put("stores", istore.list());
			map.put("addresses", iaddress.list());
			return "inputcustomer";
		}
		if(customer.getCustomer_id()!=0){
			icustomer.updateCustomer(customer);
		}
		else{
			customer.setStore_id(1);
			customer.setCreate_date(new Date());
			icustomer.addCustomer(customer);
		}
		int count=icustomer.getCustomerCount();
		int countpage;
		if(count%20==0){
			countpage=count/20;
		}
		else{
			countpage=count/20+1;
		}
		map.put("count", count);
		map.put("countpage", countpage);
		return "customerlist";
	}

	@RequestMapping(value = "/addcustomer", method = RequestMethod.GET)
	public String addcustomer(Map<String, Object> map) {
		map.put("stores", istore.list());
		map.put("addresses", iaddress.list());
		map.put("customer", new Customer());
		return "inputcustomer";
	}

	@RequestMapping("/customerlist")
	@ResponseBody
	public List<Customer> customerlist(@RequestParam(value="pagenum",required=false,defaultValue="1") Integer pagenum,Map<String, Object> map) {
		int count=icustomer.getCustomerCount();
		int countpage;
		if(count%20==0){
			countpage=count/20;
		}
		else{
			countpage=count/20+1;
		}
		int begin=(pagenum-1)*20;
		int num=20;
		Page page=new Page();
		page.setBegin(begin);
		page.setNum(num);
		List<Customer> list=icustomer.getCustomerByPage(page);
		map.put("count", count);
		map.put("countpage", countpage);
		map.put("customers", icustomer.getCustomerByPage(page));
		map.put("nowpage", pagenum);
		return list;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String customerloginPost(Customer customer, Map<String, Object> map, HttpServletRequest request) {
		
		Customer customer1=icustomer.queryCustomerByFirstname(customer.getFirst_name());
		if(customer1!=null){
			
		
		request.getSession().setAttribute("customer", customer);
		int count=icustomer.getCustomerCount();
		int countpage;
		if(count%20==0){
			countpage=count/20;
		}
		else{
			countpage=count/20+1;
		}
		map.put("count", count);
		map.put("countpage", countpage);
		return "customerlist";
		}
		
		else{
			return "redirect:/login";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String customerlogin() {
		System.out.println("login");
		return "login";
	}
}