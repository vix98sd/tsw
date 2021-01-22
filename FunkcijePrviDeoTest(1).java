package soloQ;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import prvaGrupa.ComplexNumber;
import prvaGrupa.FunkcijePrviDeo;

public class FunkcijePrviDeoTest {

	@Rule
	public TestRule timeout = Timeout.millis(500);
	
	@Rule
	public TestName testName = new TestName();
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void checkOS() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}

	@Test
	public void testDecimaltoOctal1() {
		assertEquals("testDecimaltoOctal1", testName.getMethodName());
		int expected = 50;
		int actual = FunkcijePrviDeo.decimaltoOctal(40);
		assertEquals(expected, actual);
	}

	@Test(expected = NumberFormatException.class) // anotacija
	public void testDecimaltoOctal2() {
		assertEquals("testDecimaltoOctal2", testName.getMethodName());
		FunkcijePrviDeo.decimaltoOctal(999999999);
	}

	@Test
	public void testDecimaltoOctal3() {
		assertEquals("testDecimaltoOctal3", testName.getMethodName());
		try {
			FunkcijePrviDeo.decimaltoOctal(0);
		} catch (Throwable e) {
			Assume.assumeNoException(e); // dinamicko preskakanje
		}
	}

	@Test
	public void testSumComplexNumbers1() {
		assertEquals("testSumComplexNumbers1", testName.getMethodName());
		ComplexNumber expected = new ComplexNumber(77.95, 56.3);
		ComplexNumber actual = FunkcijePrviDeo.sumComplexNumbers(43.44, 23.2, 34.51, 33.1);
		assertEquals(expected.getComplexNumberRealPart(), actual.getComplexNumberRealPart(), 0.001);
		assertEquals(expected.getComplexNumberImgPart(), actual.getComplexNumberImgPart(), 0.001);
	}
	
	@Test
	public void testSumComplexNumbers2() {
		assertEquals("testSumComplexNumbers2", testName.getMethodName());
		exception.expect(ExceptionInInitializerError.class);
		ComplexNumber expected = new ComplexNumber(4, 26);
		ComplexNumber actual = FunkcijePrviDeo.sumComplexNumbers(43.44, 23.2, 34.51, 33.1);
		assertEquals(expected.getComplexNumberRealPart(), actual.getComplexNumberRealPart(), 0.001);
		assertEquals(expected.getComplexNumberImgPart(), actual.getComplexNumberImgPart(), 0.001);
	}

	@Test
	public void testSumComplexNumbers3() {
		assertEquals("testSumComplexNumbers3", testName.getMethodName());
		exception.expect(ArithmeticException.class); // pravilo
		FunkcijePrviDeo.sumComplexNumbers(450.44, 23.2, 550.51, 33.1);
	}
	
	@Test
	public void testEvenNumbers() {
		assertEquals("testEvenNumbers", testName.getMethodName());
		Integer[] expected = {2, 4, 6};
		Integer[] actual = FunkcijePrviDeo.evenNumbers(6);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testFunkcijePrviDeoInit() {
		assertEquals("testFunkcijePrviDeoInit", testName.getMethodName());
		FunkcijePrviDeo fpd = new FunkcijePrviDeo();
		assertNotNull(fpd);
	}
}