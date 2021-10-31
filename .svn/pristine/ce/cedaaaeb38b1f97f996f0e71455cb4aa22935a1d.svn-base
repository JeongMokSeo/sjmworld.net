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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter @Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);		
	}
	
	
	@Test
	public void testRegister() {
		BoardVo board = new BoardVo();
		board.setTitle("서비스 테스트 제목");
		board.setContent("서비스 테스트 내용");
		board.setWriter("USER15");	
		service.register(board);
	}
	
	@Test
	public void testGet() {
		log.info(service.get(2L));
	}
	
	@Test
	public void testModify() {
		BoardVo board = new BoardVo();
		board.setTitle("서비스 테스트 수정 제목");
		board.setContent("서비스 테스트 수정 내용");
		board.setWriter("USER15");
		board.setBno(2L);
		service.modify(board);
		log.info(service.get(2L));
	}
	
	@Test
	public void testRemove() {
		log.info(service.get(5L));
		log.info(service.remove(5L));
		log.info(service.get(5L));		
	}
	
	@Test
	public void testGetList() {
		service.getList(new Criteria(2,10)).forEach(log::info);
	}
	@Test
	public void testGetTotal() {
		log.info(service.getTotal(new Criteria()));	
	}
}
