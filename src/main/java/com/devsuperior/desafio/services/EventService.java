package com.devsuperior.desafio.services;

import com.devsuperior.desafio.dto.EventDTO;
import com.devsuperior.desafio.entities.Event;
import com.devsuperior.desafio.repositories.CityRepository;
import com.devsuperior.desafio.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public Page<EventDTO> findAll(Pageable pageable) {
        Page<Event> page = eventRepository.findAll(pageable);
        return page.map(EventDTO::new);
    }

    @Transactional
    public EventDTO insert(EventDTO dto) {
        Event entity = new Event();
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        entity.setCity(cityRepository.getReferenceById(dto.getCityId()));
        entity = eventRepository.save(entity);
        return new EventDTO(entity);
    }

}
