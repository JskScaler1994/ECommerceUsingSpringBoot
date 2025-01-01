package com.example.productservice.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.util.Date;

/* Serializable is implemented as part of the cache implementation.
*  It helps in converting the java object into the format we want to store in cache
*  In this case it is string. It will handle both serialization and deserialization */

@Getter
@Setter
@MappedSuperclass
public class BaseModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date created_at;
    private Date updated_at;
    private boolean is_deleted;
}
