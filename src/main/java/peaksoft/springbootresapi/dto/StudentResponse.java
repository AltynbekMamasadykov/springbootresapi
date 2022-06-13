package peaksoft.springbootresapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter@Setter
public class StudentResponse {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private int age;
    @CreatedDate
    private LocalDate created;
    private boolean enabled;

}
