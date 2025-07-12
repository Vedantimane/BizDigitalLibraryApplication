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
            new Book(null, "Artificial Intelligence: A Modern Approach", "Stuart Russell, Peter Norvig", "978-0136042594", true),
            new Book(null, "Deep Learning", "Ian Goodfellow, Yoshua Bengio, Aaron Courville", "978-0262035613", true),
            new Book(null, "Hands-On Machine Learning with Scikit-Learn, Keras, and TensorFlow", "Aurélien Géron", "978-1492032649", true),
            new Book(null, "The Hundred-Page Machine Learning Book", "Andriy Burkov", "978-1999579500", true),
            new Book(null, "Life 3.0: Being Human in the Age of Artificial Intelligence", "Max Tegmark", "978-1101970317", true)
        );
        bookRepository.saveAll(defaultBooks);
        books.addAll(defaultBooks);
    }
}


    public Book addBook(Book book) {
        return bookRepository.save(book); 
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
