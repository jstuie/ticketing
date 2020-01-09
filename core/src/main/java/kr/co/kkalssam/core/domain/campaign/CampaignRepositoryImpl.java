//package kr.co.admerce.core.domain.campaign;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import static kr.co.admerce.core.domain.campaign.QCampaign.campaign;
//import java.util.List;
//
///**
// * Created by jslim@genieworks.net on 09/04/2019
// */
//@RequiredArgsConstructor
//public class CampaignRepositoryImpl implements CampaignRepositoryCustom{
//
//
//    private final JPAQueryFactory queryFactory;
//
//    @Override
//    public List<Campaign> findByCampaignKey(Integer campaignKey) {
//        return queryFactory.selectFrom(campaign)
//                .where(campaign.campaignKey.eq(campaignKey))
//                .fetch();
//    }
//}
