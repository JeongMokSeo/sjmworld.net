package net.sjmworld.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.sjmworld.domain.ReplyCriteria;
import net.sjmworld.domain.ReplyVo;

public interface ReplyMapper {
	int insert(ReplyVo vo);
	ReplyVo read(Long rno);
	int update(ReplyVo vo);
	int delete(Long rno);
	List<ReplyVo> getList(@Param("bno") Long bno, @Param("cri") ReplyCriteria cri);
	
}
