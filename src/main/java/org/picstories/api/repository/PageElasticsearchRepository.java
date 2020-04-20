package org.picstories.api.repository;

import org.picstories.library.model.entity.page.PageED;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author arman.shamenov
 */
@Repository
public interface PageElasticsearchRepository extends ReactiveElasticsearchRepository<PageED, String> {
    Flux<PageED> findByComicId(String comicId, Pageable pageable);

    Mono<PageED> findByComicIdAndNumber(String comicId, int number);
}
