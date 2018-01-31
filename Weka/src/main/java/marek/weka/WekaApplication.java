package marek.weka;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import marek.weka.storage.StorageService;

@SpringBootApplication
public class WekaApplication implements CommandLineRunner {
	
	@Resource
	StorageService storageService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WekaApplication.class, args);
	}
	
	@Override
	
	public void run(String... args) throws Exception{
		storageService.deleteAll();
		storageService.init();
	}
}
