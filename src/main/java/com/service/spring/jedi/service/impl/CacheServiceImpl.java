package com.service.spring.jedi.service.impl;

import com.service.spring.jedi.dto.PersonProxyDto;
import com.service.spring.jedi.dto.PlanetProxyDto;
import com.service.spring.jedi.dto.StarshipProxyDto;
import com.service.spring.jedi.exception.NoItemFoundException;
import com.service.spring.jedi.response.SearchResponseBody;
import com.service.spring.jedi.service.CacheService;
import com.service.spring.jedi.service.proxy.StarWarsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private StarWarsProxy starWarsProxy;

    @Override
    @Cacheable(value = "starshipName")
    public StarshipProxyDto getStarshipProxyDtoByName(String name) throws NoItemFoundException {
        SearchResponseBody<List<StarshipProxyDto>> response = starWarsProxy.getStarshipProxyDtosByName(name);
        if (response.getResults().isEmpty()) {
            throw new NoItemFoundException();
        }
        return response.getResults().get(0);
    }

    @Override
    @Cacheable(value = "planetName")
    public PlanetProxyDto getPlanetProxyDtoByName(String name) throws NoItemFoundException {
        SearchResponseBody<List<PlanetProxyDto>> response = starWarsProxy.getPlanetProxyDtosByName(name);
        if (response.getResults().isEmpty()) {
            throw new NoItemFoundException();
        }
        return response.getResults().get(0);
    }

    @Override
    @Cacheable(value = "personName")
    public PersonProxyDto getPersonProxyDtoByName(String name) throws NoItemFoundException {
        SearchResponseBody<List<PersonProxyDto>> response = starWarsProxy.getPersonProxyDtosByName(name);
        if (response.getResults().isEmpty()) {
            throw new NoItemFoundException();
        }
        return response.getResults().get(0);
    }

    @Override
    @Cacheable(value = "personId")
    public PersonProxyDto getPersonProxyDtoById(String id) {
        Optional<PersonProxyDto> response = starWarsProxy.getPersonProxyDtoById(id);
        return response.orElse(null);
    }

    @Override
    @Cacheable(value = "starshipId")
    public StarshipProxyDto getStarshipProxyDtoById(String id) {
        Optional<StarshipProxyDto> response = starWarsProxy.getStarshipProxyDtoById(id);
        return response.orElse(null);
    }
}
