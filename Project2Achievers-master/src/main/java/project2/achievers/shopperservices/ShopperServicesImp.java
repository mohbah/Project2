package project2.achievers.shopperservices;

import project2.achievers.DAO.shopper.ShopperDao;
import project2.achievers.Entities.Items;
import project2.achievers.Entities.Shopper;
import project2.achievers.Entities.ShoppingList;

import java.util.List;

public class ShopperServicesImp implements ShopperServices {



    ShopperDao shopperDao;

         public ShopperServicesImp(ShopperDao shopperDao){

             this.shopperDao=shopperDao;
         }



    @Override
    public Shopper createShopper(Shopper shopper) {
        return this.shopperDao.createShopper(shopper);
    }

    @Override
    public Shopper getShopperLoginByCredentialsService(String username, String password) {
        return this.shopperDao.getShopperLoginByCredentials(username,password);
    }

    @Override
    public Boolean delete_a_shopper_account_service(int shopper_id) {
        try {
            return this.shopperDao.delete_a_shopper_account(shopper_id);

        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public Boolean select_a_shoppinglist_by_shopper_service(int shopperid, int shoppinglistid) {
        return this.shopperDao.select_a_shoppinglist_by_shopper(shopperid, shoppinglistid);
    }

    @Override
    public Boolean decline_a_shoppinglist_by_shopper_service(int shoppinglistid, String shoppercomment) {
        return this.shopperDao.decline_a_shoppinglist_by_shopper(shoppinglistid, shoppercomment);
    }
    @Override
    public boolean updateListStatusByShopperServices(int shoppingListId) {
        return this.shopperDao.updateListStatusByShopper(shoppingListId);
    }

    @Override
    public List<ShoppingList> getAllShoppingListsServices() {
        return this.shopperDao.getAllShoppingLists();
    }

    @Override
    public List<Items> getAllItemsService(int shoppinglistid) {
        return  this.shopperDao.getAllItems(shoppinglistid);
    }


}
