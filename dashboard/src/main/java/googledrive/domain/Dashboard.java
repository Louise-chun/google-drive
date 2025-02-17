package googledrive.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Dashboard_table")
@Data
public class Dashboard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String fileid;
    private String filesize;
    private String filename;
    private String undexYn;
    private String uploadYn;
    private String videoUrl;
    private Date uploadDt;
    private String userid;
}
