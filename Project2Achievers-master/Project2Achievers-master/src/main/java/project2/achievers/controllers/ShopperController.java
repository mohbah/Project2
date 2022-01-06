package project2.achievers.controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import project2.achievers.Entities.Shopper;
import project2.achievers.customerexceptions.InvalidLogin;
import project2.achievers.shopperservices.ShopperServices;

import java.util.Map;

public class ShopperController {


     ShopperServices shopperServices;

    public ShopperController(ShopperServices shopperServices)
    {this.shopperServices=shopperServices;}


    public Handler createShopper = ctx ->{
        Gson gson = new Gson();
        Shopper newShopper = gson.fromJson(ctx.body(), Shopper.class);
        Shopper createdShopper = this.shopperServices.createShopper(newShopper);
        String createdShopperJson = gson.toJson(createdShopper);
        ctx.result(createdShopperJson);
        ctx.status(201);
    };


    public Handler getShopperLoginByCredentials = ctx ->{

        try{
            Gson gson = new Gson();
            Map<String, String> credentials = gson.fromJson(ctx.body(), Map.class);
            Shopper validateShopperLogin = this.shopperServices.getShopperLoginByCredentialsService(credentials.get("username"), credentials.get("password"));
            String validateLoginJson = gson.toJson(validateShopperLogin);
            ctx.result(validateLoginJson);
            ctx.status(200);

        } catch (InvalidLogin e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };


    public Handler deleteShopper = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean c = shopperServices.delete_a_shopper_account_service(id);
        ctx.status(200);
    };

    public Handler selectashoppinglist = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("shopperid"));
        int listid = Integer.parseInt(ctx.pathParam("listid"));

        boolean a = shopperServices.select_a_shoppinglist_by_shopper_service(id, listid);
        ctx.status(200);
    };

    public Handler declineashoppinglist = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("shoppinglistid"));
        boolean a = shopperServices.decline_a_shoppinglist_by_shopper_service(id);
        ctx.status(200);



    };




}
