package zone.good.springboottest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zone.good.springboottest.model.ClassRoom;

public interface ClassRoomService {
    Iterable<ClassRoom> findAll();
    Page<ClassRoom> findAll(Pageable pageable);
    void save(ClassRoom classRoom);
    void delete(int id);
    ClassRoom findById(int id);
}
