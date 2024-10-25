package googledrive.domain;

import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Streamprocessed extends AbstractEvent {

    private Long id;
    private String fileid;
    private String videourl;
    private String userid;
    private Date processDT;
}
