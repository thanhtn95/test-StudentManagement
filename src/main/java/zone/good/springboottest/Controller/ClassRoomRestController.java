package zone.good.springboottest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import zone.good.springboottest.model.ClassRoom;
import zone.good.springboottest.service.ClassRoomService;

@RestController
@RequestMapping("api")
public class ClassRoomRestController {
    @Autowired
    private ClassRoomService classRoomService;
    @GetMapping("/classroomList")
    public ResponseEntity<Iterable<ClassRoom>> listAllClass(){
        Iterable<ClassRoom> classRooms = classRoomService.findAll();
        if(classRooms == null){
            return new ResponseEntity<Iterable<ClassRoom>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<ClassRoom>>(classRooms,HttpStatus.OK);
    }

    @GetMapping("{id}/viewClassroom")
    public ResponseEntity<ClassRoom> viewClass(@PathVariable int id){
        ClassRoom classRoom = classRoomService.findById(id);
        if(classRoom == null){
            return new ResponseEntity<ClassRoom>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ClassRoom>(classRoom, HttpStatus.OK);
    }

    @PostMapping("/newClassroom")
    public ResponseEntity<Void> createNewClass(@RequestBody ClassRoom classRoom, UriComponentsBuilder uriComponentsBuilder){
        classRoomService.save(classRoom);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("{id}/viewClassroom").buildAndExpand(classRoom.getId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }

    @PutMapping("{id}/updateClassroom")
    public ResponseEntity<ClassRoom> updateClass(@PathVariable int id,@RequestBody ClassRoom classRoom){
        ClassRoom currentClass = classRoomService.findById(id);
        currentClass.setId(classRoom.getId());
        currentClass.setName(classRoom.getName());
        currentClass.setDescription(classRoom.getDescription());
        classRoomService.save(currentClass);
        return new ResponseEntity<ClassRoom>(currentClass,HttpStatus.OK);
    }

    @DeleteMapping("{id}/deleteClassroom")
    public ResponseEntity<ClassRoom> deleteClass(@PathVariable int id){
        classRoomService.delete(id);
        return new ResponseEntity<ClassRoom>(HttpStatus.OK);
    }
}
