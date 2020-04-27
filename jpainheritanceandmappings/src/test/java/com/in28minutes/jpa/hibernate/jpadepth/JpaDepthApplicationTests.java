package com.in28minutes.jpa.hibernate.jpadepth;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.jpadepth.repository.EmployeeRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDepthApplication.class)
public class JpaDepthApplicationTests {

	@Autowired
	EmployeeRepo courseRepo;

}
