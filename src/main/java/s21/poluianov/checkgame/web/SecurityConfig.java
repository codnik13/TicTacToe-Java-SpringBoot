package s21.poluianov.checkgame.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import s21.poluianov.checkgame.datasource.repository.UserRepository;
import s21.poluianov.checkgame.web.model.SignUpRequest;
import s21.poluianov.checkgame.web.model.Users;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    UserRepository userRepository;
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<Users> users=userRepository.findAll();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        for (int i = 0; i < users.size(); i++)
            manager.createUser(User.builder().username(users.get(i).getLogin())
                    .password(encoder.encode(users.get(i).getPassword())).build());
        return manager;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable).build();
                //.authorizeHttpRequests(auth->auth.requestMatchers("/save.html").permitAll()
                //.anyRequest().authenticated()).formLogin(form->form.loginPage("/index.html").permitAll()).build();
    }
}
