package net.sjmworld.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ReplyCriteria extends Criteria {
	private long lastRno = 0L;

	
	public ReplyCriteria() {
		this(10);
	}
	
	
	public ReplyCriteria( int amount) {
		setAmount(amount);
	}
	
	public ReplyCriteria(Long lastRno, int amount) {
		this(lastRno);
		setAmount(amount);
	}

}
