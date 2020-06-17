package com.service;

import com.dao.Customer_DAO;
import com.model_class.Customer;

public class Customer_Service{
		public static int create(Customer cust)
	{
		Customer_DAO cus = new Customer_DAO();

		int status=0;
		System.out.println("Before create");
		status=cus.createCustomer(cust);
		System.out.println("after create");
		return status;
		
	}
		
		public static int search(Customer cust)
		{
			Customer_DAO cus=new Customer_DAO();

			int status=0;
			status=cus.searchCustomer(cust);
			return status;
			
		}
		
		public static int update(Customer cust)
		{
			Customer_DAO cus=new Customer_DAO();

			int status=0;
			status=cus.updateCustomer(cust);
			return status;

		}

		
		
		public static int delete(Customer cust)
		{
			Customer_DAO cus=new Customer_DAO();

			int status=0;
			status=cus.deleteCustomer(cust);
			return status;

		}

}