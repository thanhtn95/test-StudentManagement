package zone.good.springboottest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zone.good.springboottest.model.ClassRoom;
import zone.good.springboottest.model.Student;
import zone.good.springboottest.service.ClassRoomService;


@Controller
@RequestMapping("/classroom")
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;
    @GetMapping("")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/newClass")
    public ModelAndView getNewClassForm(){
        ModelAndView modelAndView = new ModelAndView("classroom/create");
        modelAndView.addObject("classroom",new ClassRoom());
        return modelAndView;
    }

    @PostMapping("/newClass")
    public ModelAndView doAddNewClassRoom(@ModelAttribute("classroom") ClassRoom classRoom){
        classRoomService.save(classRoom);
        return new ModelAndView("redirect:/classroom/classroomList");
    }

    @GetMapping("/classroomList")
    public ModelAndView getClassroomList(@PageableDefault(size = 10) Pageable pageable){
        Page<ClassRoom> classRooms = classRoomService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("classroom/list");
        modelAndView.addObject("classrooms",classRooms);
        return modelAndView;
    }

    @GetMapping("{id}/viewClassRoom")
    public ModelAndView getClassView(@PathVariable int id){
        ClassRoom classRoom = classRoomService.findById(id);
        ModelAndView modelAndView = new ModelAndView("classroom/view");
        modelAndView.addObject("classroom",classRoom);
        return modelAndView;
    }

    @GetMapping("{id}/editClassRoom")
    public ModelAndView getClassEditView(@PathVariable int id){
        ClassRoom classRoom = classRoomService.findById(id);
        ModelAndView modelAndView = new ModelAndView("classroom/edit");
        modelAndView.addObject("classroom",classRoom);
        return modelAndView;
    }

    @PostMapping("/doEditClass")
    public ModelAndView doEditClass(@ModelAttribute("classroom") ClassRoom classRoom){
        classRoomService.save(classRoom);
        return new ModelAndView("redirect:/classroom/classroomList");
    }
    @GetMapping("{id}/deleteClassRoom")
    public ModelAndView doDeleteClass(@PathVariable int id){
        classRoomService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/classroom/classroomList");
        return modelAndView;
    }

}
