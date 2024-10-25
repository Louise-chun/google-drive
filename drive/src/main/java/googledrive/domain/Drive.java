package googledrive.domain;

import googledrive.domain.Fileuploaded;
import googledrive.DriveApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Drive_table")
@Data

//<<< DDD / Aggregate Root
public class Drive  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private String userid;
    
    
    
    
    private String filename;
    
    
    
    
    private Float filesite;
    
    
    
    
    private Date uploaddate;
    
    
    
    @ElementCollection
    private List<> filedetails;

    @PostPersist
    public void onPostPersist(){


        Fileuploaded fileuploaded = new Fileuploaded(this);
        fileuploaded.publishAfterCommit();

    
    }

    public static DriveRepository repository(){
        DriveRepository driveRepository = DriveApplication.applicationContext.getBean(DriveRepository.class);
        return driveRepository;
    }






}
//>>> DDD / Aggregate Root
