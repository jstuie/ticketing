//package kr.co.kkalssam.core.domain.campaign;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//import static kr.co.admerce.core.domain.campaign.QCampaign.campaign;
//
///**
// * Created by jslim@genieworks.net on 09/04/2019
// */
//@Repository
//public class CampaignRepositorySupport extends QuerydslRepositorySupport {
//
//    private final JPAQueryFactory queryFactory;
//
//
//    public CampaignRepositorySupport(JPAQueryFactory queryFactory) {
//        super(Campaign.class);
//        this.queryFactory = queryFactory;
//    }
//
//
//    public List<Campaign> findByCampaignKey(Integer campaignKey) {
//        return queryFactory.selectFrom(campaign)
//                .where(campaign.campaignKey.eq(campaignKey))
//                .fetch();
//    }
//}
