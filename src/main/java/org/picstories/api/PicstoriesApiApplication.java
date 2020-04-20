package org.picstories.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author arman.shamenov
 */
@SpringBootApplication
@EntityScan({
        "org.picstories.library.model.entity"
})
public class PicstoriesApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PicstoriesApiApplication.class, args);
    }
}
