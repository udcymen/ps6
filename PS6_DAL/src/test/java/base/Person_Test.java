package base;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	static PersonDomainModel p1 = new PersonDomainModel();
	static PersonDomainModel p2 = new PersonDomainModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p1.setFirstName("Cong");
		p1.setLastName("Meng");
		p1.setCity("Newark");
		p1.setBirthday(LocalDate.now());
		p1.setPostalCode(19717);
		p1.setStreet("111 Christiana Drive");
		
		p2.setFirstName("Cong1");
		p2.setLastName("Meng1");
		p2.setCity("Willminton");
		p2.setBirthday(LocalDate.now());
		p2.setPostalCode(19700);
		p2.setStreet("1 south Street");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		p1 = null;
		p2 = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<PersonDomainModel> p = new ArrayList<PersonDomainModel>();
		p.add(p1);
		p.add(p2);
		PersonDAL.addPerson(p1);
		PersonDAL.addPerson(p2);
		PersonDAL.getPerson(p1.getId()).equals(p1);
		

		
	}

}
