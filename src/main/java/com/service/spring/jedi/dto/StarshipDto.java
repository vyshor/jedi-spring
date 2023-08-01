package com.service.spring.jedi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarshipDto {
    private String name;

    @JsonProperty("class")
    private String starshipClass;

    private String model;
}
