package com.ticket.system.service;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.ticket.system.dto.AccountDTO;
import com.ticket.system.dto.ConcertDTO;
import com.ticket.system.entity.Account;
import com.ticket.system.entity.Concert;
import com.ticket.system.repository.AccountRepository;
import com.ticket.system.repository.ConcertRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ConcertServiceTest {
    @Mock
    private ConcertRepository concertRepository;

    @InjectMocks
    private ConcertService concertService;
    private Concert concert;

    @BeforeEach
    public void setup() {
        concert = Concert.builder()
                .code("abc")
                .id("abc")
                .country("abc")
                .title("abc")
                .endTime("2024-04-21T12:12:12")
                .createdOn(new Date())
                .modifiedOn(new Date())
                .location("HK")
                .district("Kowloon")
                .startTime("2024-04-21T12:12:12").build();
    }

    @DisplayName("Found concert by code")
    @Test
    void test_getConcertByCode_found() {
        given(concertRepository.findTop1ByCode(concert.getCode()))
                .willReturn(Arrays.asList(concert));
        ConcertDTO concertDTO = concertService.getConcertByCode(concert.getCode());
        assertThat(concertDTO).isNotNull();
    }

    @DisplayName("Not found concert by code")
    @Test
    void test_getConcertByCode_not_found() {
        given(concertRepository.findTop1ByCode(concert.getCode()))
                .willReturn(Arrays.asList());
        ConcertDTO concertDTO = concertService.getConcertByCode(concert.getCode());
        assertThat(concertDTO).isNull();
    }

    @DisplayName("Repository layer exception")
    @Test
    void test_getConcertByCode_exception() {
        when(concertRepository.findTop1ByCode(eq(concert.getCode())))
                .thenThrow();
        ConcertDTO concertDTO = concertService.getConcertByCode(concert.getCode());
        assertThat(concertDTO).isNull();
    }
}
