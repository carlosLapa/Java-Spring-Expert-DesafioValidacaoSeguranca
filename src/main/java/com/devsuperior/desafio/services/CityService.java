package com.devsuperior.desafio.services;

import com.devsuperior.desafio.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
}
