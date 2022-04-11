package Course;
import Array.*;
import Peoples.*;

public interface Course {

    String getName();

    Iterator<People> peopleIterator();

    Iterator<Events> testsIterator();

    void addTeacher(People e);

    void addStudents(People e);

    void addTest(Object e);

    boolean eqauls(Object e);

}
