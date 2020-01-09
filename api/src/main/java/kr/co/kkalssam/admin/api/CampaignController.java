package kr.co.kkalssam.admin.api;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import kr.co.kkalssam.core.domain.campaign.Campaign;
import kr.co.kkalssam.core.domain.campaign.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jslim@genieworks.net on 09/04/2019
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/campaigns")
public class CampaignController {

    private final CampaignRepository campaignRepository;

    @GetMapping
    Campaign test(){
        return  campaignRepository.findById(247).orElse(null);
    }
}
