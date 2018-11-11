package com.jpa.experiments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpa.experiments.entity.AnchorEntity;

public interface AnchorRepository extends JpaRepository<AnchorEntity, Integer> {

}
