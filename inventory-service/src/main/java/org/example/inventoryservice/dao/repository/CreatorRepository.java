package org.example.inventoryservice.dao.repository;

import org.example.inventoryservice.dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Integer> {
}
