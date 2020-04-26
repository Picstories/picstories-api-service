package org.picstories.api.service;

import org.picstories.library.mapper.PicstoriesMapper;
import org.picstories.library.model.dto.ComicsDto;
import org.picstories.library.model.dto.PageDto;
import org.picstories.library.repository.elasticsearch.ComicsElasticsearchRepository;
import org.picstories.library.repository.elasticsearch.PageElasticsearchRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author arman.shamenov
 */
@Service
public class ComicsService {
    private final ComicsElasticsearchRepository comicsElasticsearchRepository;
    private final PageElasticsearchRepository pageElasticsearchRepository;
    private final PicstoriesMapper picstoriesMapper;

    public ComicsService(ComicsElasticsearchRepository comicsElasticsearchRepository,
                         PageElasticsearchRepository pageElasticsearchRepository,
                         PicstoriesMapper picstoriesMapper) {
        this.comicsElasticsearchRepository = comicsElasticsearchRepository;
        this.pageElasticsearchRepository = pageElasticsearchRepository;
        this.picstoriesMapper = picstoriesMapper;
    }

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
