package Calendar;

import java.time.*;
import Peoples.*;
import Array.*;
import Course.*;

public interface SystemInterface {
    void addTeacher(String name);

    void addStudent(String name, int number);

    void  addCourse(String name);

    void assignTeacher(String courseName, String name);

    void enrolStudent(String courseName, String name);

    void addDeadline(String courseName, LocalDate deadLineDate, String deadLineName);
    
    void addSchedule(String courseName, LocalDate date, LocalTime startTime, LocalTime endTime, String testName);
    
    People superProfessor();
    
    Iterator listPeople();
    
    Iterator listCourses();
    
    Iterator<People> roster (String courseName);
    
    Iterator<Events> eventsIterator(String courseName);
    
    void intersection(String courseName1, String courseName2);

}
