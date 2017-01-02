package by.galkina.freecashier.entity;


public class ClosedState implements State {
    State nextState;
    @Override
    public void close(CashDesk cashDesk) {

    }

    @Override
    public void free(CashDesk cashDesk) {
        if(Restaurant.getInstance()!=null){
            cashDesk.setState(new FreeState());
        }
    }

    @Override
    public void busy(CashDesk cashDesk) {

    }
}