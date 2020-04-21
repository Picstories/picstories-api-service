package org.picstories.api.configuration;

import org.picstories.library.elasticsearch.ReactiveElasticsearchConfiguration;
import org.picstories.library.mapper.PicstoriesMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author arman.shamenov
 */
@Configuration
@Import({
        ReactiveElasticsearchConfiguration.class
})
public class ApplicationConfiguration {

    @Bean
    public PicstoriesMapper mapper() {
        return new PicstoriesMapper();
    }
}
