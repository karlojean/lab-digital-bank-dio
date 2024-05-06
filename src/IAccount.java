public interface IAccount {
    String toWithdraw(double value);
    String deposit(double value);
    String transfer(Account account, double value);
    void printExtract();
}
