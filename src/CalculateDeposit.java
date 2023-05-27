import java.util.Scanner;

public class CalculateDeposit {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return result(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return result(amount + amount * yearRate * depositPeriod, 2);
    }

    double result(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateFinalyDeposit() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double finalyDeposite = 0;
        if (action == 1) finalyDeposite = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2) {
            finalyDeposite = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + finalyDeposite);
    }

    public static void main(String[] args) {
        new CalculateDeposit().calculateFinalyDeposit();
    }


}
