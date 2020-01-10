package kr.co.kkalssam.admin.api;

import kr.co.kkalssam.core.domain.ticket.Ticket;
import kr.co.kkalssam.core.domain.ticket.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jslim on 2020/01/07.
 */
@RestController
@RequestMapping(value = "/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketRepository ticketRepository;

    @PostMapping
    public void ticketing(@RequestBody Ticket ticket){

        ticketRepository.save(ticket);
    }


}
