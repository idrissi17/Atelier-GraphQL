package org.example.inventoryservice.web;

import org.example.inventoryservice.dao.entities.Creator;
import org.example.inventoryservice.dao.entities.Video;
import org.example.inventoryservice.dao.repository.CreatorRepository;
import org.example.inventoryservice.dao.repository.VideoRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;

    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }

    @QueryMapping
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @QueryMapping
    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }

    @QueryMapping
    public Creator creatorById(@Argument Integer customerId) {
        return creatorRepository.findById(customerId).
                orElseThrow(() -> new RuntimeException(String.format("Creator %s not found", customerId)));


    }

}
