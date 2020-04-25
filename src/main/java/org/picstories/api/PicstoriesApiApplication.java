package org.picstories.api;

import org.picstories.library.mongodb.ReactiveMongoDbConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author arman.shamenov
 */
@SpringBootApplication(exclude = ReactiveMongoDbConfiguration.class)
@EntityScan({
        "org.picstories.library.model.entity"
})
public class PicstoriesApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PicstoriesApiApplication.class, args);
    }
}
