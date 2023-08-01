package com.service.spring.jedi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformationDto {

    private StarshipDto starship;

    private Number crew;

    private Boolean isLeiaOnPlanet;
}
