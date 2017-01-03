package by.galkina.restaurant.entity;


public class BusyCashDeskState implements CashDeskState {
    @Override
    public void close(CashDesk cashDesk) {

    }

    @Override
    public void free(CashDesk cashDesk) {
        if(cashDesk.getClients().isEmpty()){
            cashDesk.setState(new FreeCashDeskState());
        }
    }

    @Override
    public void busy(CashDesk cashDesk) {

    }
}