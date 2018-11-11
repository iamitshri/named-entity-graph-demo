package com.jpa.experiments.repository;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.jpa.experiments.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    
    @Query("select task from TaskEntity task join fetch task.aspects aspects")
    List<TaskEntity> findAllTasksInnerJoin();
    
    
    @EntityGraph(value="task.aspects")
    List<TaskEntity> findAll();
    
    @EntityGraph(attributePaths= {"aspects"})
    List<TaskEntity> findByTaskIdNotNull();
}

