package de.clumsystuff.security.watcher;

import java.io.FileOutputStream;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

	@PostMapping(path = "/images", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void upload(@RequestParam("image") MultipartFile image) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-SSS");
		try(FileOutputStream outputStream = new FileOutputStream(ZonedDateTime.now().format(formatter) + ".jpeg")) {
			outputStream.write(image.getBytes());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
