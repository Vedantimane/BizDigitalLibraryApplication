package com.vedanti.library.library_api.LibraryApp;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private final List<Book> books = new ArrayList<>();

    @PostConstruct
    public void initDefaultBooks() {
        if (bookRepository.count() == 0) {
            List<Book> defaultBooks = List.of(
                new Book(null, "The Hobbit", "J.R.R. Tolkien", "978-0547928227", true),
                new Book(null, "1984", "George Orwell", "978-0451524935", true),
                new Book(null, "To Kill a Mockingbird", "Harper Lee", "978-0061120084", true),
                new Book(null, "The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", true),
                new Book(null, "Pride and Prejudice", "Jane Austen", "978-1503290563", true)
            );
            bookRepository.saveAll(defaultBooks);
            books.addAll(defaultBooks);
        }
    }

    public Book addBook(Book book) {
        return bookRepository.save(book); // no validation here
    }
    

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public boolean deleteBook(int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            books.removeIf(b -> b.getId() == id);
            return true;
        }
        return false;
    }

    public boolean updateAvailability(int id, boolean available) {
        Book book = getBookById(id);
        if (book != null) {
            book.setAvailable(available);
            bookRepository.save(book);
            return true;
        }
        return false;
    }
}
