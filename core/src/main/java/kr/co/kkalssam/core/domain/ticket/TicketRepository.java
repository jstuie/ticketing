package kr.co.kkalssam.core.domain.ticket;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jslim on 2020/01/06.
 */
public interface TicketRepository extends CrudRepository<Ticket,Integer> {

    List<Ticket> findByEpisode(Integer episode);
    List<Ticket> findAll();

    @Query("select sum(t.number) " +
            "from Ticket t " +
            "where t.actorKey LIKE CONCAT('%', :actor, '%') ")
    Integer sumByActorKeyLike(String actor);
}
