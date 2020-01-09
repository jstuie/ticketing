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
        list.add(ticketRepository.countByEpisode(1));
        list.add(ticketRepository.countByEpisode(2));
        list.add(ticketRepository.countByEpisode(3));
        list.add(ticketRepository.countByEpisode(4));

        return list;
    }


}
