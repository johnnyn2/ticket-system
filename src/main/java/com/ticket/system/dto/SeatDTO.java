package com.ticket.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {
    private String concertCode;
    private String sessionCode;
    private Stage stage;
    private int seatNo;
    public enum Stage {
        A, B, C, D
    }
}
