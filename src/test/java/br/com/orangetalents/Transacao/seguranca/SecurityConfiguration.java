package br.com.orangetalents.Transacao.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                authorizeRequests
                        .antMatchers(HttpMethod.POST, "/transacoes/**").hasAuthority("SCOPE_minha-transacao-escopo")
                        .antMatchers(HttpMethod.GET, "/transacoes/**").hasAuthority("SCOPE_minha-transacao-escopo")
                        .antMatchers(HttpMethod.DELETE, "/transacoes/**").hasAuthority("SCOPE_minha-transacao-escopo")
                        .anyRequest().authenticated()
        )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}