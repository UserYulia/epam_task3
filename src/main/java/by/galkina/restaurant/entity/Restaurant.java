package by.galkina.restaurant.entity;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant {
    private static final Logger LOG = Logger.getLogger(Restaurant.class);
    private List<CashDesk> cashDeskList = new ArrayList<>();
    private static AtomicBoolean flag = new AtomicBoolean();
    private static Restaurant instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    private Restaurant() {
    }

    public static Restaurant getInstance() {
        if (!flag.get()) {
            lock.lock();
            instance = new Restaurant();
            flag.set(true);
            lock.unlock();
            LOG.info("Restaurant was created.");
        }
        return instance;
    }


    public void createCashDesk(int id, int time) {
        CashDesk cashDesk = new CashDesk(id, time);
        cashDeskList.add(cashDesk);
        LOG.info("CashDesk "+cashDesk+" was added.");
    }

    public List<CashDesk> getCashDeskList() {
        return cashDeskList;
    }
}

