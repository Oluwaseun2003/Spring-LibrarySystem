package com.library.libraryCatalog.controller;


import com.library.libraryCatalog.dto.LibraryDto;
import com.library.libraryCatalog.services.LibraryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @PostMapping(value = "/book/add")
    public Object addBook(@RequestBody LibraryDto libraryDto){
        return libraryService.addBook(libraryDto);
    }

    @PutMapping("/book/{id}")
        public Object updateBook(@RequestBody LibraryDto libraryDto, @PathVariable Long id){
        return  libraryService.updateBook(libraryDto, id);
    }

    @GetMapping("/book")
    public  Object fetchBook(){
        return libraryService.fetchBook();
    }

    @DeleteMapping("/book/{id}")
    public Object deleteBook(@PathVariable Long id){
        return libraryService.deleteBook(id);
    }



}
