package com.revature.tests;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project2.achievers.DAO.customer.CustomerDaoImp;
import project2.achievers.DAO.shopper.ShopperDaoImp;
import project2.achievers.Entities.Customer;
import project2.achievers.Entities.Items;
import project2.achievers.Entities.Shopper;
import project2.achievers.Entities.ShoppingList;
import project2.achievers.customerservices.CustomerServicesImp;
import project2.achievers.shopperservices.ShopperServicesImp;

import java.util.List;

public class Mocking {

    public static CustomerServicesImp customerServicesImp;
    public static CustomerDaoImp customerDaoImp;
    public static ShopperServicesImp shopperServicesImp;
    public static ShopperDaoImp shopperDaoImp;


    @BeforeClass
    public void setup(){
        customerDaoImp = Mockito.mock(CustomerDaoImp.class);
        customerServicesImp = new CustomerServicesImp(customerDaoImp);
        shopperDaoImp = Mockito.mock(ShopperDaoImp.class);
        shopperServicesImp = new ShopperServicesImp(shopperDaoImp);

    }

    @Test
    //verify that the path of execution is working as expected
    public void checkCustomerLoginCallAndInputs() {
        Customer customer = customerServicesImp.getLoginByCredentialsService("saiyan", "super");
        Mockito.verify(customerDaoImp).getLoginByCredentials("saiyan","super");
    }

    @Test
    //verify that the path of execution is working as expected
    public void checkShopperLoginCallAndInputs() {
        Shopper shopper = shopperServicesImp.getShopperLoginByCredentialsService("Crazy Turtle", "tmnt");
        Mockito.verify(shopperDaoImp).getShopperLoginByCredentials("Crazy Turtle","tmnt");
    }

    @Test
    public void selectAShoppinglistByShopperService(){
        Mockito.when(shopperDaoImp.select_a_shoppinglist_by_shopper(1, 32)).thenReturn(Boolean.TRUE);
        Boolean result = shopperServicesImp.select_a_shoppinglist_by_shopper_service(1, 32);
        Assert.assertEquals(result,Boolean.TRUE);
    }

    @Test
    public void selectANonExistingShoppinglistByShopperService(){
        Mockito.when(shopperDaoImp.select_a_shoppinglist_by_shopper(1, 32)).thenReturn(Boolean.FALSE);
        Boolean result = shopperServicesImp.select_a_shoppinglist_by_shopper_service(1, 32);
        Assert.assertEquals(result,Boolean.FALSE);
    }

    @Test
    public void deleteAShopperAccountService(){
        Mockito.when(shopperDaoImp.delete_a_shopper_account(1)).thenReturn(Boolean.TRUE);
        Boolean result = shopperServicesImp.delete_a_shopper_account_service(1);
        Assert.assertEquals(result,Boolean.TRUE);
    }

    @Test
    public void deleteACustomerAccountService(){
        Mockito.when(customerDaoImp.delete_a_customer_account(1)).thenReturn(Boolean.TRUE);
        Boolean result = customerServicesImp.delete_a_customer_account_service(1);
        Assert.assertEquals(result,Boolean.TRUE);
    }

    @Test
    public void deleteItemsService(){
        Mockito.when(customerDaoImp.deleteItems(1)).thenReturn(Boolean.TRUE);
        Boolean result = customerServicesImp.deleteItemsService(1);
        Assert.assertEquals(result,Boolean.TRUE);
    }

    @Test
    public void deleteShoppingListService(){
        Mockito.when(customerDaoImp.deleteShoppingList(1)).thenReturn(Boolean.TRUE);
        Boolean result = customerServicesImp.deleteShoppingListService(1);
        Assert.assertEquals(result, Boolean.TRUE);
    }

   /* @Test
    public void declineAShoppinglistByShopperService(){
        Mockito.when(shopperDaoImp.decline_a_shoppinglist_by_shopper(1)).thenReturn(Boolean.TRUE);
        Boolean result = shopperServicesImp.decline_a_shoppinglist_by_shopper_service(1);
        Assert.assertEquals(result,Boolean.TRUE);
    }*/

    @Test
    public void createCustomer(){
        Mockito.when(customerDaoImp.createCustomer(new Customer("Goku","Gohan",
                "ss3",1, 2))).thenReturn(new Customer("Goku","Gohan",
                "ss3",1, 2));
        Customer result = customerServicesImp.createCustomer(new Customer("Goku","Gohan",
                "ss3",1, 2));
        Assert.assertEquals(result, new Customer("Goku","Gohan",
                "ss3",1, 2));
    }

    @Test
    public void createShopper() {
        Mockito.when(shopperDaoImp.createShopper(new Shopper("Terra", "soilQueen",
                "earth", 5, 42))).thenReturn(new Shopper("Terra", "soilQueen",
                "earth", 5, 42));
        Shopper result = shopperServicesImp.createShopper(new Shopper("Terra", "soilQueen",
                "earth", 5, 42));
        Assert.assertEquals(result, new Shopper("Terra", "soilQueen",
                "earth", 5, 42));
    }

    @Test
    public void createShoppingList(){
        Mockito.when(customerDaoImp.createShoppingList(new ShoppingList(1,"SuperList",
                "Organics Only","Ok","In Process", 1,
                2))).thenReturn(new ShoppingList(1,"SuperList","Organics Only",
                "Ok","In Process", 1,2));
        ShoppingList result = customerServicesImp.createShoppingList(new ShoppingList(1,"SuperList",
                "Organics Only","Ok","In Process", 1,2));
        Assert.assertEquals(result, new ShoppingList(1,"SuperList","Organics Only",
                "Ok","In Process", 1,2));
    }

    @Test
    public void createItem(){
        Mockito.when(customerDaoImp.createItems(new Items(3,"Banana", 6,1))).thenReturn(
                new Items(3,"Banana", 6,1));
        Items result = customerServicesImp.createItemsService(new Items(3,"Banana", 6,1));
        Assert.assertEquals(result, new Items(3,"Banana", 6,1));
    }

}