package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Streamprocessed extends AbstractEvent {

    private Long id;
    private String fileid;
    private String videourl;
    private String userid;
    private Date processDt;

    public Streamprocessed(Video aggregate) {
        super(aggregate);
    }

    public Streamprocessed() {
        super();
    }
}
//>>> DDD / Domain Event
