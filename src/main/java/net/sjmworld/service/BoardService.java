package net.sjmworld.service;

import java.util.List;

import net.sjmworld.domain.AttachVo;
import net.sjmworld.domain.BoardVo;
import net.sjmworld.domain.Criteria;

public interface BoardService {
	void register(BoardVo board);
	BoardVo get(Long bno);
	boolean modify(BoardVo board);
	boolean remove(Long bno);
	List<BoardVo> getList();
	List<BoardVo> getList(Criteria cri);
	int getTotal(Criteria cri);
	List<AttachVo> getAttachs(Long bno);

}
