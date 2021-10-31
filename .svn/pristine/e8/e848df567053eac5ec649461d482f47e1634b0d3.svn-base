package net.sjmworld.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data @Alias("board")
public class BoardVo {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;
	
	private int replyCnt;
	
	@Autowired                  //첨부파일 널일때도 문제가 없게 빈 값 생성 (자원낭비 발생, 가독성좋게 하기 위해, 코드 짧게 )
	private List<AttachVo> attachs = new ArrayList<>();
	
}
