package by.galkina.freecashier.entity;


public class FreeState implements State {
    @Override
    public void close(CashDesk cashDesk) {

    }

    @Override
    public void free(CashDesk cashDesk) {

    }

    @Override
    public void busy(CashDesk cashDesk) {
        if(!cashDesk.getClients().isEmpty()){
            cashDesk.setState(new BusyState());
        }
    }
}
