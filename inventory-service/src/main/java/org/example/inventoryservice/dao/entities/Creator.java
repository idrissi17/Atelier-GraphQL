package org.example.inventoryservice.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Creator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer creatorId;
    private String name;
    private String email;
    @OneToMany(mappedBy = "creator")
    private Collection<Video> videos=new ArrayList<>();
}
