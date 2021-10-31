package net.sjmworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.sjmworld.domain.ReplyCriteria;
import net.sjmworld.domain.ReplyVo;
import net.sjmworld.mapper.BoardMapper;
import net.sjmworld.mapper.ReplyMapper;


@Service
@AllArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	@Setter @Autowired
	private ReplyMapper mapper;
	private BoardMapper boardMapper;

	@Override
	@Transactional
	public void register(ReplyVo vo) {
		//작업1
		mapper.insert(vo);	
		//작업2
		boardMapper.updateReplyCnt(vo.getBno(), 1);
	}

	@Override
	public ReplyVo get(Long rno) {
		// TODO Auto-generated method stub
		return mapper.read(rno);
	}

	@Override
	public boolean modify(ReplyVo vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo) > 0;
	}

	@Transactional
	@Override
	public boolean remove(Long rno) {
		// TODO Auto-generated method stub
		boardMapper.updateReplyCnt(get(rno).getBno(), -1);
		return mapper.delete(rno) > 0;
	}

	@Override
	public List<ReplyVo> getList(ReplyCriteria cri, Long bno) {
		// TODO Auto-generated method stub
		return mapper.getList(bno, cri);
	}

}
