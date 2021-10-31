package net.sjmworld.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.sjmworld.domain.GoodsVo;
import net.sjmworld.mapper.GoodsMapper;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService{
	private GoodsMapper mapper;
	
	@Override
	public void insert(GoodsVo vo) {
		mapper.insert(vo);
		vo.getAttachs().forEach(mapper::insertAttach);
		
	}

	@Override
	public void insertAttach(Map<String, Object> map) {
		mapper.insertAttach(map);
		
	}

}
