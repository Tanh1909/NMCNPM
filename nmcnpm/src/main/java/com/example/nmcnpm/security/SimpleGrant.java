package com.example.nmcnpm.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleGrant implements GrantedAuthority {
    private String author;
    @Override
    public String getAuthority() {
        return author;
    }
}
