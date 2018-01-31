package marek.weka.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;





@RestController
@RequestMapping("/api")
public class UploadDownloadController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public @ResponseBody void upload(@RequestParam("file") MultipartFile file){
		String fileName = "";
		try{
			fileName = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream
					(new FileOutputStream(new File("upload/" + fileName)));
			bufferedOutputStream.write(bytes);
			bufferedOutputStream.close();
		}catch (IOException ex){
			log.info("Can not receive file" + fileName);
		}
	}
	
}