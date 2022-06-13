package peaksoft.springbootresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.springbootresapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
