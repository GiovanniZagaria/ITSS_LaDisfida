import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Random;

class SearchTest {
	static Search search;
	int[] emptyArray = {};
	int[] notORDArray = {1, 2, 5, 4, 3};
	int[] ORDArray = {1, 2, 3, 4, 5};
	int[] ORDArrayBig = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 22, 23};
	int[] singleElementArray = {1};

	@BeforeAll
	static void init(){
		search = new Search();

	}

	//BLACKBOX TESTING
	@Test
	//TEST CASI ECCEZIONALI:
	public void testExceptionalCases() {
		assertThrows(IllegalArgumentException.class, () -> search.binarySearchInRange(null, 3, 0, 4));
		assertThrows(IllegalArgumentException.class, () -> search.binarySearchInRange(emptyArray, 3, 0, 4));
		assertThrows(IllegalArgumentException.class, () -> search.binarySearchInRange(notORDArray, 3, 0, 4));
		assertThrows(IllegalArgumentException.class, () -> search.binarySearchInRange(ORDArray, 3, 3, 1));
		assertThrows(IllegalArgumentException.class, () -> search.binarySearchInRange(ORDArray, 3, -1, 3));
		assertThrows(IllegalArgumentException.class, () -> search.binarySearchInRange(ORDArray, 3, 1, ORDArray.length));
	}

	@Test
	public void testArray1(){
		assertTrue(() -> search.binarySearchInRange(singleElementArray, 1, 0, 0));
		assertFalse(() -> search.binarySearchInRange(singleElementArray, 3, 0, 0));
	}

	@Test
	public void testArrayG1(){
		assertTrue(() -> search.binarySearchInRange(ORDArray, 3, 2, 3));
		assertTrue(() -> search.binarySearchInRange(ORDArray, 3, 1, 2));
		assertFalse(() -> search.binarySearchInRange(ORDArray, 9, 1, 3));
	}

	@Test
	public void testBoundaries(){
		assertTrue(() -> search.binarySearchInRange(ORDArray, 3, 2, 2));
		assertTrue(() -> search.binarySearchInRange(ORDArray, 2, 1, 4));
		assertTrue(() -> search.binarySearchInRange(ORDArray, 4, 0, 4));
	}

	@Test
	public void testValuePresentInMiddle() {
		int[] array = {1, 2, 3, 4, 5};
		assertTrue(search.binarySearchInRange(array, 3, 0, 4));
	}

	@Test
	public void testValuePresentAtStart() {
		int[] array = {1, 2, 3, 4, 5};
		assertTrue(search.binarySearchInRange(array, 1, 0, 4));
	}

	@Test
	public void testValuePresentAtEnd() {
		int[] array = {1, 2, 3, 4, 5};
		assertTrue(search.binarySearchInRange(array, 5, 0, 4));
	}

	@Test
	public void testValueNotPresent() {
		int[] array = {1, 2, 3, 4, 5};
		assertFalse(search.binarySearchInRange(array, 6, 0, 4));
	}

	@Test
	public void testEmptyArray() {
		int[] array = {};
		assertThrows(IllegalArgumentException.class, () -> {
			search.binarySearchInRange(array, 1, 0, 0);
		});
	}

	@Test
	public void testSingleElementArrayValuePresent() {
		int[] array = {1};
		assertTrue(search.binarySearchInRange(array, 1, 0, 0));
	}

	@Test
	public void testSingleElementNotFound(){
		int[] array = {1};
		assertThrows(IllegalArgumentException.class, () -> {
			search.binarySearchInRange(array, 2, 0, 1);
		});
	}
/*
	@Test
	public void testPointedValueInArray(){
		double[] array = {1.5};
		assertThrows(IllegalArgumentException.class, () -> {
			search.binarySearchInRange(array, 1.5, 0, 1);
		});
	}
*/
	@Test
	public void NullValueInArray(){
		int[] array = null;
		assertThrows(IllegalArgumentException.class,() -> {
			search.binarySearchInRange(array, 1, 0, 1);
		});

	}

	@Test
	public void testNullArray() {
		assertThrows(IllegalArgumentException.class, () -> {
			search.binarySearchInRange(null, 1, 0, 0);
		});
	}

	@Test
	public void testLeftGreaterThanRight() {
		int[] array = {1, 2, 3, 4, 5};
		assertThrows(IllegalArgumentException.class, () -> {
			search.binarySearchInRange(array, 1, 3, 2);
		});
	}

	@Test
	public void testLeftOutOfBound() {
		int[] array = {1, 2, 3, 4, 5};
		assertThrows(IllegalArgumentException.class, () -> {
			search.binarySearchInRange(array, 1, -1, 4);
		});
	}

	@Test
	public void testRightOutOfBound() {
		int[] array = {1, 2, 3, 4, 5};
		assertThrows(IllegalArgumentException.class, () -> {
			search.binarySearchInRange(array, 1, 0, 5);
		});
	}

	@Test
	public void testAssertFalse() {
		Search search = new Search();
		int[] array = {1, 2, 3, 4, 5};
		assertFalse(search.binarySearchInRange(array, 4, 0, 2));
	}

	@Test
	public void testArrayNotSortedInRange() {
		int[] array = {1, 3, 2, 4, 5};
		assertThrows(IllegalArgumentException.class, () -> {
			search.binarySearchInRange(array, 3, 0, 4);
		});
	}

	@Test
	public void testOddValueInArrayOfEvenValues() {
		int n = 10; // numero di elementi nell'array
		int[] numeriPari = new int[n];

		for (int i = 0; i < n; i++) {
			numeriPari[i] = i * 2;
		}

		Random random = new Random();
		boolean exit = false;
		int numeroDispariCasuale = 0;
		while (!exit) {
			// Genera un numero intero casuale
			int numeroCasuale = random.nextInt();

			// Assicura che il numero sia dispari
			if (numeroCasuale % 2 != 0) {
				numeroDispariCasuale = numeroCasuale;
				exit = true;
			}
		}
		assertFalse(search.binarySearchInRange(numeriPari, numeroDispariCasuale, 0, n - 1));
	}

	@Test
	public void testArrayG1_ORDArrayBig(){
		assertTrue(() -> search.binarySearchInRange(ORDArray, 2, 0, 4));
	}


}



