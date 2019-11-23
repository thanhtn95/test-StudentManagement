package zone.good.springboottest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "classrooms")
public class ClassRoom  {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty
    private String name;
    private String description;
    @JsonManagedReference
    @OneToMany(targetEntity = Student.class, fetch = FetchType.EAGER)
    private List<Student> students;

    public ClassRoom() {
    }

    public ClassRoom(@NotEmpty String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ClassRoom(@NotEmpty String name, String description, List<Student> students) {
        this.name = name;
        this.description = description;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
