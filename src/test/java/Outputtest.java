//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.qa.persistence.domain.Classroom;
//import com.qa.persistence.domain.Trainee;
//import com.qa.persistence.domain.Trainer;
//import com.qa.util.JSONTools;
//
//import org.junit.Test;
//
//public class Outputtest {
//
//	@Test
//	public void test() {
//		Trainer John = new Trainer("John Gordon");
//		Trainee Joe = new Student("Joe Bloggs");
//		Trainee Jane = new Student("Jane Bloggs");
//		
//		Trainer Matt = new Trainer("Matt Hunt");
//		Trainee David = new Student("David Bloggs");
//		Trainee Ceri = new Student("Ceri Bloggs");
//		
//		List<Trainee> room2Students = new ArrayList<Trainee>();
//		room2Students.add(David);
//		room2Students.add(Ceri);
//		
//		List<Trainee> Students = new ArrayList<Trainee>();
//		Students.add(Joe);
//		Students.add(Jane);
//		
//		Classroom thisRoom = new Classroom(John, Students);
//		Classroom thatRoom = new Classroom(Matt, room2Students);
//		
//		List<Classroom> School = new ArrayList<Classroom>();
//		School.add(thisRoom);
//		School.add(thatRoom);
//		
//		assertEquals(
//				"[{\"id\":0,\"roomLead\":{\"id\":0,\"name\":\"John Gordon\"},\"students\":[{\"name\":\"Joe Bloggs\",\"technicalSkills\":0,\"softSkills\":0,\"id\":0,\"classRoomid\":0},{\"name\":\"Jane Bloggs\",\"technicalSkills\":0,\"softSkills\":0,\"id\":0,\"classRoomid\":0}]},{\"classroomID\": 2,\"trainer\": \"Matt Hunt\",\"trainees\":[{\"traineeID\":3,\"traineeName\":\"David Bloggs\"},{\"traineeID\":4,\"traineeName\":\"Ceri Bloggs\"}]}]"
//				, JSONTools.JSONfromObject(School));
//
//	}
//
//}
//
