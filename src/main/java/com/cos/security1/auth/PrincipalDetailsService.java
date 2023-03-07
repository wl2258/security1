package com.cos.security1.auth;

import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// security 설정에서 loginProcessingUrl("/login");
// login 요청이 오면 자동으로 UserDetailsService 타임으로 loc 되어있는 loadUserByUsername 함수가 실행

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    // username http form 에서 받아오는 name 무조건 username 동일하게 맞춰줘야함
    // 다르게 하고 싶으면 securityConfig 에서 setUsernameParameter 로 설정
    // security session(Authentication(userDetails))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
