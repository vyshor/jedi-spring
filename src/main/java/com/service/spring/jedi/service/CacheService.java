package com.service.spring.jedi.service;

import com.service.spring.jedi.dto.PersonProxyDto;
import com.service.spring.jedi.dto.PlanetProxyDto;
import com.service.spring.jedi.dto.StarshipProxyDto;
import com.service.spring.jedi.exception.NoItemFoundException;
import com.service.spring.jedi.response.SearchResponseBody;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Service
public interface CacheService {

    StarshipProxyDto getStarshipProxyDtoByName(String name) throws NoItemFoundException;

    PlanetProxyDto getPlanetProxyDtoByName(String name) throws NoItemFoundException;

    PersonProxyDto getPersonProxyDtoByName(String name) throws NoItemFoundException;

    PersonProxyDto getPersonProxyDtoById(String id);

    StarshipProxyDto getStarshipProxyDtoById(String id);
}
