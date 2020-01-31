package kr.co.kkalssam.core.domain.ticket;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTicket is a Querydsl query type for Ticket
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTicket extends EntityPathBase<Ticket> {

    private static final long serialVersionUID = 1182851191L;

    public static final QTicket ticket = new QTicket("ticket");

    public final StringPath actorKey = createString("actorKey");

    public final NumberPath<Integer> episode = createNumber("episode", Integer.class);

    public final StringPath message = createString("message");

    public final StringPath mobile = createString("mobile");

    public final StringPath modifyActor = createString("modifyActor");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> number = createNumber("number", Integer.class);

    public final NumberPath<Integer> ticketKey = createNumber("ticketKey", Integer.class);

    public final DateTimePath<java.util.Date> whenCreated = createDateTime("whenCreated", java.util.Date.class);

    public final DateTimePath<java.util.Date> whenModified = createDateTime("whenModified", java.util.Date.class);

    public QTicket(String variable) {
        super(Ticket.class, forVariable(variable));
    }

    public QTicket(Path<? extends Ticket> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTicket(PathMetadata metadata) {
        super(Ticket.class, metadata);
    }

}

