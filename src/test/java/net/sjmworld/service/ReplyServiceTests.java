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
public class ReplyServiceTests {
	@Setter @Autowired
	private ReplyService service;
	
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
	public void testRegister() {
		ReplyVo replyVo = new ReplyVo();
		replyVo.setReply("서비스 테스트 제목");
		replyVo.setReplyer("서비스 테스트");
		replyVo.setBno(65561L);	
		service.register(replyVo);
	}
	
	@Test
	public void testGet() {
		log.info(service.get(36L));
	}
	
	@Test
	public void testModify() {
		ReplyVo replyVo = new ReplyVo();
		replyVo.setReply("서비스 수정 제목");
		replyVo.setReplyer("서비스 수정 테스트");
		replyVo.setRno(36L);	
		service.modify(replyVo);
		log.info(service.get(36L));
	}
	
	@Test
	public void testRemove() {
		log.info(service.get(4L));
		log.info(service.remove(4L));
		log.info(service.get(4L));		
	}
	
	@Test
	public void testGetList() {
		ReplyCriteria criteria = new ReplyCriteria();
		criteria.setLastRno(11L);
		service.getList(criteria,65561L).forEach(log::info);
	}
	
//	@Test
//	public void testGetTotal() {
//		log.info(service.getTotal(new Criteria()));	
//	}
}
