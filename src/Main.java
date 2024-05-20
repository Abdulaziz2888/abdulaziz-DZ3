public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);
        System.out.println("На счету: " + account.getAmount() + " сом");

        while (true) {
            try {
                account.withDraw(6000);
                System.out.println("Снято 6000 сом. Остаток: " + account.getAmount() + " сом");
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                System.out.println("Снимаю оставшуюся сумму: " + e.getRemainingAmount() + " сом");
                try {
                    account.withDraw((int) e.getRemainingAmount());
                } catch (LimitException ex) {
                    // Этот блок не будет выполнен, так как мы снимаем оставшуюся сумму
                }
                break;
            }
        }
        System.out.println("Конечный остаток на счете: " + account.getAmount() + " сом");
    }
}
