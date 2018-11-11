package com.jpa.experiments.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "anchors")
@Data
public class AnchorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int anchorId;

    String anchorName;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "aspect_id", referencedColumnName = "aspect_id")
    AspectEntity aspect;
}
