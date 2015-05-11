package hellospring;
import java.io.Serializable;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.dao.DepartmentDao;
import com.aug.entities.Department;

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations = { "/hellospring/hellospring-servlet.xml" })
	@Transactional
	public class DepartmentDaoTest {

		Serializable id;
		
		@Autowired
		DepartmentDao departmentsDao;
		
		@Before
		public void setUp() throws Exception {
			
		}

		@After
		public void tearDown() throws Exception {
			
		}


		@Test
		//@Ignore
		//@Rollback(value = false)
		public void testCreateDepartmentTable() throws Exception {

			Department department1 = new Department();
			department1.setdName("IT");

			Department department2 = new Department();
			department2.setdName("HR");

			Department department3 = new Department();
			department3.setdName("Manager");

			Department department4 = new Department();
			department4.setdName("Finance");

			departmentsDao.create(department1);
			departmentsDao.create(department2);
			departmentsDao.create(department3);
			departmentsDao.create(department4);
		}
}
