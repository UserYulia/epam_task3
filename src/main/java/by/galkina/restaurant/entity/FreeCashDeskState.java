package by.galkina.restaurant.entity;


public class FreeCashDeskState implements CashDeskState {
    @Override
    public void close(CashDesk cashDesk) {

    }

    @Override
    public void free(CashDesk cashDesk) {

    }

    @Override
    public void busy(CashDesk cashDesk) {
        if(!cashDesk.getClients().isEmpty()){
            cashDesk.setState(new BusyCashDeskState());
        }
    }
}
