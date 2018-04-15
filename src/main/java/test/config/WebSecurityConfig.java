//package test.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//
//@Configuration
//@EnableWebMvcSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/planetBase","/employee","/priceList","/signUp"
//                        ,"/autentification","/assets/**","/test","/addAtmosphere","/addPlanet","/allAtm").permitAll()
//                .anyRequest().authenticated();
//        http
//                .formLogin()
//                .loginPage("/#/autentification")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    @Configuration
//    protected static class AuthenticationConfiguration extends
//            GlobalAuthenticationConfigurerAdapter {
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            auth
//                    .inMemoryAuthentication()
//                    .withUser("user").password("password").roles("USER");
//        }
//
//    }
//
//}