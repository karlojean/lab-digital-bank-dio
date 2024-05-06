import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Account implements IAccount {
    private int agency;
    private int number;
    private Customer customer;
    private double balance;
    private List<Movimentation> movimentations;

    public Account(int agency, int number, Customer customer) {
        this.agency = agency;
        this.number = number;
        this.customer = customer;
        this.balance = 0;
        this.movimentations = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return number == account.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toWithdraw(double value) {
        if(value <= balance) {
            balance -= value;
            movimentations.add(new Movimentation(Type.EXIT, value, LocalDate.now()));
            return "Concluido com sucesso";
        }

        return "Saldo Insuficiente";
    }

    @Override
    public String deposit(double value) {
        balance  += value;
        movimentations.add(new Movimentation(Type.ENTRY, value, LocalDate.now()));
        return "Deposito Realizado com sucesso";
    }

    @Override
    public String transfer(Account account, double value) {
        if(value <= balance) {
            this.toWithdraw(value);
            movimentations.add(new Movimentation(Type.EXIT, value, LocalDate.now()));
            account.deposit(value);
            return "Tranferencia realizada com sucesso";
        }

        return "Saldo Insuficiente";
    }

    @Override
    public void printExtract() {

    }

    public double getBalance() {
        return balance;
    }

    public List<Movimentation> getMovimentations() {
        return movimentations;
    }
}
