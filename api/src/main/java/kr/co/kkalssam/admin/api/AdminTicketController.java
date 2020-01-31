package kr.co.kkalssam.admin.api;

import kr.co.kkalssam.core.domain.ticket.MMS;
import kr.co.kkalssam.core.domain.ticket.SmsService;
import kr.co.kkalssam.core.domain.ticket.Ticket;
import kr.co.kkalssam.core.domain.ticket.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jslim on 2020/01/07.
 */
@RestController
@RequestMapping(value = "/table")
@RequiredArgsConstructor
public class AdminTicketController {

    private final TicketRepository ticketRepository;
    private final SmsService smsService;
    @PostMapping
    public void ticketing(@RequestBody Ticket ticket){

        ticketRepository.save(ticket);
    }

    @PutMapping
    public void putTicketing(@RequestBody Ticket ticket){

        ticketRepository.save(ticket);
    }

    @DeleteMapping("/{ticketKey}")
    public void deleteTicketing(@PathVariable Integer ticketKey){

        Ticket ticket = ticketRepository.findById(ticketKey).orElse(null);
        if(ticket != null) {
            ticketRepository.delete(ticket);
        }
    }




}
