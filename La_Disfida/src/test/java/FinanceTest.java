import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/* Si ipotizza di conoscere solamente:
		1. Gli input ed i loro tipi
		2. Il tipo di output

   NOTA:
   si ipotizza di non conoscere la possibilità di poter
   ricevere in output una Eccezione.
   Tutti questi test sono stati scritti per valutare
   ogni singola combinazione delle variabili in input

   LEGENDA: G0 -> Greater Than 0,
 			 0 -> Equal to 0,
			L0 -> Less Than 0.

   In ogni chiamata del metodo "assertEquals()" i valori
   utilizzati per il parametro "expected" sono valori
   fantoccio, in quanto utilizzati solamente per conoscere
   il risultato della combinazione dei parametri di input
   del metodo testato "calculateLoanPayment()" della classe
   "Finance".

*/

class FinanceTest {
	static Finance finance;

	@BeforeAll
	static void init() {
		finance = new Finance();
	}

	@Test //1
	public void testInitialValues() {
		assertEquals(10, finance.calculateLoanPayment(500, 4, 6), 1e-2);
	}
    @Test //2
    public void test_PrincipalG0_annualRateG0_years0(){
        assertEquals(10, finance.calculateLoanPayment(500, 4, 0), 1e-2);
    }

	@Test //3
	public void test_PrincipalG0_annualRateG0_yearsL0(){
		assertEquals(10, finance.calculateLoanPayment(500, 4, -1), 1e-2);
	}

	@Test //4
	public void test_PrincipalG0_annualRate0_yearsG0(){
		assertEquals(10, finance.calculateLoanPayment(500, 0, 1), 1e-2);
	}

	@Test //5
	public void test_PrincipalG0_annualRate0_years0(){
		assertEquals(10, finance.calculateLoanPayment(500, 0, 0), 1e-2);
	}

	@Test //6
	public void test_PrincipalG0_annualRate0_yearsL0(){
		assertEquals(10, finance.calculateLoanPayment(500, 0, -1), 1e-2);
	}

	@Test //7
	public void test_PrincipalG0_annualRateL0_yearsG0(){
		assertEquals(10, finance.calculateLoanPayment(500, -1, 1), 1e-2);
	}

	@Test //8
	public void test_PrincipalG0_annualRateL0_years0(){
		assertEquals(10, finance.calculateLoanPayment(500, -1, -1), 1e-2);
	}

	@Test //9
	public void test_PrincipalG0_annualRateL0_yearsL0(){
		assertEquals(10, finance.calculateLoanPayment(500, -1, -1), 1e-2);
	}

	@Test //10
	public void test_Principal0_annualRateG0_yearsG0(){
		assertEquals(0, finance.calculateLoanPayment(0, 4, 6), 1e-2);
	}

	@Test //11
	public void test_Principal0_annualRateG0_years0(){
		assertEquals(0, finance.calculateLoanPayment(0, 4, 0), 1e-2);
	}

	@Test //12
	public void test_Principal0_annualRateG0_yearsL0(){
		assertEquals(0, finance.calculateLoanPayment(0, 4, -1), 1e-2);
	}

	@Test //13
	public void test_Principal0_annualRate0_yearsG0(){
		assertEquals(0, finance.calculateLoanPayment(0, 0, 6), 1e-2);
	}

	@Test //14
	public void test_Principal0_annualRate0_years0(){
		assertEquals(0, finance.calculateLoanPayment(0, 0, 0), 1e-2);
	}

	@Test //15
	public void test_Principal0_annualRate0_yearsL0(){
		assertEquals(0, finance.calculateLoanPayment(0, 0, -1), 1e-2);
	}

	@Test //16
	public void test_Principal0_annualRateL0_yearsG0(){
		assertEquals(0, finance.calculateLoanPayment(0, -1, 6), 1e-2);
	}

	@Test //17
	public void test_Principal0_annualRateL0_years0(){
		assertEquals(0, finance.calculateLoanPayment(0, -1, 0), 1e-2);
	}

	@Test //18
	public void test_Principal0_annualRateL0_yearsL0(){
		assertEquals(0, finance.calculateLoanPayment(0, -1, -1), 1e-2);
	}

	@Test //19
	public void test_PrincipalL0_annualRateG0_yearsG0(){
		assertEquals(0, finance.calculateLoanPayment(-1, 4, 6), 1e-2);
	}

	@Test //20
	public void test_PrincipalL0_annualRateG0_years0(){
		assertEquals(0, finance.calculateLoanPayment(-1, 4, 0), 1e-2);
	}

	@Test //21
	public void test_PrincipalL0_annualRateG0_yearsL0(){
		assertEquals(0, finance.calculateLoanPayment(-1, 4, -1), 1e-2);
	}

	@Test //22
	public void test_PrincipalL0_annualRate0_yearsG0(){
		assertEquals(0, finance.calculateLoanPayment(-1, 0, 6), 1e-2);
	}

	@Test //23
	public void test_PrincipalL0_annualRate0_years0(){
		assertEquals(0, finance.calculateLoanPayment(-1, 0, 0), 1e-2);
	}

	@Test //24
	public void test_PrincipalL0_annualRate0_yearsL0(){
		assertEquals(0, finance.calculateLoanPayment(-1, 0, -1), 1e-2);
	}

	@Test //25
	public void test_PrincipalL0_annualRateL0_yearsG0(){
		assertEquals(0, finance.calculateLoanPayment(-1, -1, 6), 1e-2);
	}

	@Test //26
	public void test_PrincipalL0_annualRateL0_years0(){
		assertEquals(0, finance.calculateLoanPayment(-1, -1, 0), 1e-2);
	}

	@Test //27
	public void test_PrincipalL0_annualRateL0_yearsL0(){
		assertEquals(0, finance.calculateLoanPayment(-1, -1, -1), 1e-2);
	}

	/*
	Dopo aver implementato i test necessari per capire le funzioni del codice (black box testing),
	abbiamo deciso di implementare anche alcuni test che necessitano della conoscenza
	del contenuto del metodo (white box testing).

	Abbiamo deciso di implementare i seguenti test:
	-Test con valori normali
	-Test con valori negativi
	-Test con valori uguali a 0
	-Test con valori piccolissimi
	-Test con valori altissimi
	 */


	@Test
	public void testNormalValues() {
		assertEquals(7.82, finance.calculateLoanPayment(500, 4, 6), 1e-2);
	}

	@Test
	public void testZeroPrincipal() {
		assertEquals(0, finance.calculateLoanPayment(0, 5, 10), 1e-2);
	}

	@Test
	public void testZeroAnnualRate() {
		assertEquals(41.67, finance.calculateLoanPayment(6000, 0, 12), 1e-2);
	}

	@Test
	public void testZeroYears() {
		assertThrows(IllegalArgumentException.class, () -> {
			finance.calculateLoanPayment(10000, 5, 0);
		});
	}

	@Test
	public void testNegativePrincipal() {
		assertThrows(IllegalArgumentException.class, () -> {
			finance.calculateLoanPayment(-50, 6, 5);
		});
	}

	@Test
	public void testNegativeAnnualRate() {
		assertThrows(IllegalArgumentException.class, () ->{
			finance.calculateLoanPayment(5000, -1, 13);
		});
	}

	@Test
	public void testNegativeYears() {
		assertThrows(IllegalArgumentException.class, () -> {
			finance.calculateLoanPayment(10000, 5, -3);
		});
	}

	@Test
	public void testLowPrincipal() {
		assertEquals(0.0002, finance.calculateLoanPayment(0.01, 2, 3), 1e-4);
	}

	@Test
	public void testLowAnnualRate() {
		assertEquals(0.16, finance.calculateLoanPayment(4, 0.3, 2), 1e-2);
	}

	@Test
	public void testVeryHighYears() {
		assertEquals(0.83, finance.calculateLoanPayment(500, 2, 500), 1e-2);
	}


	@Test
	public void testHighInterestRate() {
		assertEquals(1349.95, finance.calculateLoanPayment(10000, 100, 1), 1e-2);
	}

	@Test
	public void testZeroRateAndZeroYears() {
		assertThrows(IllegalArgumentException.class, () -> {
			finance.calculateLoanPayment(120000, 0, 0);
		});
	}

	@Test
	public void testZeroRateAndZeroPrincipal() {
		assertEquals(0, finance.calculateLoanPayment(0, 0, 100));
	}

	@Test
	public void testZeroYearAndZeroPrincipal() {
		assertThrows(IllegalArgumentException.class, () -> {
			finance.calculateLoanPayment(0, 6, 0);
		});
	}

	@Test
	public void testNegativePrincipalAndYears() {
		assertThrows(IllegalArgumentException.class,() ->{
			finance.calculateLoanPayment(-1, 6, -2);
		});
	}

	@Test
	public void testNegativePrincipalAndRate() {
		assertThrows(IllegalArgumentException.class,() ->{
			finance.calculateLoanPayment(-1, -2, 5);
		});
	}

	@Test
	public void testNegativeRateAndYears() {
		assertThrows(IllegalArgumentException.class,() ->{
			finance.calculateLoanPayment(8, -2, -4);
		});
	}

	@Test
	public void testAllZero() {
		assertThrows(IllegalArgumentException.class,()->{
			finance.calculateLoanPayment(0, 0, 0);
		});
	}

	@Test
	public void testAllNegative() {
		assertThrows(IllegalArgumentException.class,()->{
			finance.calculateLoanPayment(-1, -1, -1);
		});
	}
}
