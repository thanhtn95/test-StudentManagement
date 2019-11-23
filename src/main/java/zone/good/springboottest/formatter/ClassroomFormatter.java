package zone.good.springboottest.formatter;

import org.springframework.format.Formatter;
import zone.good.springboottest.model.ClassRoom;
import zone.good.springboottest.service.ClassRoomService;

import javax.persistence.Converter;
import java.text.ParseException;
import java.util.Locale;

public class ClassroomFormatter implements Formatter<ClassRoom> {
    private ClassRoomService classRoomService;

    public ClassroomFormatter(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @Override
    public ClassRoom parse(String text, Locale locale) throws ParseException {
        return classRoomService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(ClassRoom object, Locale locale) {
        return null;
    }
}
