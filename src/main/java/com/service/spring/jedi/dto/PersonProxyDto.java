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
public class PersonProxyDto {

    private String name;

    @JsonProperty("starships")
    private List<String> starshipUrls;
}
