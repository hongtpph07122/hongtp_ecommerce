package heroku.app.demo.Configs;

import heroku.app.demo.Spring_Security.AuthEntryPointJwt;
import heroku.app.demo.Spring_Security.JwtAuthFilter;
import heroku.app.demo.Spring_Security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
//		securedEnabled = true,
//		jsr250Enabled = true,
        prePostEnabled = true
)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtAuthFilter jwtAuthFilter() {
        return new JwtAuthFilter();
    }

    @Autowired
    AuthEntryPointJwt authEntryPointJwt;
    @Autowired
    UserService userService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)// Cung cấp userService cho spring security
                .passwordEncoder(passwordEncoder()); // Cung cấp passwordEncoder
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors() // Ngăn chặn request từ một domain khác
                .and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authEntryPointJwt).and()
                //
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // Các request cần có thêm token
                .authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/signup").permitAll()
                .antMatchers("/api/logup").permitAll()
                .antMatchers("/api/**").permitAll()
                //Cho phép tất cả mọi người truy cập vào
                .anyRequest().authenticated(); // Tất cả request khác đều cần được xác thực
        // Thêm 1 lớp Filter để kiểm tra jwt
        http.addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
