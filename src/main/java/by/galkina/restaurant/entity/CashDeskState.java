package by.galkina.restaurant.entity;


public interface CashDeskState {
    void close(CashDesk cashDesk);
    void free(CashDesk cashDesk);
    void busy(CashDesk cashDesk);
}
