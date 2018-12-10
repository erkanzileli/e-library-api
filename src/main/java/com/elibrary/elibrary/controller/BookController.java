package com.elibrary.elibrary.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elibrary.elibrary.domain.Book;
import com.elibrary.elibrary.repository.BookRepository;

@RestController
@RequestMapping("/file")
public class BookController {
    private static String UPLOADED_FOLDER = "books//";
    private BookRepository bookRepository;
	
    @GetMapping("/")
    public String index() {
        return "upload";
    }
    public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
    
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("id") long id, @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            Book book = bookRepository.findById(id).get();
            book.setFilePath(String.valueOf(path));
            
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}
