package com.ticket.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {
    private String ticktNo;
    private String purchaseRef;
    private String accountNo;
    private String firstName;
    private String lastName;
    private ConcertDTO concert;
    private SeatDTO seat;
}
