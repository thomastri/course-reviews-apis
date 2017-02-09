package com.teamtreehouse.core;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;


    // Since BaseEntity is used by Courses and Reviews, having the
    // version declared here will by default extend to everything else
    @Version
    private Long version;

    protected BaseEntity() {
        id = null;
    }
}
