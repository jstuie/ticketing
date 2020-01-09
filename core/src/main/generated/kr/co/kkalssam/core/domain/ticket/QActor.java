package kr.co.kkalssam.core.domain.ticket;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QActor is a Querydsl query type for Actor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QActor extends EntityPathBase<Actor> {

    private static final long serialVersionUID = -1365026006L;

    public static final QActor actor = new QActor("actor");

    public final NumberPath<Integer> adminUserKey = createNumber("adminUserKey", Integer.class);

    public final EnumPath<kr.co.kkalssam.core.enumeration.YesOrNo> isEnable = createEnum("isEnable", kr.co.kkalssam.core.enumeration.YesOrNo.class);

    public final StringPath password = createString("password");

    public final StringPath username = createString("username");

    public final StringPath userRole = createString("userRole");

    public QActor(String variable) {
        super(Actor.class, forVariable(variable));
    }

    public QActor(Path<? extends Actor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QActor(PathMetadata metadata) {
        super(Actor.class, metadata);
    }

}

