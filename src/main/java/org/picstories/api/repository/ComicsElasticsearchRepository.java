package org.picstories.api.repository;

import org.picstories.library.model.entity.comics.ComicsED;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author arman.shamenov
 */
@Repository
public interface ComicsElasticsearchRepository extends ReactiveElasticsearchRepository<ComicsED, String> {
    Flux<ComicsED> findAllBy(Pageable pageable);
}
