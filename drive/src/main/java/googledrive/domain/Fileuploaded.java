package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Fileuploaded extends AbstractEvent {

    private Long id;
    private String userid;
    private String filename;
    private Float filesite;
    private Date uploaddate;

    public Fileuploaded(Drive aggregate) {
        super(aggregate);
    }

    public Fileuploaded() {
        super();
    }
}
//>>> DDD / Domain Event
