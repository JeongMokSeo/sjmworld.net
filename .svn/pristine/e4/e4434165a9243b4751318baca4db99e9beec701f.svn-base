package net.sjmworld.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.sjmworld.domain.AttachVo;
import net.sjmworld.domain.BoardVo;
import net.sjmworld.domain.Criteria;
import net.sjmworld.mapper.AttachMapper;
import net.sjmworld.mapper.BoardMapper;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;
	private AttachMapper attachMapper;
	
	@Override @Transactional
	public void register(BoardVo boardVo) {
		boardMapper.insertSelectKey(boardVo);
		
		boardVo.getAttachs().forEach(attach-> {
			attach.setBno(boardVo.getBno());
			attachMapper.insert(attach);
		});
	}

	@Override
	public BoardVo get(Long bno) {
		return boardMapper.read(bno);
	}

	@Override @Transactional
	public boolean modify(BoardVo board) {
		boolean result = boardMapper.update(board) > 0;
		attachMapper.deleteAll(board.getBno());
		if (result) {
			board.getAttachs().forEach(vo -> {
				vo.setBno(board.getBno());
				attachMapper.insert(vo);
			});
		}
		return result;
	}

	@Override @Transactional
	public boolean remove(Long bno) {
		attachMapper.deleteAll(bno);
		return boardMapper.delete(bno) > 0;
	}
	
	@Override
	public List<BoardVo> getList() {
		return boardMapper.getList();
	}
	
	@Override
	public List<BoardVo> getList(Criteria cri) {
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return boardMapper.getTotalCount(cri);
	}

	@Override
	public List<AttachVo> getAttachs(Long bno) {
		return attachMapper.findByBno(bno);
	}


}
