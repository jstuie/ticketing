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
@RequestMapping(value = "/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketRepository ticketRepository;
    private final SmsService smsService;
    @PostMapping
    public void ticketing(@RequestBody Ticket ticket){

        ticketRepository.save(ticket);
    }
    @PostMapping(value = "/mms",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void ticketing(@RequestBody MMS mms){

        smsService.sendSMS(mms,"","");
    }


}
