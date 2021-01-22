package soloQ;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.rmi.UnexpectedException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import prvaGrupa.ComplexNumber;
import prvaGrupa.FunkcijeDrugiDeo;

@RunWith(Parameterized.class)
public class FunkcijeDrugiDeoTest {

	private ComplexNumber complexFirst;
	private ComplexNumber complexSecond;
	private int n;

	public FunkcijeDrugiDeoTest(ComplexNumber complexFirst, ComplexNumber complexSecond, int n) {
		this.complexFirst = complexFirst;
		this.complexSecond = complexSecond;
		this.n = n;
	}

	@After
	public void clear() {
		FunkcijeDrugiDeo.ComplexNumberList.clear();
	}

	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] { { new ComplexNumber(11.3, 4.6), new ComplexNumber(7.8, 2.3), 5 },
				{ new ComplexNumber(11.3, 4.6), new ComplexNumber(7.8, 2.3), 5 },
				{ new ComplexNumber(11.3, 4.6), new ComplexNumber(7.8, 2.3), 5 },
				{ new ComplexNumber(11.3, 4.6), new ComplexNumber(7.8, 2.3), 5 },
				{ new ComplexNumber(11.3, 4.6), new ComplexNumber(7.8, 2.3), 5 } });
	}

	@Test
	public void testSumComplexNumbers1() {
		LinkedList<ComplexNumber> expected = new LinkedList<ComplexNumber>();
		expected.add(new ComplexNumber(88.14, 2.0));
		expected.add(new ComplexNumber(88.14, 2.0));
		expected.add(new ComplexNumber(88.14, 2.0));
		expected.add(new ComplexNumber(88.14, 2.0));
		expected.add(new ComplexNumber(88.14, 2.0));
		expected.add(new ComplexNumber(130.34, 2.0));
		expected.add(new ComplexNumber(130.34, 2.0));
		expected.add(new ComplexNumber(130.34, 2.0));
		LinkedList<ComplexNumber> actual;
		try {
			actual = FunkcijeDrugiDeo.sumComplexNumbers(complexFirst, complexSecond, n);
			for (int i = 0; i < actual.size(); i++) {
				assertEquals(expected.get(i).getComplexNumberRealPart(), actual.get(i).getComplexNumberRealPart(),
						0.001);
				assertEquals(expected.get(i).getComplexNumberImgPart(), actual.get(i).getComplexNumberImgPart(), 0.001);
			}

		} catch (UnexpectedException e) {
			Assume.assumeNoException(e);
		}
	}

	@Test
	public void testSumComplexNumbers2() {
		ComplexNumber complexFirst = new ComplexNumber(2.13, 1.15);
		ComplexNumber complexSecond = new ComplexNumber(5.62, 3.35);
		int n = 5;
		try {
			FunkcijeDrugiDeo.sumComplexNumbers(complexFirst, complexSecond, n);
		} catch (UnexpectedException e) {
			Assume.assumeNoException(e);
		}
	}
	
	@Test
	public void testFunkcijeDrugiDeo() {
		FunkcijeDrugiDeo fdd = new FunkcijeDrugiDeo();
		assertNotNull(fdd);
	}
}
