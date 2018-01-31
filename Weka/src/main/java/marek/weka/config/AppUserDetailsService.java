package marek.weka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import marek.weka.entiti.AppUser;
import marek.weka.repository.AppUserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	AppUserRepository appUserRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = appUserRepository.findOneByUsername(username);
		return appUser;
	}

}
