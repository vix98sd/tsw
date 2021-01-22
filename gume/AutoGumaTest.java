package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assume;
import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import gume.AutoGuma;

public class AutoGumaTest {

	
	private AutoGuma autoGuma;
	
	@Rule
	public final TestRule classTimeout = Timeout.seconds(5);
	
//	@BeforeClass
//	public static void proveriOS() {
//		Assume.assumeTrue(System.getProperty("os.main").contains("Windows"));
//	}
	
	@Rule
	public final TestName name = new TestName();	
	
	@Before
	public void init() {
		autoGuma = new AutoGuma("Michelin", true, 18, 180, 60);
	}

	@Test
	public void testGetZimska() {
		assertEquals(true, autoGuma.getZimska());
	}

	@Rule
	public final ErrorCollector ec = new ErrorCollector(); // Koristiti gde imamo 1 ili vise assert equals
	
	@Test
	public void testSetZimska() {
		
		///////////////////////////
		assertEquals("testSetZimska", name.getMethodName());
		///////////////////////////
		assertEquals(true, autoGuma.getZimska());
		autoGuma.setZimska(false);
		assertEquals(false, autoGuma.getZimska());
	}

	@Test
	public void testGetMarkaModel() {
		assertEquals("Michelin", autoGuma.getMarkaModel());
	}

	@Test
	public void testSetMarkaModel1() {
		assertEquals("Michelin", autoGuma.getMarkaModel());
		autoGuma.setMarkaModel("Michelin2");
		assertEquals("Michelin2", autoGuma.getMarkaModel());
	}

	@Test(expected = RuntimeException.class)
	public void testSetMarkaModel2() {
		assertEquals("Michelin", autoGuma.getMarkaModel());
		autoGuma.setMarkaModel("M");
	}

	@Test(expected = RuntimeException.class)
	public void testSetMarkaModel3() {
		assertEquals("Michelin", autoGuma.getMarkaModel());
		autoGuma.setMarkaModel(null);
	}

	@Test
	public void testGetPrecnik() {
		assertEquals(18, autoGuma.getPrecnik());
	}

	@Test(expected = RuntimeException.class)
	public void testSetPrecnik1() {
		autoGuma.setPrecnik(24);
	}

	@Test(expected = RuntimeException.class)
	public void testSetPrecnik2() {
		autoGuma.setPrecnik(10);
	}

	@Test
	public void testSetPrecnik3() {
		assertEquals(18, autoGuma.getPrecnik());
		autoGuma.setPrecnik(18);
		assertEquals(18, autoGuma.getPrecnik());
	}

	@Test
	public void testGetSirina() {
		assertEquals(180, autoGuma.getSirina());
	}

	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testSetSirina1() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("Sirina van opsega");
		autoGuma.setSirina(120);
	}
	
	@Test
	public void testSetSirina2() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("Sirina van opsega");
		autoGuma.setSirina(366);
	}
	
	@Test
	public void testSetSirina3() {
		assertEquals(180, autoGuma.getSirina());
		autoGuma.setSirina(155);
		assertEquals(155, autoGuma.getSirina());
	}

	@Test
	public void testGetVisina() {
		assertEquals(60, autoGuma.getVisina());
	}

	@Test(expected = RuntimeException.class)
	public void testSetVisina1() {
//		try {
			autoGuma.setVisina(15);			
//		}catch(Throwable t) {
//			Assume.assumeNoException(t);			
//		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetVisina2() {
//		try {
			autoGuma.setVisina(115);			
//		}catch(Throwable t) {
//			Assume.assumeNoException(t);			
//		}
	}
	
	@Test
	public void testSetVisina3() {
		assertEquals(60, autoGuma.getVisina());
		autoGuma.setVisina(70);
		assertEquals(70, autoGuma.getVisina());
	}

	@Test
	public void testIzracunajCenu() {
		assertEquals(((autoGuma.getPrecnik() *3 + autoGuma.getSirina() + autoGuma.getVisina()) * 28.53), autoGuma.izracunajCenu(), 0.0001);
	}

	@Test
	public void testPovoljnaGuma1() {
		autoGuma.setPrecnik(22);
		autoGuma.setSirina(355);
		autoGuma.setVisina(95);
		
		assertEquals(false, autoGuma.povoljnaGuma());
	}

	@Test
	public void testPovoljnaGuma2() {
		autoGuma.setPrecnik(13);
		autoGuma.setSirina(135);
		autoGuma.setVisina(25);
		
		assertEquals(true, autoGuma.povoljnaGuma());
	}

	@Test
	public void testToString() {
		String s = "AutoGuma [markaModel=" + autoGuma.getMarkaModel() + ", precnik=" + autoGuma.getPrecnik() + ", sirina=" + autoGuma.getSirina() + ", visina="+ autoGuma.getVisina() + "]";
		assertEquals(s, autoGuma.toString());
	}

	@Test
	public void testEqualsObject1() {
		assertEquals(true, autoGuma.equals(autoGuma));
	}
	
	@Test
	public void testEqualsObject2() {
		String s = "Some string";
		assertEquals(false, autoGuma.equals(s));
	}

	@Test
	public void testEqualsObject4() {
		AutoGuma testGuma = new AutoGuma(null, true, 18, 180, 60);
		assertEquals(false, testGuma.equals(autoGuma));
	}
	
	@Test
	public void testEqualsObject5() {
		AutoGuma testGuma = new AutoGuma(null, true, 18, 180, 60);
		AutoGuma testGuma2 = new AutoGuma(null, true, 18, 180, 60);
		assertEquals(true, testGuma.equals(testGuma2));
	}
	
	@Test
	public void testEqualsObject6() {
		AutoGuma testGuma = new AutoGuma("Michelin2", true, 18, 180, 60);
		assertEquals(false, autoGuma.equals(testGuma));
	}
	
	@Test
	public void testEqualsObject7() {
		AutoGuma testGuma = new AutoGuma("Michelin", true, 15, 180, 60);
		assertEquals(false, autoGuma.equals(testGuma));
	}

	@Test
	public void testEqualsObject8() {
		AutoGuma testGuma = new AutoGuma("Michelin", true, 18, 181, 60);
		assertEquals(false, autoGuma.equals(testGuma));
	}

	@Test
	public void testEqualsObject9() {
		AutoGuma testGuma = new AutoGuma("Michelin", true, 18, 180, 61);
		assertEquals(false, autoGuma.equals(testGuma));
	}

}
