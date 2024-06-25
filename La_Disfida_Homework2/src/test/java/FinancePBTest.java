import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.*;

class FinancePBTest {
    private final Finance finance = new Finance();

    @Property
    public void testCalculateLoanPaymentPositiveValues(@ForAll @DoubleRange(min = 0.01, max = 1000000) double principal,
                                                       @ForAll @DoubleRange(min = 0.01, max = 100) double annualRate,
                                                       @ForAll @IntRange(min = 1, max = 50) int years) {
        assertTrue(finance.calculateLoanPayment(principal, annualRate, years) > 0, "The payment should be greater than 0");
    }

    @Property
    public void testCalculateLoanPaymentZeroRate(@ForAll @DoubleRange(min = 0.01, max = 1000000) double principal,
                                                 @ForAll @IntRange(min = 1, max = 50) int years) {
        double payment = finance.calculateLoanPayment(principal, 0, years);
        assertEquals(principal / (years * 12), payment, 1e-10, "Payment should be equal to principal divided by number of payments when rate is 0");
    }

    @Property
    public void testCalculateLoanPaymentThrowsExceptionForNegativePrincipal(@ForAll @DoubleRange(min = -1000000, max = -0.01) double principal,
                                                                            @ForAll @DoubleRange(min = 0.01, max = 100) double annualRate,
                                                                            @ForAll @IntRange(min = 1, max = 50) int years) {
        assertThrows(IllegalArgumentException.class, () -> finance.calculateLoanPayment(principal, annualRate, years));
    }

    @Property
    public void testCalculateLoanPaymentThrowsExceptionForNegativeRate(@ForAll @DoubleRange(min = 0.01, max = 1000000) double principal,
                                                                       @ForAll @DoubleRange(min = -100, max = -0.01) double annualRate,
                                                                       @ForAll @IntRange(min = 1, max = 50) int years) {
        assertThrows(IllegalArgumentException.class, () -> finance.calculateLoanPayment(principal, annualRate, years));
    }

    @Property
    public void testCalculateLoanPaymentThrowsExceptionForZeroYears(@ForAll @DoubleRange(min = 0.01, max = 1000000) double principal,
                                                                    @ForAll @DoubleRange(min = 0.01, max = 100) double annualRate) {
        assertThrows(IllegalArgumentException.class, () -> finance.calculateLoanPayment(principal, annualRate, 0));
    }

    @Property
    public void testCalculateLoanPaymentThrowsExceptionForNegativeYears(@ForAll @DoubleRange (min = 0.01, max = 1000000) double principal,
                                                                        @ForAll @DoubleRange(min = 0.01, max = 100) double annualRate,
                                                                        @ForAll @IntRange(min = -50, max = -1) int years) {
        assertThrows(IllegalArgumentException.class, () -> finance.calculateLoanPayment(principal, annualRate, years));
    }
}

