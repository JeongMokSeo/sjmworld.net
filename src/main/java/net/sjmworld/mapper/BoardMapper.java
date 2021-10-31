package net.sjmworld.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.sjmworld.domain.BoardVo;
import net.sjmworld.domain.Criteria;

public interface BoardMapper {

//	@Select("SELECT * FROM TBL_BOARD WHERE BNO > 0")
//	List<BoardVo> getList();
	
	List<BoardVo> getList();
	List<BoardVo> getListWithPaging(Criteria cri);
	void insert(BoardVo board);
	void insertSelectKey(BoardVo board);	
	BoardVo read(Long bno);
	int update(BoardVo board);
	int delete(Long bno);
	int getTotalCount(Criteria cri);
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);

}
