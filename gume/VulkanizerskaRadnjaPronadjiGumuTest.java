package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Before;
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
public class VulkanizerskaRadnjaPronadjiGumuTest {

	private VulkanizerskaRadnja VR;
	private AutoGuma AG;
	private LinkedList<AutoGuma> expectedAG;
	
	public VulkanizerskaRadnjaPronadjiGumuTest(AutoGuma AG, VulkanizerskaRadnja VR, LinkedList<AutoGuma> expectedAG) {
		this.AG = AG;
		this.VR = VR;
		
	}

	@Rule
	public final TestRule classTimeout = Timeout.seconds(5);
	
//	@BeforeClass
//	public void proveriOS() {
//		Assume.assumeTrue(System.getProperty("os.main").contains("Windows"));
//	}
	
	@Parameters
	public static Collection<Object[]> gume(){
		VulkanizerskaRadnja VR = new VulkanizerskaRadnja();
		
		VR.dodajGumu(new AutoGuma("Guma1", false, 12, 15, 17));
		VR.dodajGumu(new AutoGuma("Guma2", true, 12, 15, 17));
		VR.dodajGumu(new AutoGuma("Guma3", true, 12, 19, 17));
		VR.dodajGumu(new AutoGuma("Guma1", false, 12, 15, 13));
		
		return Arrays.asList(new Object[][]{
			{new AutoGuma("Guma4", false, 12, 15, 17),
			 VR,
			 null},
			{new AutoGuma("Guma2", true, 12, 15, 17),
			 VR,
			 null},
			{new AutoGuma("Guma4", true, 12, 15, 17),
			 VR,
			 null},
			{new AutoGuma("Guma4", false, 12, 15, 17),
			 VR,
			 null}
		});
	}

	@Test
	public void pronadjiGumu1() {
		assertEquals(null, VR.pronadjiGumu(null));
	}
	
	@Test(expected = NullPointerException.class)
	public void pronadjiGumu2() {
		LinkedList<AutoGuma> realAG = new LinkedList<AutoGuma>();
		

		
		for(int i = 0; i < VR.gume.size(); i++)
			if (VR.gume.get(i).getMarkaModel().equals(AG.getMarkaModel()))
				expectedAG.add(VR.gume.get(i));
		
		
		realAG = VR.pronadjiGumu(AG.getMarkaModel());
		assertEquals(expectedAG.get(0), realAG.get(0));
	}
}
