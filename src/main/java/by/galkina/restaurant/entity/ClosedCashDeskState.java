package by.galkina.restaurant.entity;


public class ClosedCashDeskState implements CashDeskState {
    CashDeskState nextCashDeskState;
    @Override
    public void close(CashDesk cashDesk) {

    }

    @Override
    public void free(CashDesk cashDesk) {
        if(Restaurant.getInstance()!=null){
            cashDesk.setState(new FreeCashDeskState());
        }
    }

    @Override
    public void busy(CashDesk cashDesk) {

    }
}