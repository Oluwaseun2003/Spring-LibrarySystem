package com.library.libraryCatalog.services;


import com.library.libraryCatalog.dto.LibraryDto;
import com.library.libraryCatalog.model.Library;
import com.library.libraryCatalog.repository.LibraryRepo;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private  final LibraryRepo libraryRepo;

    public LibraryService(LibraryRepo libraryRepo){
        this.libraryRepo = libraryRepo;
    }

    public Object addBook(LibraryDto libraryDto){
        Library library = new Library();

        library.setTitle(libraryDto.getTitle());
        library.setAuthor(libraryDto.getAuthor());
        library.setIsbn(libraryDto.getIsbn());

        return libraryRepo.save(library);
    }

    public Object updateBook(LibraryDto libraryDto, Long id){
        Library library = libraryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        library.setTitle(libraryDto.getTitle());
        library.setAuthor(libraryDto.getAuthor());
        library.setIsbn(libraryDto.getIsbn());

        return libraryRepo.save(library);
    }

    public Object fetchBook(){
        return libraryRepo.findAll();
    }

    public Object deleteBook(Long id){
        Library library = libraryRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Book not found"));
        libraryRepo.delete(library);

        return "Book has been deleted successfully";

    }

}
