package com.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicController {

	@RequestMapping("/basic")
	public String basic() {
		return "basic";
	}

	/*
	 * @RequestMapping(value="/save", method= POST) public String
	 * save(@RequestParam("uploadedFile") MultipartFile uploadedFile){
	 * 
	 * if( ! uploadedFile.isEmpty() ){ try { byte[] bytes=
	 * uploadedFile.getBytes(); FileOutputStream out = new FileOutputStream(new
	 * File("/tmp/"+uploadedFile.getOriginalFilename())); out.write(bytes);
	 * 
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * } return "redirect:/basic"; }
	 */

	/*
	 * Possible Error -with Part
	 * 
	 * using javax.servlet.http.Part with RequestParam results in
	 * IllegalStateException
	 * ("no matching editors or conversion strategy found")
	 * 
	 * WorkAround:
	 * 
	 * What exactly did work for you with Spring 3.0.7? Our Servlet 3.0 based
	 * StandardServletMultipartResolver got introduced in Spring 3.1, so I
	 * suppose some different setup may have worked for you before?
	 * 
	 * In Spring 3.1, javax.servlet.http.Part as a parameter argument does work,
	 * but only with our new
	 * RequestMethodHandlerMapping/RequestMethodHandlerAdapter backend
	 * infrastructure. I noticed that your stacktrace refers to the older
	 * AnnotationMethodHandlerAdapter. The simplest way to start using our 3.1
	 * MVC processing is the <mvc:annotation-driven> configuration element,
	 * which will automatically switch to our new backend infrastructure.
	 */

	@RequestMapping(value = "/save", method = POST)
	public String save(@RequestParam("uploadedFile") Part uploadedFile) {
		InputStream file =null;
		FileOutputStream out = null;
		uploadedFile.write(arg0);
		if (uploadedFile.getSize() != 0) {
			try {
				int k = 0;
				byte[] bytes = new byte[1024];
				file = uploadedFile.getInputStream();
				System.out.println(uploadedFile.getSubmittedFileName());
				while ((k = file.read(bytes)) != -1) {
					out = new FileOutputStream(new File(
							"/tmp/" + uploadedFile.getSubmittedFileName()));
					out.write(bytes, 0, k);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				if(file != null){
					try {
						file.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(out != null){
					try {
						out.flush();
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return "redirect:/basic";
	}

}
