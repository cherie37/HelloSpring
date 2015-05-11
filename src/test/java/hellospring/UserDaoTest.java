package hellospring;
import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.dao.UserDao;
import com.aug.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/hellospring/hellospring-servlet.xml" })
@Transactional
public class UserDaoTest {

	@Autowired
	UserDao userdao;

	Serializable id;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUserDao() {
		
		User user1 = new User();
		user1.setFirstName("Cher");
		user1.setLastName("Thep");
		
		userdao.create(user1);
	}

}
