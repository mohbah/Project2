package com.revature.tests.DAO;

import org.testng.Assert;
import org.testng.annotations.Test;
import project2.achievers.DAO.customer.CustomerDao;
import project2.achievers.DAO.customer.CustomerDaoImp;
import project2.achievers.DAO.shopper.ShopperDao;
import project2.achievers.DAO.shopper.ShopperDaoImp;
import project2.achievers.Entities.Customer;
import project2.achievers.Entities.Items;
import project2.achievers.Entities.Shopper;
import project2.achievers.Entities.ShoppingList;

public class DAOTest {
    CustomerDao customerDao = new CustomerDaoImp();
    ShopperDao shopperDao = new ShopperDaoImp();


    @Test
    void createCustomer(){
        Customer newCustomer = new Customer("Hodge",
                "landy", "one", 30018,0);
        Customer returnedCustomer = customerDao.createCustomer(newCustomer);
        Assert.assertTrue(returnedCustomer.getCustomerId() != 0);
    }

    @Test
    void validateCustomerLogin(){
        Customer customerLogin = customerDao.getLoginByCredentials("landy", "one");
        Assert.assertEquals(customerLogin.getCustomerUsername(), "landy");
        Assert.assertEquals(customerLogin.getCustomerPassword(),"one");
    }

    @Test
    void createShopper(){
        Shopper newShopper = new Shopper("Mikey","Crazy Turtle","tmnt",
                10001, 0);
        Shopper returnedShopper = shopperDao.createShopper(newShopper);
        Assert.assertTrue(returnedShopper.getShopperId() !=0);
    }

    @Test
    void validateShopperLogin() {
        Shopper shopperLogin = shopperDao.getShopperLoginByCredentials("Crazy Turtle", "tmnt");
        Assert.assertEquals(shopperLogin.getShopperUsername(), "Crazy Turtle");
        Assert.assertEquals(shopperLogin.getShopperPassword(), "tmnt");
    }

    @Test
    void createShoppingList(){
        ShoppingList newShoppingList = new ShoppingList(0,"Super Bowl Party", "I must have wings from Kroger","Ok",
                "In Process",1,1);
        ShoppingList returnedShoppingList = customerDao.createShoppingList(newShoppingList);
        Assert.assertTrue(returnedShoppingList.getShoppingListId() != 0);
    }

    @Test
    void createItems(){
        Items items = new Items(1,"Banana", 6, 1);
        Items returnItems = customerDao.createItems(items);
        Assert.assertTrue(returnItems.getItemId() != 0);
    }

    @Test
    void deleteItems(){
        boolean itemDelete = customerDao.deleteItems(4);
        Assert.assertFalse(itemDelete);
    }

    @Test
    void deleteCustomerAccount(){
        boolean customerDelete = customerDao.delete_a_customer_account(3);
        Assert.assertFalse(customerDelete);
    }
    @Test
    void deleteShopperAccount(){
        boolean deleteShopper = shopperDao.delete_a_shopper_account(1);
        Assert.assertFalse(deleteShopper);
    }
/*
    @Test
    void declineShoppingListByShopper(){
        boolean declineShoppingList = shopperDao.decline_a_shoppinglist_by_shopper(1);
        Assert.assertFalse(declineShoppingList);
    }*/

    @Test
    void deleteShoppingList(){
        boolean shoppingListDelete = shopperDao.delete_a_shopper_account(1);
        Assert.assertFalse(shoppingListDelete);
    }




}
