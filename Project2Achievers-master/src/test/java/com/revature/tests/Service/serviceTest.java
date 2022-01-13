package com.revature.tests.Service;

import org.testng.Assert;
import org.testng.annotations.Test;
import project2.achievers.DAO.customer.CustomerDao;
import project2.achievers.DAO.customer.CustomerDaoImp;
import project2.achievers.DAO.shopper.ShopperDao;
import project2.achievers.DAO.shopper.ShopperDaoImp;
import project2.achievers.Entities.Customer;
import project2.achievers.Entities.Shopper;
import project2.achievers.customerservices.CustomerServices;
import project2.achievers.customerservices.CustomerServicesImp;
import project2.achievers.shopperservices.ShopperServices;
import project2.achievers.shopperservices.ShopperServicesImp;

public class serviceTest {

    static CustomerDao customerDao = new CustomerDaoImp();
    static CustomerServices customerServices = new CustomerServicesImp(customerDao);
    static ShopperDao shopperDao = new ShopperDaoImp();
    static ShopperServices shopperServices = new ShopperServicesImp(shopperDao);

    @Test
    void validateCustomerLogin() {
        Customer customer = customerServices.getLoginByCredentialsService("javaris85", "password");
        Assert.assertEquals(customer.getCustomerUsername(), "javaris85");
        Assert.assertEquals(customer.getCustomerPassword(), "password");
    }
    @Test
    void validateShopperLogin() {
        Shopper shopper = shopperServices.getShopperLoginByCredentialsService("Crazy Turtle", "tmnt");
        Assert.assertEquals(shopper.getShopperUsername(), "Crazy Turtle");
        Assert.assertEquals(shopper.getShopperPassword(), "tmnt");
    }

    @Test
    void validateCreateCustomer(){
        Customer customer = customerServices.createCustomer(new Customer("Cell","tail",
                "ss3",1000, 22));
    }

    @Test
    void validateCreateShopper(){
        Shopper shopper = shopperServices.createShopper(new Shopper("Frieza","baldy",
                "golden",1000, 21));
    }

    @Test
    void validateDeleteCustomer(){
        boolean deleteCustomer = customerServices.delete_a_customer_account_service(9);
        Assert.assertFalse(deleteCustomer);
    }

    @Test
    void validateShoppingList(){
        boolean shopperList = shopperServices.select_a_shoppinglist_by_shopper_service(1,1);
        Assert.assertTrue(shopperList);
    }

    /*@Test
    void validateDeclineShopperList(){
        boolean declineList = shopperServices.decline_a_shoppinglist_by_shopper_service(2);
        Assert.assertFalse(declineList);
    }*/


}
