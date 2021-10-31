package net.sjmworld.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.sjmworld.domain.MemberVo;
import net.sjmworld.mapper.MemberMapper;
import net.sjmworld.security.domain.CustomUser;
@Log4j @Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired @Setter
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("loadUserByUsername::" +username);
		MemberVo vo = mapper.read(username);
		return vo == null ? null : new CustomUser(vo);
		
	}
	

}
