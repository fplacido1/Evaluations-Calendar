package Calendar;
import Array.*;
import Peoples.*;
import Course.*;

public class SystemClass implements System{

    Array<People> people;
    Array<Course> courses;

    public SystemClass() {
        people = new ArrayClass<>();
        courses = new ArrayClass<>();
    }

    @Override
    public void addTeacher(String name) {
        People tmp = new Teachers(name);
        people.insertLast(tmp);
    }

    @Override
    public void addStudent(String name, int number) {
       People tmp = new Student(name, number);
       people.insertLast(tmp);
    }

    @Override
    public void addCourse(String name) {
       Course tmp = new CourseClass(name);
       courses.insertLast(tmp);
    }

    @Override
    public void assignTeacher(String courseName, String name) {
        //create temporary object
       Course courseTmp = new CourseClass(courseName);
       People peopleTmp = new Teachers(name);

       //index of objects in array
       int courseIndex = courses.searchIndexOf(courseTmp);
       int teacherIndex = people.searchIndexOf(peopleTmp);

       //get objects from array
       Course course = courses.get(courseIndex);
       People teacher = people.get(teacherIndex);

       course.addTeacher(teacher);
    }

    @Override
    public void enrolStudent(String courseName, String name) {
        //create temporary object
        Course courseTmp = new CourseClass(courseName);
        People peopleTmp = new Student(name, 0);
 
        //index of objects in array
        int courseIndex = courses.searchIndexOf(courseTmp);
        int studentIndex = people.searchIndexOf(peopleTmp);
 
        //get objects from array
        Course course = courses.get(courseIndex);
        People student = people.get(studentIndex);
 
        course.addStudents(student);
    }
    
}
