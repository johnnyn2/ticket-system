package com.ticket.system.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseResultDTO {
    private List<TicketDTO> tickets;
}
