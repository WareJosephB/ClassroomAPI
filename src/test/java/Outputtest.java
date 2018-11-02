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
		
		Trainer Matt = new Trainer("Matt Hunt");
		Trainee David = new Trainee("David Bloggs");
		Trainee Ceri = new Trainee("Ceri Bloggs");
		
		List<Trainee> room2Trainees = new ArrayList<Trainee>();
		room2Trainees.add(David);
		room2Trainees.add(Ceri);
		
		List<Trainee> Trainees = new ArrayList<Trainee>();
		Trainees.add(Joe);
		Trainees.add(Jane);
		
		Classroom thisRoom = new Classroom(John, Trainees);
		Classroom thatRoom = new Classroom(Matt, room2Trainees);
		
		List<Classroom> School = new ArrayList<Classroom>();
		School.add(thisRoom);
		School.add(thatRoom);
		
		assertEquals(
				"[{\"id\":0,\"roomLead\":{\"id\":0,\"name\":\"John Gordon\"},\"students\":[{\"name\":\"Joe Bloggs\",\"technicalSkills\":0,\"softSkills\":0,\"id\":0,\"classRoomid\":0},{\"name\":\"Jane Bloggs\",\"technicalSkills\":0,\"softSkills\":0,\"id\":0,\"classRoomid\":0}]},{\"classroomID\": 2,\"trainer\": \"Matt Hunt\",\"trainees\":[{\"traineeID\":3,\"traineeName\":\"David Bloggs\"},{\"traineeID\":4,\"traineeName\":\"Ceri Bloggs\"}]}]"
				, JSONTools.JSONfromObject(School));

	}

}

