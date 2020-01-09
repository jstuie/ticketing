package kr.co.kkalssam.core.domain.ticket;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jslim on 2020/01/06.
 */
public interface ActorRepository extends CrudRepository<Actor,Integer> {

    Actor findByUsername(String username);
}
