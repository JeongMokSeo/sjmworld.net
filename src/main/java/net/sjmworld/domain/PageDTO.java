package net.sjmworld.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageDTO {
	private static int PAGE_AMOOUNT = 10;
	private int total;
	private Criteria cri;
	
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	public PageDTO() {
		
	}

	public PageDTO(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		
		//수식계산
		//endPage = ((cri.getPageNum() - 1) / 10 + 1 ) * 10;
		//startPage = (cri.getPageNum() -1) ;
		//endPage = (total % cri.getAmount() == 0 ) ? total / cri.getAmount() : total / cri.getAmount() + 1;
		
		endPage = ( (cri.getPageNum() - 1) / PAGE_AMOOUNT  + 1) * PAGE_AMOOUNT;
		startPage = endPage  - PAGE_AMOOUNT + 1;
		
		int realEnd = (total + cri.getAmount() -1) / cri.getAmount();
		
		endPage= realEnd < endPage ? realEnd: endPage;
		
		prev = startPage > 1 ;
		next = endPage < realEnd;
		
		//System.out.println(total + " ," + endPage);

	}

	
//	public static void main(String[] args) {
//		System.out.println(new PageDTO(273, new Criteria(2,10)));
//	}
	
	
}
