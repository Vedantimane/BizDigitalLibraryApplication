package com.vedanti.library.library_api.LibraryApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
public ResponseEntity<?> addBook(@RequestBody Book book) {
    if (book.getTitle() == null || book.getTitle().isBlank()) {
        return ResponseEntity.badRequest().body("Title is required");
    }

    return ResponseEntity.ok(bookService.addBook(book));
}


    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.status(404).body("Book not found with ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return ResponseEntity.ok("Book with ID " + id + " has been deleted.");
        } else {
            return ResponseEntity.status(404).body("Book not found with ID: " + id);
        }
    }

    @PutMapping("/{id}/availability")
public ResponseEntity<?> updateAvailability(@PathVariable int id, @RequestParam boolean available) {
    boolean updated = bookService.updateAvailability(id, available);

    if (!updated) {
        return ResponseEntity.status(404).body("Book not found with ID: " + id);
    }

    String message = available
        ? "The book with ID " + id + " is now available in the library."
        : "The book with ID " + id + " is currently unavailable in the library.";

    return ResponseEntity.ok(message);
}

}
