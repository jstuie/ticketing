package kr.co.kkalssam.admin.api;

import kr.co.kkalssam.core.domain.ticket.*;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jslim on 2020/01/07.
 */
@RestController
@RequestMapping(value = "/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboadService dashboadService;
    private final ActorRepository actorRepository;
    private final TicketRepository ticketRepository;

    @GetMapping("/info")
    public List<Integer> getTicketingInfo() {
        return dashboadService.getNumberByEpisode();
    }
    @GetMapping("/actor")
    public List<ActorTicketDto> getTicketingInfoByDay(){

        List<ActorTicketDto> actorTicketDtoList = new ArrayList<>();
        actorTicketDtoList.add(ActorTicketDto.builder().name("방현지").cnt(ticketRepository.sumByActorKeyLike("방현지")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("윤여정").cnt(ticketRepository.sumByActorKeyLike("윤여정")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("곽영준").cnt(ticketRepository.sumByActorKeyLike("곽영준")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("장동훈").cnt(ticketRepository.sumByActorKeyLike("장동훈")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("변주영").cnt(ticketRepository.sumByActorKeyLike("변주영")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("임윤진").cnt(ticketRepository.sumByActorKeyLike("임윤진")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("강우영").cnt(ticketRepository.sumByActorKeyLike("강우영")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("한영훈").cnt(ticketRepository.sumByActorKeyLike("한영훈")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("안성현").cnt(ticketRepository.sumByActorKeyLike("안성현")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("이고은").cnt(ticketRepository.sumByActorKeyLike("이고은")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("김태현").cnt(ticketRepository.sumByActorKeyLike("김태현")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("이준원").cnt(ticketRepository.sumByActorKeyLike("이준원")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("김정민").cnt(ticketRepository.sumByActorKeyLike("김정민")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("정윤경").cnt(ticketRepository.sumByActorKeyLike("정윤경")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("김하영").cnt(ticketRepository.sumByActorKeyLike("김하영")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("석정웅").cnt(ticketRepository.sumByActorKeyLike("석정웅")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("이연주").cnt(ticketRepository.sumByActorKeyLike("이연주")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("이재은").cnt(ticketRepository.sumByActorKeyLike("이재은")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("송혜진").cnt(ticketRepository.sumByActorKeyLike("송혜진")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("이정수").cnt(ticketRepository.sumByActorKeyLike("이정수")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("이호영").cnt(ticketRepository.sumByActorKeyLike("이호영")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("정민재").cnt(ticketRepository.sumByActorKeyLike("정민재")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("김원호").cnt(ticketRepository.sumByActorKeyLike("김원호")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("문인호").cnt(ticketRepository.sumByActorKeyLike("문인호")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("배경민").cnt(ticketRepository.sumByActorKeyLike("배경민")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("임재성").cnt(ticketRepository.sumByActorKeyLike("임재성")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("장기연").cnt(ticketRepository.sumByActorKeyLike("장기연")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("김성현").cnt(ticketRepository.sumByActorKeyLike("김성현")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("김지응").cnt(ticketRepository.sumByActorKeyLike("김지응")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("김보람").cnt(ticketRepository.sumByActorKeyLike("김보람")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("양수정").cnt(ticketRepository.sumByActorKeyLike("양수정")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("이다혜").cnt(ticketRepository.sumByActorKeyLike("이다혜")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("이화진").cnt(ticketRepository.sumByActorKeyLike("이화진")).build());
        actorTicketDtoList.add(ActorTicketDto.builder().name("장남영").cnt(ticketRepository.sumByActorKeyLike("장남영")).build());

        return actorTicketDtoList;
    }

    @GetMapping("/ticketing")
    public TicketDto ticketing() {
        List<Ticket> ticketList = ticketRepository.findAll();

        TicketDto ticketDto = new TicketDto();
        List<String[]> rtnList = new ArrayList<>();
        for (Ticket ticket : ticketList) {

            String[] rtn = new String[6];

            rtn[0] = ticket.getName();
            rtn[1] = ticket.getEpisode() + "회차";
            rtn[2] = ticket.getMobile();
            rtn[3] = ticket.getNumber() + "명";
            rtn[4] = ticket.getActorKey();

            SimpleDateFormat yyyyMMddhhmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            rtn[5] = yyyyMMddhhmmss.format(ticket.getWhenCreated());

            rtnList.add(rtn);


        }
        ticketDto.setData(rtnList);

        return ticketDto;

    }


    String getActorName(String actorNumber) {
        String name = "";

        if ("1".equals(actorNumber)) {
            name = "방현지";
        } else if ("2".equals(actorNumber)) {
            name = "윤여정";
        } else if ("3".equals(actorNumber)) {
            name = "곽영준";
        } else if ("4".equals(actorNumber)) {
            name = "장동훈";
        } else if ("5".equals(actorNumber)) {
            name = "변주영";
        } else if ("6".equals(actorNumber)) {
            name = "임윤진";
        } else if ("7".equals(actorNumber)) {
            name = "강우영";
        } else if ("8".equals(actorNumber)) {
            name = "한영훈";
        } else if ("9".equals(actorNumber)) {
            name = "안성현";
        } else if ("10".equals(actorNumber)) {
            name = "이고은";
        } else if ("11".equals(actorNumber)) {
            name = "김태현";
        } else if ("12".equals(actorNumber)) {
            name = "이준원";
        } else if ("13".equals(actorNumber)) {
            name = "김정민";
        } else if ("14".equals(actorNumber)) {
            name = "정윤경";
        } else if ("15".equals(actorNumber)) {
            name = "김하영";
        } else if ("16".equals(actorNumber)) {
            name = "석정웅";
        } else if ("17".equals(actorNumber)) {
            name = "이연주";
        } else if ("18".equals(actorNumber)) {
            name = "이재은";
        } else if ("19".equals(actorNumber)) {
            name = "송혜진";
        } else if ("20".equals(actorNumber)) {
            name = "이정수";
        } else if ("21".equals(actorNumber)) {
            name = "이호영";
        } else if ("22".equals(actorNumber)) {
            name = "정민재";
        } else if ("23".equals(actorNumber)) {
            name = "김원호";
        } else if ("24".equals(actorNumber)) {
            name = "문인호";
        } else if ("25".equals(actorNumber)) {
            name = "배경민";
        } else if ("26".equals(actorNumber)) {
            name = "임재성";
        } else if ("27".equals(actorNumber)) {
            name = "장기연";
        } else if ("28".equals(actorNumber)) {
            name = "김성현";
        } else if ("29".equals(actorNumber)) {
            name = "김지응";
        } else if ("30".equals(actorNumber)) {
            name = "김보람";
        } else if ("31".equals(actorNumber)) {
            name = "양수정";
        } else if ("32".equals(actorNumber)) {
            name = "이다혜";
        } else if ("33".equals(actorNumber)) {
            name = "이화진";
        } else if ("34".equals(actorNumber)) {
            name = "장남영";
        }
        return name;
    }
}
