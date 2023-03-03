package org.munozy.arkadialibrarybo.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.munozy.arkadialibrarybo.client.ArkadiaLibraryClient;
import org.munozy.arkadialibrarybo.dto.BookDTO;
import org.munozy.arkadialibrarybo.dto.PostBookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Book;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Validated
@RestController
@RequestMapping(BooksController.PATH)
@AllArgsConstructor
public class BooksController {
    protected static final String PATH = "/arkadia-library/bo/v1/books";

    private final ArkadiaLibraryClient arkadiaLibraryClient;

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public Flux<BookDTO> getBooks() {
        return arkadiaLibraryClient.allBooks();
    }

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Mono<BookDTO> insertBook(@RequestBody PostBookDTO postBookDTO) {
        return arkadiaLibraryClient.createNewBook(postBookDTO);
    }
}
