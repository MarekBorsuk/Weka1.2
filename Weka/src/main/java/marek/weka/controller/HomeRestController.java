package marek.weka.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import marek.weka.entiti.AppUser;
import marek.weka.repository.AppUserRepository;

@RestController
public class HomeRestController {
	@Autowired
	private AppUserRepository appUserRepository;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser){
		if(appUserRepository.findOneByUsername(appUser.getUsername()) !=null){
			throw new RuntimeException("UserName already exist");
		}
		appUser.setRole("USER");
		return new ResponseEntity<AppUser>(appUserRepository.save(appUser),HttpStatus.CREATED);
	}
	
	@RequestMapping(value ="/user")
	public Principal user(Principal principal){
		return principal;
	}
}
