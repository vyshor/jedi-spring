package com.service.spring.jedi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vyshor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarshipProxyDto {
    private String name;

    @JsonProperty("starship_class")
    private String starshipClass;

    private String model;

    private String crew;
}
