package ru.itis.pethome.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Image extends AbstractEntity{
    private String oldName;
    private String type;
    private Integer weight;
    private String path;
}
