import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Random;

/*

   Si ipotizza di conoscere solamente:
		1. Gli input ed i loro tipi
		2. Il tipo di output

   NOTA:
   si ipotizza di non conoscere la possibilità di poter
   ricevere in output una Eccezione.
   Tutti questi test sono stati scritti per valutare
   ogni singola combinazione delle variabili in input

   LEGENDA:  N -> Null,
		     E -> Empty,
	    	 1 -> Array with length 1,
	    	AL -> Array Length Value - 1 or above,
	    	IN -> Value IN array,
	   	   NIN -> Value Not IN array,
	  	  NORD -> Array Not ORDered, l'array ha obbligatoriamente length > 1,
	   	   ORD -> Array ORDered, l'array ha obbligatoriamente length > 1.

   Nel nome del test, se non è presente nessuna dicitura soprastante, allora
   si può inserire qualsiasi valore si voglia.

   In ogni chiamata del metodo "assertEquals()" i valori
   utilizzati per il parametro "expected" sono valori
   fantoccio, in quanto utilizzati solamente per conoscere
   il risultato della combinazione dei parametri di input
   del metodo testato "binarySearchInRange()" della classe
   "Search".

*/

class SearchTest {
	static Search search;

	@BeforeAll
	static void init(){
		search = new Search();
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


}



