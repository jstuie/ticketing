package kr.co.kkalssam.core.domain.ticket;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jslim on 2020/01/06.
 */
@Entity
@Data
@Table
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketKey")
    private Integer ticketKey;

    @Column(name = "Name")
    private String name;

    @Column(name = "Episode")
    private Integer episode;

    @Column(name = "Mobile")
    private String mobile;

    @Column(name = "Number")
    private Integer number;

    @Column(name = "ActorKey")
    private Integer actorKey;

    @Column(name = "WhenCreated")
    private Date whenCreated;

    @Column(name = "WhenModified")
    private Date whenModified;

    @Column(name = "Message")
    private String message;
}
