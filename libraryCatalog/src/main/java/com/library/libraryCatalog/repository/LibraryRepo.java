package com.library.libraryCatalog.repository;

import com.library.libraryCatalog.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository<Library, Long> {
    // additional query methods if needed
}
