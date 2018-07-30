package com.sports.security;

import com.sports.model.User;
import com.sports.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String email = auth.getName();
        String password = auth.getCredentials().toString();

        User user = userService.findUserByEmail(email);

        if (user != null) {
            if (userEnable(user)) {
                Collection<? extends GrantedAuthority> authorities = user.getRoles();
                return new UsernamePasswordAuthenticationToken(email, password, authorities);
            } else {
                throw new BadCredentialsException("User is disabled!");
            }
        }

        throw new UsernameNotFoundException("Email and/or Passwords invalids!");
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean userEnable(User user) {
        if (user != null) {
            if (user.getEnabled() == true) {
                return true;
            }
        }
        return false;
    }
}
