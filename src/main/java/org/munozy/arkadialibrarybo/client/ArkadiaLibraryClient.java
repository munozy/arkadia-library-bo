package org.munozy.arkadialibrarybo.client;

import org.munozy.arkadialibrarybo.dto.BookDTO;
import org.munozy.arkadialibrarybo.dto.PostBookDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ArkadiaLibraryClient {

    @GetExchange("/books")
    Flux<BookDTO> allBooks();

    @PostExchange("/books/")
    Mono<BookDTO> createNewBook(@RequestBody PostBookDTO postBookDTO);
}
