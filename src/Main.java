//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("Banco Joaozinho");

        Account account1 = new Account(122, 11111, new Customer("Jean"));
        Account account2 = new Account(111, 9886, new Customer("John"));
        Account account3 = new Account(122, 11111, new Customer("Petter"));

        bank.setAccounts(account1);
        bank.setAccounts(account2);
        bank.setAccounts(account3);

        account1.deposit(100);
        account1.deposit(200);
        account1.deposit(1001);
        account1.toWithdraw(1000);
        System.out.println(account1.getBalance());
        System.out.println(account1.getMovimentations());
    }
}