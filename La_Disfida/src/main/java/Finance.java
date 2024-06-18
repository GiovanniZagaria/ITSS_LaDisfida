public class Finance {
    public double calculateLoanPayment(double principal, double annualRate, int years) {
        if (principal < 0 || annualRate < 0 || years < 1) {
            throw new IllegalArgumentException("Negative values are not allowed.");
        }

        double monthlyRate = annualRate / 100 / 12;
        int numPayments = years * 12;

        if (numPayments == 0) {
            throw new IllegalArgumentException("Loan duration cannot be zero.");
        }

        if (monthlyRate == 0) {
            return principal / numPayments;
        }

        double payment = principal * (monthlyRate * Math.pow(1 + monthlyRate, numPayments)) /
                (Math.pow(1 + monthlyRate, numPayments) - 1);

        return payment;
    }
}

