package by.galkina.restaurant.builder;

import by.galkina.restaurant.entity.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientsBuilder {
    public static List<Client> createClients(List<String> names){
        List<Client> clients = new ArrayList<>();
        for(int i=0;i<names.size();i++){
            clients.add(new Client(names.get(i)));
        }
        return clients;
    }
}
