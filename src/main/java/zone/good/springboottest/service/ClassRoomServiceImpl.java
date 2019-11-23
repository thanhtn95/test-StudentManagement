package zone.good.springboottest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zone.good.springboottest.model.ClassRoom;
import zone.good.springboottest.repository.ClassRoomRepository;

public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;
    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public Page<ClassRoom> findAll(Pageable pageable) {
        return classRoomRepository.findAll(pageable);
    }

    @Override
    public void save(ClassRoom classRoom) {
        classRoomRepository.save(classRoom);
    }

    @Override
    public void delete(int id) {
        classRoomRepository.deleteById(id);
    }

    @Override
    public ClassRoom findById(int id) {
        return classRoomRepository.findById(id).get();
    }


}
