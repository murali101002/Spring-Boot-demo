package com.spring.spring_boot.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_boot.Model.Customer;
@RestController
@RequestMapping("/cust")
public class CustomerController {
	private static List<Customer> custList = new ArrayList<Customer>();
	static{
		custList.add(new Customer(1, "Murali"));
		custList.add(new Customer(2,"Nani"));
		custList.add(new Customer(3,"Akurati"));
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> getAllCusts(){
		return custList;
	}
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String removeCustomer(@PathVariable int id){
		Customer cust = null;
		String custName = null;
		for(Customer c:custList){
			if(c.getId()==id){
				cust = c;
			}
		}
		if(cust!=null){
			custName = cust.getName();
			custList.remove(cust);
		}else return "No id found";
		return custName+" is removed.";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String createCustomer(Customer customer){
		customer.setId(4);
		customer.setName("Murali");
		custList.add(customer);
		return customer.getName()+" is created.";
	}
}
