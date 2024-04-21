package com.ticket.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseDTO {
    private String accountNo;
    private List<SeatDTO> seatDTO;
    private String concertCode;
    private String sessionCode;
}
