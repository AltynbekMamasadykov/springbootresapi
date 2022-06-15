package peaksoft.springbootresapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.springbootresapi.dto.StudentRequest;
import peaksoft.springbootresapi.dto.StudentResponse;
import peaksoft.springbootresapi.dto.StudentResponseView;
import peaksoft.springbootresapi.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
@Tag(name = "Student API", description = "User with role admin can add,update,delete or get all students")
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

//    @GetMapping
//    public List<StudentResponse> getAllStudents(){
//        return service.getAllStudents();
//    }

    @GetMapping
    public StudentResponseView getAllStudents(@RequestParam(name = "text",required = false) String text,
                                              @RequestParam int page,
                                              @RequestParam int size)
    {
        return service.getAllStudentsPagination(text, page, size);
    }

}
