package net.sjmworld.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.sjmworld.domain.ReplyCriteria;
import net.sjmworld.domain.ReplyVo;
import net.sjmworld.service.ReplyService;

@RestController
@AllArgsConstructor
@RequestMapping("/replies/*")
@Log4j
public class ReplyController {
	private ReplyService service;
	
//	@PreAuthorize("isAuthenticated()")	
	@PostMapping("new")
	public String create(@RequestBody ReplyVo vo) {
		log.info("create ::" +vo);
		service.register(vo);
		log.info("create ::" +vo);
		return "success";
		
	}
	
	@GetMapping("{rno}")
	public ReplyVo get(@PathVariable Long rno) {
		log.info("ReplyVo get ::" +rno);
		return service.get(rno);
	}
	
	@PutMapping("{rno}")
	public String modify(@PathVariable Long rno, @RequestBody ReplyVo vo) {
		log.info("modify::" + vo);
		service.modify(vo);
		return "success";
	}
	
	@DeleteMapping("{rno}")
	public String remove(@PathVariable Long rno) {
		log.info("remove::" + rno);
		service.remove(rno);
		return "success";
		
	}
	
	@GetMapping("{bno}/{amount}/{lastRno}")
	public List<ReplyVo> getList(@PathVariable Long bno, 
			@PathVariable(required=false) Optional<Long> lastRno,
			@PathVariable(required=false) Integer amount) {
		return service.getList(new ReplyCriteria(lastRno.get(),amount),bno);	
	}
	
	
	
}
