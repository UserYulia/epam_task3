package by.galkina.freecashier.entity;


public class BusyState implements State {
    @Override
    public void close(CashDesk cashDesk) {

    }

    @Override
    public void free(CashDesk cashDesk) {
        if(cashDesk.getClients().isEmpty()){
            cashDesk.setState(new FreeState());
        }
    }

    @Override
    public void busy(CashDesk cashDesk) {

    }
}