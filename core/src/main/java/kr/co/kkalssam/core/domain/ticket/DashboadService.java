package kr.co.kkalssam.core.domain.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jslim on 2020/01/07.
 */
@Service
@RequiredArgsConstructor
public class DashboadService {
    private final TicketRepository ticketRepository;

    public List<Integer> getNumberByEpisode(){

        List<Integer> list = new ArrayList<>();
        List<Ticket> ticketList1 = ticketRepository.findByEpisode(1);
        List<Ticket> ticketList2 = ticketRepository.findByEpisode(2);
        List<Ticket> ticketList3 = ticketRepository.findByEpisode(3);
        List<Ticket> ticketList4 = ticketRepository.findByEpisode(4);
        Integer ep1 = 0;
        Integer ep2 = 0;
        Integer ep3 = 0;
        Integer ep4 = 0;
        for(Ticket ticket : ticketList1){
             ep1 = Integer.sum(ep1,ticket.getNumber());
        }
        for(Ticket ticket : ticketList2){
            ep2 = Integer.sum(ep2,ticket.getNumber());
        }
        for(Ticket ticket : ticketList3){
            ep3 = Integer.sum(ep3,ticket.getNumber());
        }
        for(Ticket ticket : ticketList4){
            ep4 = Integer.sum(ep4,ticket.getNumber());
        }


        list.add(ep1);
        list.add(ep2);
        list.add(ep3);
        list.add(ep4);

        return list;
    }


}
