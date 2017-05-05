package base;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	static PersonDomainModel per1 = new PersonDomainModel();
	static PersonDomainModel per2 = new PersonDomainModel();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		per1.setFirstName("Cong");
		per1.setLastName("Meng");
		per1.setBirthday(new Date());
		per1.setStreet("111 Christiana Drive");
		per1.setCity("Newark");
		per1.setPostalCode(19171);

		per2.setFirstName("Cong1");
		per2.setLastName("Meng1");
		per2.setBirthday(new Date());
		per2.setStreet("1 Christiana Drive");
		per2.setCity("New");
		per2.setPostalCode(19170);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(per1.getPersonID());
		PersonDAL.deletePerson(per2.getPersonID());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestAddPerson() {
		PersonDAL.addPerson(per1);
		assertNotNull(PersonDAL.getPerson(per1.getPersonID()));
	}
	
	@Test
	public void TestGet(){
		assertTrue(PersonDAL.getPerson(per1.getPersonID()).equals(per1));
	}
	
	@Test
	public void TestUpdate(){
		per1.setFirstName("Test");
		PersonDAL.updatePerson(per1);
		assertTrue(PersonDAL.getPerson(per1.getPersonID()).getFirstName() == "Test");
	}
	
	@Test
	public void TestDelete(){
		PersonDAL.deletePerson(per1.getPersonID());
		assertNull(PersonDAL.getPerson(per1.getPersonID()));
	}
	
	@Test
	public void TestGerPersons(){
		ArrayList<PersonDomainModel> pers = PersonDAL.getPersons();
		assertNotNull(pers);
	}

}
