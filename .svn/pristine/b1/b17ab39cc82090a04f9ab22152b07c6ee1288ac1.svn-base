package net.sjmworld.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.sjmworld.domain.ReplyVo;
import net.sjmworld.domain.Ticket;
import net.sjmworld.sample.SampleControllerTests;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
@WebAppConfiguration
public class ReplyControllerTests {
	@Autowired @Setter
	private ReplyController controller;
	
	@Autowired @Setter
	private WebApplicationContext ctx;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	@Test
	public void testCreate() throws Exception {
		ReplyVo vo = new ReplyVo();
		vo.setReply("서비스 테스트 제목");
		vo.setReplyer("서비스 테스트");
		vo.setBno(65561L);	
		
		String jsonStr = new Gson().toJson(vo);
		
		log.info("jsonStr ::" + jsonStr);
		
		 mvc.perform(post("/replies/new")
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(jsonStr))
			.andExpect(status().is(200));
		
	}	
	
	
}
