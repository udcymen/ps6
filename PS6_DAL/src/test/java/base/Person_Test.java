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
		p1.setBirthday(LocalDate.now());
		p1.setStreet("111 Christiana Drive");
		p1.setCity("Newark");
		p1.setPostalCode(19171);
		PersonDAL.addPerson(p1);
		
		PersonDAL.addPerson(p2);
		p1.setFirstName("Cong1");
		p1.setLastName("Meng1");
		p1.setBirthday(LocalDate.now());
		p1.setStreet("1 Christiana Drive");
		p1.setCity("New");
		p1.setPostalCode(19170);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(p1.getId());
		PersonDAL.deletePerson(p2.getId());
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
		PersonDAL.getPerson(p1.getId()).equals(p1);
		

		
	}

}
