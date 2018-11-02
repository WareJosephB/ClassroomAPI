import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Trainer;
import com.qa.util.JSONTools;

import org.junit.Test;

public class Outputtest {

	@Test
	public void test() {
		Trainer John = new Trainer("John Gordon");
		Trainee Joe = new Trainee("Joe Bloggs");
		Trainee Jane = new Trainee("Jane Bloggs");
		
		List<Trainee> Trainees = new ArrayList<Trainee>();
		Trainees.add(Joe);
		Trainees.add(Jane);
		
		Classroom thisRoom = new Classroom(John, Trainees);
		
		assertEquals(
				"[{\"classroomID\": 1,\"trainer\": \"John Gordon\",\"trainees\": [{	\"traineeID\": 1, \"traineeName\": \"Joe Bloggs\"},{\"traineeID\": 2, \"traineeName\": \"Jane Bloggs\"}]]",
				JSONTools.JSONfromObject(thisRoom));

	}

}


//,{\"classroomID\": 2,\"trainer\": \"Matt Hunt\",\"trainees\":[{\"traineeID\":3,\"traineeName\":\"David Bloggs\"},{\"traineeID\":4,\"traineeName\":\"Ceri Bloggs\"}]}