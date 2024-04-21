package com.ticket.system.service;

import com.ticket.system.dto.ConcertDTO;
import com.ticket.system.entity.Concert;
import com.ticket.system.repository.ConcertRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ConcertService {
    @Autowired
    private ConcertRepository concertRepository;

    public ConcertDTO getConcertByCode(String code) {
        try {
            ConcertDTO concertDTO = new ConcertDTO();
            List<Concert> concerts = concertRepository.findTop1ByCode(code);
            if (concerts.size() > 0) {
                Concert concert = concerts.get(0);
                log.info("Found concert - title: " + concert.getTitle());
                BeanUtils.copyProperties(concert, concertDTO);
                return concertDTO;
            }
            log.info("Not found concert - code: " + code);
        } catch (Exception e) {
            log.error("Concert Repository exception");
            e.printStackTrace();
        }
        return null;
    }
}
