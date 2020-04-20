package org.picstories.api.service;

import lombok.RequiredArgsConstructor;
import org.picstories.api.repository.ComicsElasticsearchRepository;
import org.picstories.api.repository.PageElasticsearchRepository;
import org.picstories.library.mapper.PicstoriesMapper;
import org.picstories.library.model.dto.ComicsDto;
import org.picstories.library.model.dto.PageDto;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author arman.shamenov
 */
@Service
@RequiredArgsConstructor
public class ComicsService {
    private final ComicsElasticsearchRepository comicsElasticsearchRepository;
    private final PageElasticsearchRepository pageElasticsearchRepository;
    private final PicstoriesMapper picstoriesMapper;

    public Flux<ComicsDto> getTopComics(Pageable pageable) {
        return comicsElasticsearchRepository.findAllBy(pageable)
                .map(picstoriesMapper::toComicDTO);
    }


    public Mono<PageDto> getPage(String comicId, int number) {
        return pageElasticsearchRepository.findByComicIdAndNumber(comicId, number)
                .map(picstoriesMapper::toPageDTO);
    }

    public Mono<ComicsDto> getComicById(String id) {
        return comicsElasticsearchRepository.findById(id)
                .map(picstoriesMapper::toComicDTO);
    }

    public Flux<PageDto> getPages(String comicId, Pageable pageable) {
        return pageElasticsearchRepository.findByComicId(comicId, pageable)
                .map(picstoriesMapper::toPageDTO);
    }
}
