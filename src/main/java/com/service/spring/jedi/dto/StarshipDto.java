package com.service.spring.jedi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author vyshor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarshipDto {
    private String name;
0
    @JsonProperty("class")
    private String starshipClass;

    private String model;
}
