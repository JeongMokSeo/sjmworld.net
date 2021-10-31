package net.sjmworld.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.sjmworld.domain.ReplyCriteria;
import net.sjmworld.domain.ReplyVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Autowired @Setter
	private ReplyMapper mapper;
	
	@Test
	public void testExist() {
		assertNotNull(mapper);
	}
	
	@Test
	public void testInsert() {
		IntStream.range(0, 5).forEach(i->{
			ReplyVo vo = new ReplyVo();
			
			vo.setBno(65561L);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("댓글러");
			
			mapper.insert(vo);
		});
		
	}	
	
	@Test
	public void testRead() {			
		log.info("read ::" + mapper.read(1L));
	}	
	
	@Test
	public void testUpdate() {
		ReplyVo vo = new ReplyVo();
		vo.setRno(1L);
		vo.setReply("댓글된 댓글" );
		vo.setReplyer("수정맨");		
		mapper.update(vo);
		
		log.info("update ::" + mapper.read(1L));
	}	
	
	@Test
	public void testRemove() {
		log.info("delete ::" +mapper.delete(2L));		
	}

	@Test
	public void testGetList() {
		
		ReplyCriteria criteria = new ReplyCriteria();
		criteria.setLastRno(11L);
		mapper.getList(65561L, criteria).forEach(log::info);		
	}
	
	
	
	
}
