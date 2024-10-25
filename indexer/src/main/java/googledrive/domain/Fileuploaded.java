package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Fileuploaded extends AbstractEvent {

    private Long id;
    private String userid;
    private String filename;
    private Float filesite;
    private Date uploaddate;
}
