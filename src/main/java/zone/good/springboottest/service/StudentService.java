package zone.good.springboottest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zone.good.springboottest.model.ClassRoom;
import zone.good.springboottest.model.Student;

public interface StudentService {
    Iterable<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    Student findById(int id);
    void save(Student student);
    void delete(int id);
    Page<Student> findAllByClassRoom(Pageable pageable, ClassRoom classRoom);
    Page<Student> findAllByOrderByFirstNameAsc(Pageable pageable);
    Page<Student> findAllByOrderByFirstNameDesc(Pageable pageable);
    Page<Student> findAllByOrderByLastNameAsc(Pageable pageable);
    Page<Student> findAllByOrderByLastNameDesc(Pageable pageable);
}
