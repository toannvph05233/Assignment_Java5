package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.service.NhanVienService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    NhanVienService nhanVienService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu ng dùng
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(nhanVienService) // Cung cáp userservice cho spring security
            .passwordEncoder(NoOpPasswordEncoder.getInstance()); 
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                
                .antMatchers("/").permitAll() // Cho phép tất cả mọi ng truy cập vào 2 địa chỉ này         
                .antMatchers("/sanpham/admin").access("hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
                .and()
                .formLogin() // Cho phép ng dùng xác thuc bằng form login
                .successHandler(successHandler())
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Cho phép logout
                .permitAll()
                .and()
                .csrf() 
                .disable() ;
    }
    @Bean
    public CustomSuccessHandler successHandler() {
        return new CustomSuccessHandler();
    }
}
