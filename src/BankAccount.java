public class BankAccount {
    private double amount;

    public BankAccount() {
        this.amount = 0;
    }

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        if (sum > 0) {
            amount += sum;
        } else {
            System.out.println("Сумма должна быть положительной.");
        }
    }

    public void withDraw(int sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Запрашиваемая сумма больше, чем остаток на счете", amount);
        } else {
            amount -= sum;
        }
    }
}
