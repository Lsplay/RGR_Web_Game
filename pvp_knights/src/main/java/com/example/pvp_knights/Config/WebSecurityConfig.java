package com.example.pvp_knights.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.pvp_knights.dataBase.data.user_information_service;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	user_information_service userService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
				// Только те, кто не зарегестрированны
				.antMatchers("/registration", "/start/**","/chat/add", "/activate/*").not().fullyAuthenticated()
				.antMatchers("/css/**", "/images/**", "/js/**", "/jquery/**", "/fonts/**").permitAll()
				// Админы
				.antMatchers("/admin/**").hasRole("ADMIN")
				// Обычные Пользователи
				.antMatchers("/news").hasRole("USER")
				// Все, кто авторизован
				.antMatchers("/", "/game/**").authenticated().and()
				// Для входа в систему
				.formLogin().loginPage("/login")
				// При успешном входе перенаправление на главную страницу
				.defaultSuccessUrl("/").permitAll().and()
				// Перенаправление при выходе
				.logout().permitAll().logoutSuccessUrl("/login");

	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
	}

}
