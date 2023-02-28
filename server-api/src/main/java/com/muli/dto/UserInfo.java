package com.muli.dto;

import com.common.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;


import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
public class UserInfo implements UserDetails {
    User user;
    Collection<GrantedAuthority> authorities;

    public UserInfo(com.common.domain.User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
