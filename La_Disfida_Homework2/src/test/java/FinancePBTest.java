import net.jqwik.api.*;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;
import org.junit.jupiter.api.Assertions;

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

    @Property
    void testInvalidFinance(@ForAll("invalidPrincipal") double principal,
                 @ForAll("invalidAnnualRate") double annualRate,
                 @ForAll("invalidYears") int years){
        assertThrows(IllegalArgumentException.class, () -> finance.calculateLoanPayment(principal, annualRate, years));
    }

    @Property
    @StatisticsReport
    void testStatisticInvalidPrincipal(@ForAll("invalidPrincipal") double principal,
                                       @ForAll("passAnnualRate") double annualRate,
                                       @ForAll("passYears") int years){
        Statistics.collect(principal);
        Assertions.assertThrows(IllegalArgumentException.class, () -> finance.calculateLoanPayment(principal, annualRate, years));

    }
    @Property
    @StatisticsReport
    void testStatisticInvalidAnnualRate(@ForAll("passPrincipal") double principal,
                                        @ForAll("invalidAnnualRate") double annualRate,
                                        @ForAll("passYears") int years){
        Statistics.collect(annualRate);
        Assertions.assertThrows(IllegalArgumentException.class, () -> finance.calculateLoanPayment(principal, annualRate, years));
    }

    @Property
    @StatisticsReport
    void testStatisticsInvalidYears(
            @ForAll("passPrincipal") double principal,
            @ForAll("passAnnualRate") double annualRate,
            @ForAll("invalidYears") int years){
        Statistics.collect(years);
        Assertions.assertThrows(IllegalArgumentException.class, () -> finance.calculateLoanPayment(principal, annualRate, years));
    }

    @Provide
    Arbitrary<Double> invalidPrincipal(){
        return Arbitraries.oneOf(Arbitraries.doubles().lessThan(0f));
    }

    @Provide
    Arbitrary<Double> invalidAnnualRate(){
        return Arbitraries.oneOf(Arbitraries.doubles().lessThan(0f));
    }

    @Provide
    Arbitrary<Integer> invalidYears(){
        return Arbitraries.oneOf(Arbitraries.integers().lessOrEqual(-1));
    }

    @Provide
    Arbitrary<Double> passPrincipal(){
        return Arbitraries.oneOf(Arbitraries.doubles().greaterOrEqual(0.01),
                                Arbitraries.doubles().lessOrEqual(1000000));
    }

    @Provide
    Arbitrary<Double> passAnnualRate(){
        return Arbitraries.oneOf(Arbitraries.doubles().greaterOrEqual(0.01),
                                Arbitraries.doubles().lessOrEqual(100));
    }

    @Provide
    Arbitrary<Integer> passYears(){
        return Arbitraries.oneOf(Arbitraries.integers().greaterOrEqual(1),
                Arbitraries.integers().lessOrEqual(50));
    }


}

