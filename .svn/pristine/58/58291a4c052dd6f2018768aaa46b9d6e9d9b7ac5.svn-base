package net.sjmworld.mapper;

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
public class BoardMapperTests {

	@Autowired @Setter
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
//		mapper.getList();
//		mapper.getList().forEach(System.out::println);
		mapper.getList().forEach(log::info);
	}	
	@Test
	public void testGetListPaging() {
		Criteria cri = new Criteria(1,10);
		cri.setType("TC");
		cri.setKeyword("새글");
		mapper.getListWithPaging(cri).forEach(log::info);
	}	
	
	@Test
	public void testInsert(){
		BoardVo board = new BoardVo();
		board.setTitle("영속 테스트 제목");
		board.setContent("영속 테스트 내용");
		board.setWriter("USER15");
		mapper.insert(board);
//		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey(){
		BoardVo board = new BoardVo();
		board.setTitle("영속 테스트 제목 - 셀렉트키");
		board.setContent("영속 테스트 내용 - 셀렉트키");
		board.setWriter("USER15");
		log.info("before::" + board);
		mapper.insertSelectKey(board);
		log.info("after::" + board);
	}
	
	@Test
	public void testRead() {
		
		log.info(mapper.read(7L));
	}
	
	@Test
	public void testUpate() {
		BoardVo board = new BoardVo();
		board.setTitle("수정된 테스트 제목");
		board.setContent("수정된 테스트 내용");
		board.setWriter("USER15");
		board.setBno(7L);
		log.info(mapper.update(board));
		log.info(mapper.read(7L));	
	}
	
	@Test 
	public void testDelete() {
		log.info(mapper.read(3L));	
		log.info(mapper.delete(3L));	
		log.info(mapper.read(3L));			
	}
	
	@Test 
	public void testGetTotalCount() {
		Criteria cri = new Criteria(1,10);
		cri.setType("TC");
		cri.setKeyword("새글");
		log.info(mapper.getTotalCount(cri));	
			
	}
	
}
