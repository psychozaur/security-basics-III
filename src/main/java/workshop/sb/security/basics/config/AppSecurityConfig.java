package workshop.sb.security.basics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder
                .inMemoryAuthentication()
                .withUser("user")
// {noop}password: https://stackoverflow.com/questions/46999940/spring-boot-passwordencoder-error
                .password("{noop}password")
                .roles("USER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/delete/**").hasRole("ADMIN")
                .antMatchers("/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();
    }

                /*
                    TODO 3 Ustawienie custom'owej strony do logowania

                    użyj API dla:

                    1. logowania do custom'owej strony:
                                                       -ustawienie strony do logowania na "/login"
                                                       -dostęp do tej stony dla wszystkich użytkowników

                    2. stylowania strony - zezwól na przepuszczanie wszystkich request'ów na '/webjars/**'

                 */
}
