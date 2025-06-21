import java.util.*;
public class Future_Val_Rec {

    public static double futureValue(double principal, double[] rates, int year) {
        if (year == 0) {
            return principal;
        }
        return futureValue(principal, rates, year - 1) * (1 + rates[year - 1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double principal = 0;
        int years = 0;

        while (true) {
            System.out.print("Enter the initial amount (principal): ");
            principal = scanner.nextDouble();
            if (principal > 0) break;
            System.out.println("Principal must be greater than 0.");
        }

        while (true) {
            System.out.print("Enter the number of years: ");
            years = scanner.nextInt();
            if (years > 0) break;
            System.out.println("Number of years must be greater than 0.");
        }
        double[] rates = new double[years];

        for (int i = 0; i < years; i++) {
            while (true) {
                System.out.print("Enter growth rate for year " + (i + 1) + " (in %): ");
                double rate = scanner.nextDouble();
                if (rate >= 0) {
                    rates[i] = rate / 100; 
                    break;
                } else {
                    System.out.println("Growth rate cannot be negative.");
                }
            }
        }
        double result = futureValue(principal, rates, years);

        System.out.printf("Future Value after %d years: %.2f%n", years, result);
        scanner.close();
    }
}
