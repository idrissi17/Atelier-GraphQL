package org.example.inventoryservice;

import org.example.inventoryservice.dao.entities.Creator;
import org.example.inventoryservice.dao.entities.Video;
import org.example.inventoryservice.dao.repository.CreatorRepository;
import org.example.inventoryservice.dao.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository){
        return args -> {

            List<Creator> creators = Stream.iterate(1, i -> i + 1)
                    .limit(5)
                    .map(i -> Creator.builder()
                            .creatorId(i)
                            .name("Creator " + i)
                            .email("creator" + i + "@example.com")
                            .build())
                    .toList();
            creatorRepository.saveAll(creators);

            List<Video> videos = Stream.iterate(1, i -> i + 1)
                    .limit(10)
                    .map(i -> Video.builder()
                            .title("Video " + i)
                            .description("Description " + i)
                            .url("https://example.com/video" + i)
                            .publishedDate(LocalDateTime.now())
                            .creator(creators.get(i % 5))
                            .build())
                    .toList();

            videoRepository.saveAll(videos);
        };
    }

}
