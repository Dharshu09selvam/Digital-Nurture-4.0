public class FinancialForecast {

    public static double calculateFutureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 10000; 
        double rate = 0.08;
        int years = 5;

        double futureValue = calculateFutureValue(presentValue, rate, years);
        System.out.printf("Future Value after %d years: ₹%.2f\n", years, futureValue);
    }
}
