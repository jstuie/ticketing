package kr.co.kkalssam.core.domain.ticket;

import lombok.Builder;
import lombok.Data;

/**
 * Created by jslim on 2020/01/10.
 */
@Data
@Builder
public class ActorTicketDto {
    String name;
    Integer cnt;

}
