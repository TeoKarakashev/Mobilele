package com.example.mobilele.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{
    private String name;

}
