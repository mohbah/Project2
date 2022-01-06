package project2.achievers.shopperservices;

import project2.achievers.Entities.Shopper;

public interface ShopperServices {

    Shopper createShopper(Shopper shopper);

    Shopper getShopperLoginByCredentialsService(String username, String password);

    Boolean delete_a_shopper_account_service(int shopper_id);

    Boolean select_a_shoppinglist_by_shopper_service(int shopperid, int shoppinglistid);

    Boolean decline_a_shoppinglist_by_shopper_service(int shoppinglistid);
}
