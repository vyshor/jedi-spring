package com.service.spring.jedi.service;

import com.service.spring.jedi.dto.InformationDto;
import com.service.spring.jedi.dto.StarshipDto;
import org.springframework.stereotype.Service;

@Service
public interface JediService {
    StarshipDto getDarthVaderStarship();

    Number getCrewsOnDeathStar();

    Boolean isLeiaOnAlderaan();

    InformationDto getInformation();
}
