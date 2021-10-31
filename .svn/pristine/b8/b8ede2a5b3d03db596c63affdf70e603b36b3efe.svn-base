package net.sjmworld.security.domain;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import net.sjmworld.domain.MemberVo;

@Getter
public class CustomUser extends User {
	private MemberVo memberVo;
	
	public CustomUser(MemberVo vo) {
		super(vo.getUserid(), vo.getUserpw(),
				vo.getAuths()
				.stream()
				.map(a-> new SimpleGrantedAuthority(a.getAuth()))
				.collect(Collectors.toList()));
		this.memberVo = vo;
		
	}

}
