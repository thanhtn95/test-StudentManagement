package zone.good.springboottest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zone.good.springboottest.model.ClassRoom;
import zone.good.springboottest.model.Student;
import zone.good.springboottest.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> findAllByClassRoom(Pageable pageable, ClassRoom classRoom) {
        return studentRepository.findAllByClassRoom(pageable,classRoom);
    }

    @Override
    public Page<Student> findAllByOrderByFirstNameAsc(Pageable pageable) {
        return studentRepository.findAllByOrderByFirstNameAsc(pageable);
    }

    @Override
    public Page<Student> findAllByOrderByFirstNameDesc(Pageable pageable) {
        return studentRepository.findAllByOrderByFirstNameDesc(pageable);
    }

    @Override
    public Page<Student> findAllByOrderByLastNameAsc(Pageable pageable) {
        return studentRepository.findAllByOrderByLastNameAsc(pageable);
    }

    @Override
    public Page<Student> findAllByOrderByLastNameDesc(Pageable pageable) {
        return studentRepository.findAllByOrderByLastNameDesc(pageable);
    }
}
