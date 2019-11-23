package zone.good.springboottest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import zone.good.springboottest.model.ClassRoom;
import zone.good.springboottest.model.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student,Integer> {
    Page<Student> findAllByClassRoom(Pageable pageable, ClassRoom classRoom);
    Page<Student> findAllByOrderByFirstNameAsc(Pageable pageable);
    Page<Student> findAllByOrderByFirstNameDesc(Pageable pageable);
    Page<Student> findAllByOrderByLastNameAsc(Pageable pageable);
    Page<Student> findAllByOrderByLastNameDesc(Pageable pageable);
}
