package fr.ybeneito.pil.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                    .password(passwordEncoder().encode( "nimda"))
                    .roles("ADMIN")
                .and()
                .withUser("waz")
                    .password(passwordEncoder().encode("azerty"))
                    .roles("USER")
                .and()
                .withUser("manager")
                    .password(passwordEncoder().encode("manager"))
                    .roles("MANAGER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/person").authenticated()
                .antMatchers("/person/add").hasAnyRole("ADMIN", "MANAGER")

                .antMatchers("/project").authenticated()
                .antMatchers("/project/add").hasAnyRole("ADMIN", "MANAGER")

                .and().httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
