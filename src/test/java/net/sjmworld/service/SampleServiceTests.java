package net.sjmworld.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.sjmworld.domain.BoardVo;
import net.sjmworld.domain.Criteria;
import net.sjmworld.domain.ReplyCriteria;
import net.sjmworld.domain.ReplyVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleServiceTests {
	@Setter @Autowired
	private SampleService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);		
	}
	
	@Test
	public void testClass() {
		log.info(service);		
		log.info(service.getClass().getSimpleName());		
	}
	
	@Test
	public void testAdd() {
		log.info(service.doAdd("123", "456"));
	}

}
