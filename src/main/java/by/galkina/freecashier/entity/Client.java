package by.galkina.freecashier.entity;

import org.apache.log4j.Logger;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Client extends Thread {
    private static final Logger LOG = Logger.getLogger(Client.class);
    private volatile CashDesk cashDesk;
    private Restaurant restaurant = Restaurant.getInstance();
    private String name;
    private int orderSize;
    private static final int MAX_ORDER_SIZE = 25;
    private ReentrantLock lock = new ReentrantLock();

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        LOG.info("Client " + name + " visit the Restaurant.");
        if (madePreOrder()) {
            lock.lock();
            chooseCashDesk();
            cashDesk.serveClient(this);
            lock.unlock();
        }
        else {
            lock.lock();
            chooseCashDesk();
            while (cashDesk.getClients().peekFirst()!=this){
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    chooseAnotherCashDesk();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            makeOrder();
            cashDesk.serveClient(this);
            lock.unlock();
        }
    }

    public void makeOrder(){
        orderSize = ThreadLocalRandom.current().nextInt(1, MAX_ORDER_SIZE);
        LOG.info("Client "+ name + " made order");
    }

    public void chooseCashDesk(){
        this.cashDesk = restaurant.getCashDeskList().get(ThreadLocalRandom.current().nextInt(restaurant.getCashDeskList().size()));
        cashDesk.addClient(this);
        LOG.info("Client " + name + " had chosen CashDesk#" + cashDesk.getNumber());
    }

    public boolean chooseAnotherCashDesk(){
        for(CashDesk desk:restaurant.getCashDeskList()){
            if(desk.getState().getClass()==FreeState.class){
                cashDesk = desk;
                desk.addClient(this);
                return true;
            }
        }
        return false;
    }

    public boolean madePreOrder() {
        int choose = ThreadLocalRandom.current().nextInt(10);
        if (choose==1) {
            LOG.info(getClientName()+ " made pre order");
            orderSize = ThreadLocalRandom.current().nextInt(MAX_ORDER_SIZE);
            return true;
        }
        return false;
    }

    public String getClientName() {
        return name;
    }
    public int getOrderSize() {
        return orderSize;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
}
