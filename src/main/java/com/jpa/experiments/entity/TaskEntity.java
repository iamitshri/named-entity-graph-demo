package com.jpa.experiments.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Data
@Table(name = "task")
@NamedEntityGraph(name = "task.aspects",
        attributeNodes = {@NamedAttributeNode(value = "aspects", subgraph = "task.aspects.anchors")},
        subgraphs = {@NamedSubgraph(name = "task.aspects.anchors",attributeNodes = {@NamedAttributeNode("anchors")})})
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    int taskId;

    String taskName;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "task")
    List<AspectEntity> aspects = new ArrayList<>();
}
