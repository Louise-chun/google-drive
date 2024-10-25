package googledrive.domain;

import googledrive.VideoProcessingApplication;
import googledrive.domain.Streamprocessed;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Video_table")
@Data
//<<< DDD / Aggregate Root
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileid;

    private String videourl;

    private String userid;

    private Date processDt;

    @PostPersist
    public void onPostPersist() {
        Streamprocessed streamprocessed = new Streamprocessed(this);
        streamprocessed.publishAfterCommit();
    }

    public static VideoRepository repository() {
        VideoRepository videoRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoRepository.class
        );
        return videoRepository;
    }

    //<<< Clean Arch / Port Method
    public static void ifVideoProcessStreaming(Fileuploaded fileuploaded) {
        //implement business logic here:

        /** Example 1:  new item 
        Video video = new Video();
        repository().save(video);

        Streamprocessed streamprocessed = new Streamprocessed(video);
        streamprocessed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileuploaded.get???()).ifPresent(video->{
            
            video // do something
            repository().save(video);

            Streamprocessed streamprocessed = new Streamprocessed(video);
            streamprocessed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
