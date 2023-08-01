package com.service.spring.jedi.controller;

import com.service.spring.jedi.dto.InformationDto;
import com.service.spring.jedi.service.JediService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationController {

    @Autowired
    private JediService jediService;

    @ApiOperation(value = "Get information as a Jedi Master")
    @GetMapping(value = "/information", produces = MediaType.APPLICATION_JSON_VALUE)
    public InformationDto getInformation() {
        return jediService.getInformation();
    }
}
