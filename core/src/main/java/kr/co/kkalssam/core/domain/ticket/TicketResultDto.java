package kr.co.kkalssam.core.domain.ticket;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by jslim on 2020/01/10.
 */
@Data
public class TicketResultDto {

    List<TicketDto> data;


}
