package com.noor.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="api_data")
public class ApiDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("API")
    private String apiName;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("Auth")
    private String Auth;
    @JsonProperty("HTTPS")
    private String HTTPS;
    @JsonProperty("Cors")
    private String Cors;
    @JsonProperty("Link")
    private String Link;
    @JsonProperty("Category")
    private String Category;
 
}
