package com.example.mobilele.Model.Entities;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Instant created;
    @Column(nullable = false)
    private Instant modified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @PrePersist
    public void prePersist(){
        setCreated(Instant.now());
        setModified(Instant.now());
    }

    @PreUpdate
    public void preUpdate(){
        setCreated(Instant.now());
        setModified(Instant.now());
    }
    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }
}
