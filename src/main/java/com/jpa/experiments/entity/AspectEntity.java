package com.jpa.experiments.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Data
@Table(name = "aspects")
public class AspectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aspect_id")
    int aspectId;

    String aspectName;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "aspect")
    Set<AnchorEntity> anchors = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    TaskEntity task;
}
