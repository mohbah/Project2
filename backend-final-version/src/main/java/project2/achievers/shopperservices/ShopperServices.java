package project2.achievers.shopperservices;

import project2.achievers.Entities.Items;
import project2.achievers.Entities.Shopper;
import project2.achievers.Entities.ShoppingList;

import java.util.List;

public interface ShopperServices {

    Shopper createShopper(Shopper shopper);

    Shopper getShopperLoginByCredentialsService(String username, String password);

    Boolean delete_a_shopper_account_service(int shopper_id);

    Boolean select_a_shoppinglist_by_shopper_service(int shopperid, int shoppinglistid);

    Boolean decline_a_shoppinglist_by_shopper_service(int shoppinglistid, String shoppercomment);

    boolean updateListStatusByShopperServices(int shoppingListId);

    List<ShoppingList> getAllShoppingListsServices();

    List<Items> getAllItemsService(int shoppinglistid);
}
