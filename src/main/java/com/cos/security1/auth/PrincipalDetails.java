package com.cos.security1.auth;

// security가 login 주소 요청이 오면 낚아채서 로그인을 진행시킴
// 로그인을 진행이 완료가 되면 session을 만들어줌 (security ContextHolder)
// 오브젝트 => Authentication 타입의 객체
// Authentication 안에 user정보가 있어야 함
// user 오브젝트 타입 => UserDetails 타입 객체

import com.cos.security1.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// Security Session => Authentication 객체만 들어갈 수 있음 => UserDetails(principalDetails) 객체
public class PrincipalDetails implements UserDetails {

    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    //해당 유저의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        // 해당 사이트에서 1년동안 회원이 로그인을 안 하면 휴먼계정 전환
        // 현재 시간 - 로그인시간 -> 1년 초과하면 return false;
        return true;
    }
}
