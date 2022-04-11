package Course;
import Array.*;
import Peoples.*;

public interface Course {

    String getName();

    Iterator<People> peopleIterator();

    Iterator<Events> testsIterator();

    void addTeacher(Object e);

    void addStudents(Object e);

    void addTest(Object e);

    
}
