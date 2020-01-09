package kr.co.kkalssam.core.domain.ticket;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jslim on 2020/01/06.
 */
public interface TicketRepository extends CrudRepository<Ticket,Integer> {

    Integer countByEpisode(Integer episode);
}
