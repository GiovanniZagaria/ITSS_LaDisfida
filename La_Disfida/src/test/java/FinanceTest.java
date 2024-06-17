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

}
