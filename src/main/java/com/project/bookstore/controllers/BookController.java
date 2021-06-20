package com.project.bookstore.controllers;

import com.project.bookstore.models.*;
import com.project.bookstore.payload.request.RateRequest;
import com.project.bookstore.payload.request.ReviewRequest;
import com.project.bookstore.payload.request.UserBookRequest;
import com.project.bookstore.payload.response.*;
import com.project.bookstore.repository.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.project.bookstore.payload.request.BookRequest;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserBookRepository userBookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRateRepository bookRateRepository;

    @Autowired
    BookReviewRepository bookReviewRepository;

    @GetMapping("/")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponse> response = new ArrayList<>();
        for(Book book : books) {
            response.add(new BookResponse(book.getId(), book.getTitle(),book.getAuthor()));
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> addBook(@Valid @RequestBody BookRequest bookRequest) {
        if(bookRepository.existsByTitle(bookRequest.getTitle())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Book with this title already exist!"));
        }
        Book book = new Book(bookRequest.getTitle(), bookRequest.getAuthor());
        bookRepository.save(book);

        return ResponseEntity.ok(book);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getBookDetails(@PathVariable("id") String id, Principal principal) {
        Long bookId = Long.parseLong(id);
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new UsernameNotFoundException("Book not exist"));
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not exist"));

        List<BookReview> reviews = bookReviewRepository.findAllByBook(book);
        List<ReviewResponse> reviewsResponse = new ArrayList<>();

        for(BookReview review: reviews) {
            reviewsResponse.add(new ReviewResponse(review.getUser().getUsername(), review.getReview()));
        }

        boolean isReviewByMe = bookReviewRepository.existsBookReviewByUserAndBook(user, book);

        BookRate myRate = bookRateRepository.findByUserAndBook(user, book).orElse(null);
        int myRateValue = myRate != null ? myRate.getRate() : 0;
        boolean isRateByMe = myRate != null;

        List<BookRate> rates = bookRateRepository.findAllByBook(book);
        int ratesSize = rates.size();
        double rateAverage = 0.0;
        for(BookRate rate: rates) {
            rateAverage += rate.getRate();
        }

        rateAverage = ratesSize == 0 ? 0 : rateAverage / ratesSize;

        BookDetailsResponse response = new BookDetailsResponse(book, rateAverage, myRateValue, reviewsResponse, isRateByMe, isReviewByMe);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/status")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> setBookStatusForUser(@RequestBody UserBookRequest userBookRequest, Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not exist"));

        Book book = bookRepository.findById(userBookRequest.getBookId()).orElseThrow(() -> new UsernameNotFoundException("Book not exist"));

        Optional<UserBook> userBook = userBookRepository.findByUserAndBook(user, book);

        if(userBook.isPresent()) {
            userBook.get().setStatus(userBookRequest.getStatus());
            userBookRepository.save(userBook.get());
            return ResponseEntity.ok(new UserBookResponse(userBook.get().getBook().getTitle(), userBook.get().getStatus()));
        }

        UserBook newUserBook = new UserBook(user, book, userBookRequest.getStatus());
        userBookRepository.save(newUserBook);

        return ResponseEntity.ok(new UserBookResponse(newUserBook.getBook().getTitle(), newUserBook.getStatus()));
    }

    @GetMapping("/my_books")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getUserBooks(Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not exist"));

        List<BookResponse> response = new ArrayList<>();
        List<UserBook> userBooks = userBookRepository.findAllByUser(user);
        List<UserBook> userBooks2 = userBookRepository.findAll();
        for(UserBook book : userBooks) {
            response.add(new BookResponse(book.getBook().getId(), book.getBook().getTitle(),book.getBook().getAuthor()));
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add_rate")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> addBookRate(@RequestBody RateRequest request, Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not exist"));
        Book book = bookRepository.findById(request.getBookId()).orElseThrow(() -> new UsernameNotFoundException("Book not exist"));

        BookRate rate = new BookRate(user, book, request.getRate());
        bookRateRepository.save(rate);
        return ResponseEntity.ok(new MessageResponse("Rate has been added"));
    }

    @PostMapping("/add_review")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> addBookRate(@RequestBody ReviewRequest request, Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not exist"));
        Book book = bookRepository.findById(request.getBookId()).orElseThrow(() -> new UsernameNotFoundException("Book not exist"));

        BookReview review = new BookReview(user, book, request.getReview());
        bookReviewRepository.save(review);
        return ResponseEntity.ok(new MessageResponse("Review has been added"));
    }
}
