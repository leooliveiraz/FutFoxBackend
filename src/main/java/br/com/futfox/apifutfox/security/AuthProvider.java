package br.com.futfox.apifutfox.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.futfox.apifutfox.entity.Account;
import br.com.futfox.apifutfox.service.AccountService;

@Component
public class AuthProvider implements AuthenticationProvider {

	@Autowired
	private AccountService accService;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String username = auth.getName();
		String password = auth.getCredentials().toString();
		Account account = accService.findByUsernameAndPassword(username, password);

		if (account != null) {
			if(!account.isEnabled()) {
				throw new BadCredentialsException("User not enabled.");
			}if(account.getExpired()) {
				throw new BadCredentialsException("User expired.");
			}if(account.getLocked()) {
				throw new BadCredentialsException("User not blocked.");
			}
			return new UsernamePasswordAuthenticationToken(username, password, null);            
		} else {
			throw new UsernameNotFoundException("Invalid informations.");
		}
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}