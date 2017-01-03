package by.galkina.restaurant.builder;

import by.galkina.restaurant.entity.Restaurant;
import by.galkina.restaurant.exception.WrongArgumentException;

import java.util.Scanner;

public class RestaurantBuilder {

    public static void addCashDesks(String data, Restaurant restaurant) throws WrongArgumentException {
        Scanner scanner = new Scanner(data);
        if(scanner.hasNextInt()){
            int count = scanner.nextInt();
            for(int i=0;i<count;i++){
                restaurant.createCashDesk(i+1, (i+1)*500);
            }
        }
        else {
            throw new WrongArgumentException();
        }
    }
}
