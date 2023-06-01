package com.example.nmcnpm.service.implement;

import com.example.nmcnpm.model.TaiKhoan;
import com.example.nmcnpm.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.ObjectUtils;

public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan taiKhoan=taiKhoanService.findByUserName(username);
        if (ObjectUtils.isEmpty(taiKhoan)) {
            throw new UsernameNotFoundException(String.format("User with username : %s not found ", username));
        }
        return new UserDetailImp(taiKhoan);
    }
}
