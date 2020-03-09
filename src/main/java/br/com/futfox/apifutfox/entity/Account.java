package br.com.futfox.apifutfox.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
public class Account implements UserDetails {
	private static final long serialVersionUID = -9087777297833535941L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String username;
	private String password;
	private Boolean expired;
	private Boolean locked;
	private Boolean enabled;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		return !this.expired;
	}
	@Override
	public boolean isAccountNonLocked() {
		return !this.locked;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return !this.expired;
	}
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	
}
