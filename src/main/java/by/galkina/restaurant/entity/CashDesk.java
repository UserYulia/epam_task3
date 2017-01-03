package by.galkina.restaurant.entity;

import org.apache.log4j.Logger;
import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CashDesk{
    private static final Logger LOG = Logger.getLogger(CashDesk.class);
    private ReentrantLock lock = new ReentrantLock();
    private ArrayDeque<Client> clients;
    private long id;
    private int timeOfService;
    private Restaurant restaurant;
    private CashDeskState state;

    public CashDesk(long number, int timeOfService) {
        clients = new ArrayDeque<>();
        this.id = number;
        this.timeOfService = timeOfService;
        this.restaurant = Restaurant.getInstance();
        this.state = new FreeCashDeskState();
    }


    public void serveClient(Client client)  {
        lock.lock();
        try {
            TimeUnit.MILLISECONDS.sleep(timeOfService * client.getOrderSize());
            removeClient(client);
        } catch (InterruptedException e) {
            LOG.fatal(e.getMessage());
        }
        LOG.info("Client "+client.getClientName() + " is served");
        lock.unlock();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public ArrayDeque<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        lock.lock();
        clients.addLast(client);
        lock.unlock();
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public long getNumber() {
        return id;
    }

    public CashDeskState getCashDeskState() {
        return state;
    }

    public void setState(CashDeskState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CashDesk{" +
                "id=" + id +
                ", timeOfService=" + timeOfService +
                '}';
    }
}
