package de.clumsystuff.security.watcher;

import java.io.FileOutputStream;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
public class ImageController {

	@PostMapping
	public void upload(@RequestParam("image") MultipartFile image) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-SSS");
		try(FileOutputStream outputStream = new FileOutputStream(ZonedDateTime.now().format(formatter) + ".jpeg")) {
			outputStream.write(image.getBytes());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping
	public String download() {
		
		return "This will be an image soon!";
	}
}
