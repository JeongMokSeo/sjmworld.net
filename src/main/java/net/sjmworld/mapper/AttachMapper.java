package net.sjmworld.mapper;

import java.util.List;

import net.sjmworld.domain.AttachVo;

public interface AttachMapper {

	void insert(AttachVo vo);
	void delete(String uuid);
	List<AttachVo> findByBno(Long bno);
	AttachVo findBy(String uuid);
	void deleteAll(Long bno);
	
	List<AttachVo> getOldFiles();
}
