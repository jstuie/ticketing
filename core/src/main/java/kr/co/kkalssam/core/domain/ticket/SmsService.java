package kr.co.kkalssam.core.domain.ticket;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by jslim@genieworks.net on 18/12/2018
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SmsService {

    @Value("${aoa.send.message.id}")
    String id;

    @Value("${aoa.send.message.pwd}")
    String pwd;


    public void sendSMS(MMS mms, String sendNum, String receiveNum) {
        HashMap<String, String> actorMap = new HashMap <>();
        actorMap.put("방현지",	"01021627566");
        actorMap.put("윤여정",	"01032248410");
        actorMap.put("곽영준",	"01063874128");
        actorMap.put("장동훈",	"01028863751");
        actorMap.put("변주영",	"01056532021");
        actorMap.put("임윤진",	"01036674270");
        actorMap.put("강우영",	"01052509491");
        actorMap.put("한영훈",	"01041374179");
        actorMap.put("안성현",	"01092102789");
        actorMap.put("이고은",	"01099919426");
        actorMap.put("김태현",	"01066484242");
        actorMap.put("이준원",	"01055978483");
        actorMap.put("김정민",	"01097931987");
        actorMap.put("정윤경",	"01088477431");
        actorMap.put("김하영",	"01035856339");
        actorMap.put("석정웅",	"01095671182");
        actorMap.put("이연주",	"01071333285");
        actorMap.put("송혜진",	"01052757275");
        actorMap.put("이정수",	"01083234668");
        actorMap.put("이호영",	"01041701141");
        actorMap.put("정민재",	"01075702455");
        actorMap.put("김원호",	"01031515358");
        actorMap.put("문인호",	"01086012733");
        actorMap.put("배경민",	"01051625483");
        actorMap.put("임재성",	"01093502037");
        actorMap.put("장기연",	"01033460034");
        actorMap.put("김성현",	"01095483248");
        actorMap.put("김지응",	"01047056506");
        actorMap.put("김보람",	"01097501334");
        actorMap.put("양수정",	"01050626508");
        actorMap.put("이다혜",	"01099539678");
        actorMap.put("이화진",	"01039390312");
        actorMap.put("장남영",	"01093694490");
        actorMap.put("안지수",	"01055884704");

        String title = this.toEucKrAndBase64String(mms.getTitle());
        String contents = this.toEucKrAndBase64String(mms.getContents());
        String[] actor = mms.actorKey.split(",");


        String gubun = "M";

        int completeFlag = 0;
        for(int i = 0 ; i < actor.length ; i++) {
            MultiValueMap<String, Object> valueMap = new LinkedMultiValueMap<>();
            valueMap.add("id", id);
            valueMap.add("pwd", pwd);
            valueMap.add("gubun", gubun);
            valueMap.add("send_phone", mms.mobile);
            valueMap.add("recv_phone", actorMap.get(actor[i]));
            valueMap.add("subject", title);
            valueMap.add("txt", contents);
            valueMap.add("returntype", "XML");
            valueMap.add("send_key", UUID.randomUUID().toString());

            URL url = null;
            if (!StringUtils.isEmpty("https://event.admerce.co.kr/kkalssam/mms_test.jpg")) {
                try {
                    url = new URL("https://event.admerce.co.kr/kkalssam/mms-test.jpg");
                } catch (MalformedURLException e) {

                }

                try (InputStream imageIs = url.openStream();
                     BufferedInputStream bis = new BufferedInputStream(imageIs);
                     ByteArrayOutputStream baos = new ByteArrayOutputStream();) {

                    byte[] buf = new byte[1024 * 32]; // 32k read buffer
                    int len = -1;

                    while ((len = bis.read(buf)) >= 0) {
                        baos.write(buf, 0, len);
                    }
                    baos.flush();

                    ByteArrayResource bar = new ByteArrayResource(baos.toByteArray()) {
                        public String getFilename() {
                            return "MMS_FILE";
                        }
                    };
                    valueMap.add("file", bar);

                } catch (IOException ioe) {
                    System.out.println("이미지 로딩에 실패했습니다.");
                }
            }

            RestTemplate restTemplate = new RestTemplate();
            String resString = restTemplate.postForObject("http://aoa.sktelecom.com/newmms/ext_message.html", valueMap, String.class);
            int cnt = resString.indexOf("<?xml"); //FILE 전송시 리턴이 이상하게옴
            resString = resString.substring(cnt);
            System.out.println("resString=" + resString);
        }
//            JSONObject jsonObject = XML.toJSONObject(resString);
//
//            logger.info(resString);
//            logger.info(jsonObject.toString());
//
//            //messageHistory.setCode(jsonObject.);
//            //messageHistory.setSendTime(new Date());
//
//            JSONObject resultJson = jsonObject.getJSONObject("aoa_sms_result");
//
//
//            messageHistory.setAoaCode(resultJson.getInt("code"));
//            messageHistory.setAoaRemain(resultJson.getInt("remain"));
//            messageHistory.setAoaUnique(resultJson.getInt("unique"));
//            messageHistory.setAoaCodeMsg(resultJson.getString("code_msg"));
//            messageHistory.setAoaSendKey(resultJson.getString("send_key"));
//            messageHistory.setAoaErrorCode(resultJson.getString("error_code"));
//            messageHistory.setAoaMsgkey(resultJson.getString("msgkey"));
//
//            if (messageHistory.getAoaCode() == 1000) { //한건이라도 성공이면 COMPLETE
//                completeFlag = 1;
//                result.setCode("1000");
//                messageHistory.setStatus(MessageHistoryStatus.COMPLETE);
//            }else{
//                messageHistory.setStatus(MessageHistoryStatus.FAIL);
//            }
//        }
//
//        Message _message = messageRepository.save(message);
//
//        for(MessageHistory messageHistory : messageHistoryList){
//            messageHistory.setMessage(_message);
//        }
//
//        messageHistoryRepository.saveAll(messageHistoryList);

//        if (completeFlag == 1) {
//            message.setStatus(MessageStatus.COMPLETE);
//        } else {  //모두 실패
//            message.setStatus(MessageStatus.FAIL);
//        }

//        if (message.getMessageKey() != null) {
//
//            List <MessageTemp> messageTempList = messageTempRepository.findByMessageKey(message.getMessageKey());
//            for (MessageTemp messageTemp : messageTempList) {
//                messageTemp.setSendYN(YesOrNo.Y);
//            }
//            message.setSendTime(new Date());
//            message.setMessageTempList(messageTempList);
//        }


        //  messageHistoryRepository.save(messageHistoryList);

        //  message.setStatus(MessageStatus.COMPLETE);

        // messageRepository.save(message);


    }

    private String toEucKrAndBase64String(String source) {
        String tmp = null;
        Charset euckrCharset = Charset.forName("euc-kr");
        ByteBuffer byteBuffer = euckrCharset.encode(source);
        byte[] euckrStringBuffer = new byte[byteBuffer.remaining()];
        byteBuffer.get(euckrStringBuffer);
        tmp = new String(Base64.getEncoder().encode(euckrStringBuffer));
        return tmp;
    }

}

