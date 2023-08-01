package com.service.spring.jedi.service.proxy;

import com.service.spring.jedi.dto.PersonProxyDto;
import com.service.spring.jedi.dto.PlanetProxyDto;
import com.service.spring.jedi.dto.StarshipProxyDto;
import com.service.spring.jedi.response.SearchResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * @author vyshor
 */
@FeignClient(name = "swapi", url = "https://swapi.dev/api/", decode404 = true)
public interface StarWarsProxy {

    @RequestMapping(value = "/starships", method = RequestMethod.GET)
    SearchResponseBody<List<StarshipProxyDto>> getStarshipProxyDtosByName(@RequestParam("search") String name);

    @RequestMapping(value = "/planets", method = RequestMethod.GET)
    SearchResponseBody<List<PlanetProxyDto>> getPlanetProxyDtosByName(@RequestParam("search") String name);

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    SearchResponseBody<List<PersonProxyDto>> getPersonProxyDtosByName(@RequestParam("search") String name);

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    Optional<PersonProxyDto> getPersonProxyDtoById(@PathVariable("id") String id);

    @RequestMapping(value = "/starships/{id}", method = RequestMethod.GET)
    Optional<StarshipProxyDto> getStarshipProxyDtoById(@PathVariable("id") String id);
}
