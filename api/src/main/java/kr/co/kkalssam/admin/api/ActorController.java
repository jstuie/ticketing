package kr.co.kkalssam.admin.api;

import kr.co.kkalssam.core.domain.ticket.Actor;
import kr.co.kkalssam.core.domain.ticket.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by jslim on 2020/01/07.
 */
@RestController
@RequestMapping(value = "/actor")
@RequiredArgsConstructor
public class ActorController {

    private final ActorRepository actorRepository;

    @Secured("ROLE_ACTOR")
    @GetMapping
    Actor me(Principal actor){
        String actorName = actor.getName();

        return actorRepository.findByUsername(actorName);
    }
}
