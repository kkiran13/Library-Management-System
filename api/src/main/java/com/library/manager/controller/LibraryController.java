package com.library.manager.controller;

import com.library.manager.service.LibraryStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kkiran on 2/5/18.
 */
@RestController
public class LibraryController {

    @Autowired
    private LibraryStorageService libraryStorageService;

    /***
     * Method to check health of API
     * @return Response status
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Library API is healthy!!");
    }

    /**
     * Method to add a new book to inventory
     * @param requestString Request body (as a Json)
     */
    @PostMapping("/api/addbook")
    public void addBookEvent(@RequestBody String requestString) {
        libraryStorageService.addBook(requestString);
    }

}
