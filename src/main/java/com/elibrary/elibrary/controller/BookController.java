package com.elibrary.elibrary.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elibrary.elibrary.domain.Book;
import com.elibrary.elibrary.repository.BookRepository;
import com.mysql.cj.log.Log;

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
    
    @PostMapping("/upload/{bookId:.+}")
    public boolean singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes,
                                   @PathVariable("bookId") long bookId) {
        if (file.isEmpty()) {
            System.out.print("Please select a file to upload");
            return false;
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + bookId + "-" + file.getOriginalFilename());
            Files.write(path, bytes);
            Book book = bookRepository.findById(bookId).get();
            book.setFilePath(String.valueOf(Paths.get(bookId + "-" + file.getOriginalFilename())));
            bookRepository.save(book);
            System.out.print("You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping("/download/{fileName:.+}")
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response,
                                     @PathVariable("fileName") String fileName)
    {
    	
        String dataDirectory = "books";
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file))
        {
        	response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
                Book book = bookRepository.findById(Long.parseLong(fileName.split("-")[0])).get();
                book.setDownloadCount(book.getDownloadCount() + 1);
                bookRepository.save(book);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
