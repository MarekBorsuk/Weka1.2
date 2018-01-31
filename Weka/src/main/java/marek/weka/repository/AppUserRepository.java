package marek.weka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marek.weka.entiti.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findOneByUsername(String username);
}
