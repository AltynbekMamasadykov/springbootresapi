package peaksoft.springbootresapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import peaksoft.springbootresapi.dto.StudentRequest;
import peaksoft.springbootresapi.dto.StudentResponse;
import peaksoft.springbootresapi.dto.StudentResponseView;
import peaksoft.springbootresapi.entity.Student;
import peaksoft.springbootresapi.mapper.StudentEditMapper;
import peaksoft.springbootresapi.mapper.StudentViewMapper;
import peaksoft.springbootresapi.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository repository;
    private final StudentEditMapper editMapper;
    private final StudentViewMapper viewMapper;

    public StudentResponse create(StudentRequest studentRequest){
        Student student = editMapper.create(studentRequest);
        repository.save(student);
        return viewMapper.viewStudent(student);
    }

    public StudentResponse update(Long id,StudentRequest studentRequest){
        Student student = repository.findById(id).get();
        editMapper.update(student,studentRequest);
        return viewMapper.viewStudent(repository.save(student));
    }

    public StudentResponse findById(Long id){
        Student student = repository.findById(id).get();
        return viewMapper.viewStudent(student);
    }

    public StudentResponse deleteById(Long id){
        Student student = repository.getById(id);
        repository.delete(student);
        return viewMapper.viewStudent(student);
    }

//    public List<StudentResponse> getAllStudents(){
//        return viewMapper.view(repository.findAll());
//    }

    public StudentResponseView getAllStudentsPagination(String text,int page,int size){
        StudentResponseView studentResponseView = new StudentResponseView();
        Pageable pageable = PageRequest.of(page, size);
        studentResponseView.setResponseList(view(search(text,pageable)));
        return studentResponseView;
    }

    public List<StudentResponse> view(List<Student> students){
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student: students) {
            studentResponses.add(viewMapper.viewStudent(student));
        }
        return studentResponses;
    }

    private List<Student> search(String name, Pageable pageable){
        String text = name == null ? "" : name;
        return repository.searchAndPagination(text.toUpperCase(),pageable);
    }

}
