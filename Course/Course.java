package Course;
import time.*;

import java.time.LocalDate;

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

    void addSchedule(int year, int month, int day, int hour, int mins, int duration, String testName);

    People getPeople(int i);

    Array<People> getAllPeople();

    int getSize();
}
