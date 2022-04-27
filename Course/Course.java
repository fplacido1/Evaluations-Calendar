package Course;

import java.time.*;
import Array.*;
import Peoples.*;

public interface Course {

    String getName();

    Iterator<People> peopleIterator();

    Iterator<Events> eventsIterator();

    void addTeacher(People e);

    void addStudents(People e);

    boolean equals(Object e);

    void addDeadline(LocalDate deadLineDate, String deadlineName);

    void addSchedule(LocalDate date, LocalTime startTime, LocalTime endTime, String testName);

    People getPeople(int i);

    Array<People> getAllPeople();

    int getSize();
    
    int getNumberOfStudents();
    
    boolean conflictDate(LocalDate date);
    
    boolean conflictTime(LocalTime startTime, LocalTime endTime);

    int getNumberOfPeople();
}
