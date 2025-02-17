package googledrive.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import googledrive.config.kafka.KafkaProcessor;
import googledrive.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    VideoRepository videoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Fileuploaded'"
    )
    public void wheneverFileuploaded_IfVideoProcessStreaming(
        @Payload Fileuploaded fileuploaded
    ) {
        Fileuploaded event = fileuploaded;
        System.out.println(
            "\n\n##### listener IfVideoProcessStreaming : " +
            fileuploaded +
            "\n\n"
        );

        // Sample Logic //
        Video.ifVideoProcessStreaming(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
