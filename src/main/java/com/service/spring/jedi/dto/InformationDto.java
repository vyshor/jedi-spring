package com.service.spring.jedi.dto;

import lombok.*;
/**
 * @author  vyshor
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformationDto {

    private StarshipDto starship;

    private int crew;

    private boolean isLeiaOnPlanet;
}
