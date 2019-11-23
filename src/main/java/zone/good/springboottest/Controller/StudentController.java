package zone.good.springboottest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zone.good.springboottest.model.ClassRoom;
import zone.good.springboottest.model.Student;
import zone.good.springboottest.service.ClassRoomService;
import zone.good.springboottest.service.StudentService;



@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassRoomService classRoomService;
    @ModelAttribute("classrooms")
    private Iterable<ClassRoom> getClassRooms(){return classRoomService.findAll();}
    @GetMapping("/newStudent")
    public ModelAndView getNewStudentForm(){
        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("student",new Student());
        modelAndView.addObject("classrooms",getClassRooms());
        return modelAndView;
    }

    @PostMapping("/newStudent")
    public ModelAndView doAddNewStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student/studentList");
        return modelAndView;
    }

    @GetMapping("/studentList")
    public ModelAndView getStudentList(@PageableDefault(size = 10) Pageable pageable){
        Page<Student> students = studentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("student/list");
        modelAndView.addObject("students",students);
        modelAndView.addObject("classrooms", getClassRooms());
        return modelAndView;
    }
    @GetMapping("{id}/viewStudent")
    public ModelAndView getStudentView(@PathVariable int id){
        Student student = studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("student/view");
        modelAndView.addObject("student",student);
        return modelAndView;
    }

    @GetMapping("{id}/editStudent")
    public ModelAndView getEditStudentForm(@PathVariable int id){
        Student student = studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("student/edit");
        modelAndView.addObject("student",student);
        modelAndView.addObject("classrooms", getClassRooms());
        return modelAndView;
    }

    @PostMapping("/doEditStudent")
    public ModelAndView doEditStudent(@ModelAttribute("student")Student student){
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student/studentList");
        return modelAndView;
    }

    @GetMapping("{id}/deleteStudent")
    public ModelAndView doDeleteStudent(@PathVariable int id){
        studentService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/student/studentList");
        return modelAndView;
    }

    @GetMapping("/ByClass")
    public ModelAndView getStudentByClass(@RequestParam("class") int classId, @PageableDefault(size = 10) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("student/list");
        Page<Student> students;
        if(classId == -1){
            students = studentService.findAll(pageable);
            modelAndView.addObject("students",students);
            modelAndView.addObject("classrooms", getClassRooms());
        }else{
            ClassRoom classRoom = classRoomService.findById(classId);
            students = studentService.findAllByClassRoom(pageable,classRoom);
            modelAndView.addObject("students",students);
            modelAndView.addObject("classrooms", getClassRooms());
            modelAndView.addObject("class",classId);
        }

        return modelAndView;
    }

    @GetMapping("/sortByFirstName")
    public ModelAndView sortbyFirstName(@PageableDefault(size = 10) Pageable pageable, @RequestParam("sortDirection1") String sort){
        ModelAndView modelAndView = new ModelAndView("student/list");
        Page<Student> students;
        if(sort.equals("no")){
            students = studentService.findAll(pageable);
        }else if(sort.equals("asc")){
            students = studentService.findAllByOrderByFirstNameAsc(pageable);
        }else{
            students = studentService.findAllByOrderByFirstNameDesc(pageable);
        }
        modelAndView.addObject("students",students);
        modelAndView.addObject("classrooms", getClassRooms());
        modelAndView.addObject("sortDirection1",sort);
        return modelAndView;
    }

    @GetMapping("/sortByLastName")
    public ModelAndView sortbyLastName(@PageableDefault(size = 10) Pageable pageable, @RequestParam("sortDirection2") String sort){
        ModelAndView modelAndView = new ModelAndView("student/list");
        Page<Student> students;
        if(sort.equals("no")){
            students = studentService.findAll(pageable);
        }else if(sort.equals("asc")){
            students = studentService.findAllByOrderByLastNameAsc(pageable);
        }else{
            students = studentService.findAllByOrderByLastNameDesc(pageable);
        }
        modelAndView.addObject("students",students);
        modelAndView.addObject("classrooms", getClassRooms());
        modelAndView.addObject("sortDirection2",sort);
        return modelAndView;
    }
}
