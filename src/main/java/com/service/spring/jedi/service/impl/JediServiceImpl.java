package com.service.spring.jedi.service.impl;

import com.service.spring.jedi.dto.*;
import com.service.spring.jedi.exception.NoItemFoundException;
import com.service.spring.jedi.service.CacheService;
import com.service.spring.jedi.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.service.spring.jedi.constant.JediConstants.*;

@Service
public class JediServiceImpl implements JediService {

    @Autowired
    private CacheService cacheService;

    @Override
    public StarshipDto getDarthVaderStarship() {
        PersonProxyDto personProxyDto;
        try {
            personProxyDto = cacheService.getPersonProxyDtoByName(DARTH_VADER_PERSON_NAME);
        } catch (NoItemFoundException e) {
            return null;
        }

        if (personProxyDto.getStarshipUrls().isEmpty()) {
            return null;
        }

        String starshipUrl = personProxyDto.getStarshipUrls().get(0);
        String[] subUrls = starshipUrl.split("/", -1);
        String id = subUrls[subUrls.length-2];

        StarshipProxyDto starshipProxyDto = cacheService.getStarshipProxyDtoById(id);
        if (starshipProxyDto == null) {
            return null;
        }

        StarshipDto starshipDto = new StarshipDto();
        starshipDto.setName(starshipProxyDto.getName());
        starshipDto.setModel(starshipProxyDto.getModel());
        starshipDto.setStarshipClass(starshipProxyDto.getStarshipClass());

        return starshipDto;
    }

    @Override
    public Long getCrewsOnDeathStar() {
        StarshipProxyDto starshipProxyDto;
        try {
            starshipProxyDto = cacheService.getStarshipProxyDtoByName(DEATH_STAR_STARSHIP_NAME);
        } catch (NoItemFoundException e) {
            return null;
        }

        return Long.parseLong(starshipProxyDto.getCrew().replaceAll(",", ""));
    }

    @Override
    public Boolean isLeiaOnAlderaan() {
        PlanetProxyDto planetProxyDto;
        try {
            planetProxyDto = cacheService.getPlanetProxyDtoByName(ALDERAAN_PLANET_NAME);
        } catch (NoItemFoundException e) {
            return null;
        }

        boolean leiaOnPlanet = false;
        for (String residentUrl : planetProxyDto.getResidentUrls()) {
            String[] subUrls = residentUrl.split("/", -1);
            String id = subUrls[subUrls.length-2];

            PersonProxyDto personProxyDto = cacheService.getPersonProxyDtoById(id);
            if (personProxyDto == null) return null;

            if (personProxyDto.getName().equals(LEIA_ORGANA_PERSON_NAME)) {
                leiaOnPlanet = true;
                break;
            }
        }

        return leiaOnPlanet;
    }

    @Override
    public InformationDto getInformation() {
        StarshipDto starshipDto = getDarthVaderStarship();
        Long crews = getCrewsOnDeathStar();
        Boolean leiaOnAlderaan = isLeiaOnAlderaan();

        InformationDto informationDto = new InformationDto();
        informationDto.setStarship(starshipDto);
        informationDto.setCrew(crews);
        informationDto.setIsLeiaOnPlanet(leiaOnAlderaan);

        return informationDto;
    }
}
