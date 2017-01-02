package by.galkina.freecashier.entity;


public interface State {
    void close(CashDesk cashDesk);
    void free(CashDesk cashDesk);
    void busy(CashDesk cashDesk);
}
