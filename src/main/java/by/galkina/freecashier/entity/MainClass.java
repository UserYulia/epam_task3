package by.galkina.freecashier.entity;

import by.galkina.freecashier.exception.WrongFileNameException;
import by.galkina.freecashier.reader.TxtFileReader;
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
        int cashDeskCount = Integer.parseInt(restaurantData.get(0));
        for (int i = 0; i < cashDeskCount; i++){
            restaurant.createCashDesk(i+1,(i+2)*100);
        }
        for (int i = 0; i < restaurantData.size()-1; i++) {
            new Client(restaurantData.get(i+1)).start();
        }
    }
}
