package test.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select user_name, password, enabled from people_entity where user_name=?")
                .authoritiesByUsernameQuery("select user_name, role_name from roles_entity where user_name=?");
        System.out.println("database");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**","/login").permitAll().antMatchers("/hello").hasRole("USER")
                .anyRequest().authenticated().and().formLogin().loginPage("/").permitAll().and().logout()
                .permitAll();
        http.exceptionHandling().accessDeniedPage("/AccessDeniedPage");
    }

}