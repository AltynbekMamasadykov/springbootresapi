package peaksoft.springbootresapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.springbootresapi.dto.StudentRequest;
import peaksoft.springbootresapi.dto.StudentResponse;
import peaksoft.springbootresapi.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService service;

    @PostMapping
    public StudentResponse create(@RequestBody StudentRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public StudentResponse update(@PathVariable Long id, @RequestBody StudentRequest request){
        return service.update(id,request);
    }

    @GetMapping("{id}")
    public StudentResponse update(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public StudentResponse delete(@PathVariable Long id){
        return service.deleteById(id);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return service.getAllStudents();
    }
}
