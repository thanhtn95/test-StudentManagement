package zone.good.springboottest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import zone.good.springboottest.model.ClassRoom;

public interface ClassRoomRepository extends PagingAndSortingRepository<ClassRoom,Integer>{
}
