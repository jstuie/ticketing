package kr.co.kkalssam.admin.api;

import kr.co.kkalssam.core.domain.ticket.DashboadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jslim on 2020/01/07.
 */
@RestController
@RequestMapping(value = "/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboadService dashboadService;

    @GetMapping("/info")
    public List<Integer> getTicketingInfo(){
        return dashboadService.getNumberByEpisode();
    }
    @GetMapping("/day")
    public List<Integer> getTicketingInfoByDay(){
        return dashboadService.getNumberEpisodeByDay();
    }
}
