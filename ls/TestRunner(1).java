package soloQ;

import java.util.logging.Logger;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(Kolekcija1.class, Kolekcija2.class);

		Logger l = Logger.getLogger(TestRunner.class.toString());

		l.info("Vreme izvrsavanja: " + result.getRunTime() + " ms");
		l.info("Broj testova: " + result.getRunCount());

		if (result.wasSuccessful())
			l.info("Svi testovi su uspesno izvrseni!");
		else {
			l.info("Uspesno testova: " + (result.getRunCount() - result.getFailureCount() - result.getIgnoreCount()
					- result.getAssumptionFailureCount()));
			l.info("Broj palih testova: " + result.getFailureCount());
			if (result.getFailureCount() > 0)
				for (Failure f : result.getFailures()) {
					l.warning(f.toString());
				}
			l.info("Broj preskocenih: " + result.getIgnoreCount());
			l.info("Broj dinamicki preskocenih: " + result.getAssumptionFailureCount());
		}

	}
}
