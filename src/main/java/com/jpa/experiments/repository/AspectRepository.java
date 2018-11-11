package com.jpa.experiments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpa.experiments.entity.AspectEntity;

public interface AspectRepository extends JpaRepository<AspectEntity, Integer> {

}
