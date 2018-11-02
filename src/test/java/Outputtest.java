import static org.junit.Assert.*;

import org.junit.Test;

public class Outputtest {

	@Test
	public void test() {
		assertEquals(
				"[{\"classroomID\": 1,\"trainer\": \"John Gordon\",\"trainees\": [{	\"traineeID\": 1, \"traineeName\": \"Joe Bloggs\"},{\"traineeID\": 2, \"traineeName\": \"Jane Bloggs\"}],{\"classroomID\": 2,\"trainer\": \"Matt Hunt\",\"trainees\":[{\"traineeID\":3,\"traineeName\":\"David Bloggs\"},{\"traineeID\":2,\"traineeName\":\"Ceri Bloggs\"}]}]",
				JSONOutput());

	}

}
