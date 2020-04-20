package org.picstories.api.controller;

import lombok.RequiredArgsConstructor;
import org.picstories.api.service.ComicsService;
import org.picstories.library.model.dto.ComicsDto;
import org.picstories.library.model.dto.PageDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author arman.shamenov
 */
@RestController
@RequestMapping("/api/comics")
@RequiredArgsConstructor
public class ComicsController {
    private final ComicsService service;

    @GetMapping
    public Flux<ComicsDto> getComics(Pageable pageable) {
        return service.getTopComics(pageable);
    }

    @GetMapping("/{comicId}/pages")
    public Flux<PageDto> getPages(@PathVariable String comicId, Pageable pageable) {
        return service.getPages(comicId, pageable);
    }

    @GetMapping("/{id}")
    public Mono<ComicsDto> getComicById(@PathVariable String id) {
        return service.getComicById(id);
    }

    @GetMapping("/{comicId}/pages/{number}")
    public Mono<PageDto> getPage(@PathVariable String comicId,
                                 @PathVariable int number) {
        return service.getPage(comicId, number);
    }
}
