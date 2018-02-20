package com.abnamro.springboot.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abnamro.pojo.InputForm;
import com.abnamro.service.FutureTransProcessor;

@Controller
public class FutureTransServiceController {
		@RequestMapping("/")
		public String welcome() {			
			return "redirect:/form";
		}
		
		@RequestMapping("/err")
		public String error() {			
			return "errorMsg";
		}
		
		@GetMapping("/form")
		public String generateForm() {			
	        return "inputForm";
		}
		
		@PostMapping("/gen")
		public String generate( @RequestParam("inputFilepath") MultipartFile file,@RequestParam("date") String date,
             RedirectAttributes redirectAttributes) throws IOException {
			InputForm inp = new InputForm();
			 byte[] bytes = file.getBytes();
			 Path path = Paths.get("\\temp\\" + file.getOriginalFilename());
			 Files.write(path, bytes);
			String output="err";
			FutureTransProcessor rport = new FutureTransProcessor();
			try {
				rport.generateDailySummaryReport(path,date);
				output= "result";
				redirectAttributes.addFlashAttribute("message",
	                    "successfully generated report /temp/Output_"+date + ".csv'");
			} catch (Exception e) {
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("message",
	                    e + "'");
				output= "err";
			}
			return output;
		}
}
