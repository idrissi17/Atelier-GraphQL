package org.example.inventoryservice.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;
    private String title;
    private String description;
    private String url;
    private LocalDateTime publishedDate;
    @ManyToOne
    @JoinColumn(name = "creatorId")
    private Creator creator;

}
