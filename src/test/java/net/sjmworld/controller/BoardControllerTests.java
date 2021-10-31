package net.sjmworld.controller;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
@WebAppConfiguration
public class BoardControllerTests {

		@Autowired @Setter
		private BoardController controller;
		
		@Autowired @Setter
		private WebApplicationContext ctx;
		
		private MockMvc mvc;
		
		@Before
		public void setup() {
			mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		}
		
		@Test
		public void testExists() {
			assertNotNull(ctx);
			assertNotNull(mvc);
			log.info(ctx);
			log.info(mvc);
		}
		
		@Test
		public void testList() throws Exception {
			ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/board/list")
			.param("pageNum", "1")
			.param("amount", "20")
			)
			.andReturn()
			.getModelAndView()
			.getModelMap();
			
			log.info(map);
			List<?> list=(List<?>) map.get("list");
			list.forEach(log::info);
		}
		
		@Test
		public void testGet() throws Exception {
			ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/board/get")
			.param("bno","1"))
			.andReturn()
			.getModelAndView();

			log.info(mav.getViewName());			

		}	
				
		@Test
		public void testResister() throws Exception {
			ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/board/register")
					.param("title", "컨트롤러 테스트 글제목")
					.param("content", "컨트롤러 테스트 글내용")
					.param("writer", "컨트롤러 테스터"))
					.andReturn()
					.getModelAndView();
			
			log.info(mav.getViewName());

		}
		
		@Test
		public void testModify() throws Exception {
			ModelAndView mav = mvc.perform(
					MockMvcRequestBuilders.post("/board/modify")
					.param("bno","1")
					.param("title", "수정된 컨트롤러 테스트 글제목")
					.param("content", "수정된 컨트롤러 테스트 글내용")
					.param("writer", "수정된 컨트롤러 테스터")
					)
					.andReturn()
					.getModelAndView();
			
			log.info(mav.getViewName());
		}
		
		@Test
		public void testRemove() throws Exception {
			ModelAndView mav = mvc.perform(
					MockMvcRequestBuilders.post("/board/remove")
					.param("bno","4")
					)
					.andReturn()
					.getModelAndView();

			log.info(mav.getViewName());			

		}				
}
