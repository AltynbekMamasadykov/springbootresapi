package peaksoft.springbootresapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentResponseView {
    List<StudentResponse> responseList;
}
