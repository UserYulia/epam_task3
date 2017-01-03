package by.galkina.restaurant.entity;

import by.galkina.restaurant.builder.ClientsBuilder;
import by.galkina.restaurant.builder.RestaurantBuilder;
import by.galkina.restaurant.exception.WrongArgumentException;
import by.galkina.restaurant.exception.WrongFileNameException;
import by.galkina.restaurant.reader.TxtFileReader;
import java.util.List;


public class MainClass {
    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();
        List<String> restaurantData = null;
        try {
            restaurantData = TxtFileReader.readData("src/main/resources/data.txt");
        } catch (WrongFileNameException e) {
            e.printStackTrace();
        }
        try {
            RestaurantBuilder.addCashDesks(restaurantData.get(0),restaurant);
        } catch (WrongArgumentException e) {
            e.printStackTrace();
        }
        List<Client> clients = ClientsBuilder.createClients(restaurantData.subList(1, restaurantData.size()));
        for (Client client:clients){
            client.start();
        }
    }
}
