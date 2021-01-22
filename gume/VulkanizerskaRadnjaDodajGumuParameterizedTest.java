package tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import gume.AutoGuma;
import gume.VulkanizerskaRadnja;

@RunWith(Parameterized.class)
public class VulkanizerskaRadnjaDodajGumuParameterizedTest {

	private VulkanizerskaRadnja VR;
	private AutoGuma AG;
	
	public VulkanizerskaRadnjaDodajGumuParameterizedTest(AutoGuma AG) {
		this.AG = AG;
	}

	@Rule
	public final TestRule classTimeout = Timeout.seconds(5);
	
//	@BeforeClass
//	public void proveriOS() {
//		Assume.assumeTrue(System.getProperty("os.main").contains("Windows"));
//	}
	
	@Parameters
	public static Collection<Object[]> gume(){
		return Arrays.asList(new Object[][]{
			{new AutoGuma("Michelin", false, 12, 15, 17)},
			{new AutoGuma("Pirelli", true, 12, 15, 17)},
			{new AutoGuma("Michelin", true, 12, 15, 17)},
			{new AutoGuma("Pirelli", false, 12, 15, 17)}
		});
	}
	
	@Before
	public void init() {
		VR = new VulkanizerskaRadnja();
	}
	
	@Test(expected = NullPointerException.class)
	public void dodajGumu1() {
		AG = null;
		VR.dodajGumu(AG);
	}
	
	@Test(expected = RuntimeException.class)
	public void dodajGumu2() {
		VR.dodajGumu(AG);
		VR.dodajGumu(AG);
	}
	
	@Test
	public void dodajGumu3() {
		VR.dodajGumu(AG);
		assertTrue(VR.gume.contains(AG));
	}

	
	@After
	public void destroy() {
		VR = null;
	}
}
