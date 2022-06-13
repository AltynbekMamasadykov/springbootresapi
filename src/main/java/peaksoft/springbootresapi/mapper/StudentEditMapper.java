package peaksoft.springbootresapi.mapper;

import org.springframework.stereotype.Component;
import peaksoft.springbootresapi.dto.StudentRequest;
import peaksoft.springbootresapi.entity.Student;

import java.time.LocalDate;

@Component
public class StudentEditMapper {

    public Student create(StudentRequest request){
        if(request==null){
            return null;
        }
        Student student = new Student();
        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setSurname(request.getSurname());
        student.setEmail(request.getEmail());
        student.setCreated(LocalDate.now());
        student.setEnabled(true);
        return student;
    }

    public void update (Student student,StudentRequest request){
        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setSurname(request.getSurname());
        student.setEmail(request.getEmail());
    }


}
