package project2.achievers.DAO.shopper;

import project2.achievers.Entities.Items;
import project2.achievers.Entities.Shopper;
import project2.achievers.Entities.ShoppingList;
import project2.achievers.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopperDaoImp implements ShopperDao{
    @Override
    public Shopper createShopper(Shopper shopper) {
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into shoppers values(default, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, shopper.getShopperName());
            preparedStatement.setString(2, shopper.getShopperUsername());
            preparedStatement.setString(3, shopper.getShopperPassword());
            preparedStatement.setInt(4, shopper.getShopperZipCode());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            shopper.setShopperId(resultSet.getInt("shopper_id"));
            return shopper;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Shopper getShopperLoginByCredentials(String username, String password) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from shopperss where shopper_username= ? and shopper_password= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Shopper shopperLogin = new Shopper();
            shopperLogin.setShopperZipCode(resultSet.getInt("shopper_zip_code"));
            shopperLogin.setShopperName(resultSet.getString("shopper_name"));
            shopperLogin.setShopperUsername(resultSet.getString("shopper_username"));
            shopperLogin.setShopperPassword(resultSet.getString("shopper_password"));
            shopperLogin.setShopperId(resultSet.getInt("shopper_id"));
            return shopperLogin;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Boolean delete_a_shopper_account(int shopper_id) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "delete from shoppers where shopper_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, shopper_id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public Boolean select_a_shoppinglist_by_shopper(int shopperid, int shoppinglistid) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "update shopping_list set shopper_id = ? where shopping_list_id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, shopperid);
            preparedStatement.setInt(2, shoppinglistid);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;


        }
    }

    @Override
    public Boolean decline_a_shoppinglist_by_shopper(int shoppinglistid, String shoppercomment) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "update shopping_list set shopper_id = 0, shopper_comments= ?  where shopping_list_id= ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, shoppercomment);
            preparedStatement.setInt(2, shoppinglistid);
            return preparedStatement.executeUpdate() !=0 ;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;


        }
    }
    @Override
    public boolean updateListStatusByShopper(int shoppingListId) {
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "update shopping_list set list_status = ? where shopping_list_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,"Completed");
            preparedStatement.setInt(2,shoppingListId);
            return preparedStatement.executeUpdate() !=0;

        } catch (SQLException e){
            e.printStackTrace();
            return false;

        }


    }
    @Override
    public List<ShoppingList> getAllShoppingLists() {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from shopping_list where list_status = 'Waiting for shopper'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<ShoppingList> shoppingLists = new ArrayList<>();
            while (resultSet.next()) {
                ShoppingList shoppingList = new ShoppingList(
                        resultSet.getInt("shopping_list_id"),
                        resultSet.getString("shopping_list_name"),
                        resultSet.getString("customer_comments"),
                        resultSet.getString("shopper_comments"),
                        resultSet.getString("list_status"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("shopper_id")

                );

                shoppingLists.add(shoppingList);
            }

            return shoppingLists;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Items> getAllItems(int shoppinglistid) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from items where shopping_list_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,shoppinglistid);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Items> itemlist = new ArrayList<>();
            while (resultSet.next()) {
                Items item = new Items(
                        resultSet.getInt("item_id"),
                        resultSet.getString("item__name"),
                        resultSet.getInt("item_quantity"),
                        resultSet.getInt("shopping_list_id")

                );

                itemlist.add(item);
            }

            return itemlist;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}

