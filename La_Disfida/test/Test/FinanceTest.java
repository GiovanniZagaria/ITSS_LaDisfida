package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FinanceTest {
	Finance finance;

	@BeforeEach
	void init() {
		finance = new Finance();
	}
	
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
    public void testLowYears() {
    	assertEquals(83.82, finance.calculateLoanPayment(500, 2, 0.5), 1e-2);
    }
    
    @Test
    public void testveryLowYears() {
    	assertThrows(IllegalArgumentException.class,() ->{
    		finance.calculateLoanPayment(3000, 7, 0.001);
    	});
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
