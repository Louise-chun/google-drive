package googledrive.infra;

import googledrive.config.kafka.KafkaProcessor;
import googledrive.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileuploaded_then_CREATE_1(
        @Payload Fileuploaded fileuploaded
    ) {
        try {
            if (!fileuploaded.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setFileid(String.valueOf(fileuploaded.getId()));
            dashboard.setFilename(fileuploaded.getFilename());
            dashboard.setUserid(fileuploaded.getUserid());
            dashboard.setFilesize(String.valueOf(fileuploaded.getFilesite()));
            dashboard.setUploadDt(fileuploaded.getUploaddate());
            dashboard.setFilename(fileuploaded.getFilename());
            dashboard.setUserid(fileuploaded.getUserid());
            dashboard.setFilesize(String.valueOf(fileuploaded.getFilesite()));
            dashboard.setUploadDt(fileuploaded.getUploaddate());
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenStreamprocessed_then_UPDATE_1(
        @Payload Streamprocessed streamprocessed
    ) {
        try {
            if (!streamprocessed.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByFileid(
                streamprocessed.getFileid()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setVideoUrl(streamprocessed.getVideourl());
                dashboard.set();
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
