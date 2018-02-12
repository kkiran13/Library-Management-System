package com.library.manager.controller;

import com.library.manager.service.LibraryStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/library/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Library API is healthy!!");
    }

    /***
     * Method to add/remove/checkout/return book to/from inventory
     * @param action add/delete/checkout/return
     * @param requestString requestString Request body (as a Json)
     * @return Response Entity
     */
    @PostMapping("/library/book/{action}")
    public ResponseEntity<?> bookEvent(@PathVariable String action, @RequestBody String requestString) {
        libraryStorageService.bookAction(action, requestString);
        return ResponseEntity.noContent().build();
    }

    /***
     * Method to add/remove book to/from inventory
     * @param action add/remove
     * @param requestString requestString Request body (as a Json)
     * @return Response Entity
     */
    @PostMapping("/library/customer/{action}")
    public ResponseEntity<?> customerEvent(@PathVariable String action, @RequestBody String requestString) {
        libraryStorageService.customerAction(action, requestString);
        return ResponseEntity.noContent().build();
    }

}
