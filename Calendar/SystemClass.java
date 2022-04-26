package Calendar;
import java.time.*;

import Array.*;
import Peoples.*;
import Course.*;

public class SystemClass implements SystemInterface{

    Array<People> people;
    Array<Course> courses;

    //construtor
    public SystemClass() {
        people = new ArrayClass<>();
        courses = new ArrayClass<>();
    }

    //cmd-addTeacher
    @Override
    public void addTeacher(String name) {
        People tmp = new Teachers(name);
        people.insertLast(tmp);
    }

    //cmd-addStudent
    @Override
    public void addStudent(String name, int number) {
       People tmp = new Student(name, number);
       people.insertLast(tmp);
    }

    //cmd-addCourse
    @Override
    public void addCourse(String name) {
       Course tmp = new CourseClass(name);
       courses.insertLast(tmp);
    }

    //cmd-assign
    @Override
    public void assignTeacher(String courseName, String name) {
        //create temporary object
       People peopleTmp = new Teachers(name);

       //index of objects in array
       int teacherIndex = people.searchIndexOf(peopleTmp);

       //get objects from array
       People teacher = people.get(teacherIndex);

       getCourse(courseName).addTeacher(teacher);
    }

    //cmd-enrol
    @Override
    public void enrolStudent(String courseName, String name) {
        //create temporary object
        People peopleTmp = new Student(name, 0);
 
        //index of objects in array
        int studentIndex = people.searchIndexOf(peopleTmp);
 
        //get objects from array
        People student = people.get(studentIndex);
 
        getCourse(courseName).addStudents(student);
    }

    //cmd-deadline
    @Override
    public void addDeadline(String courseName, LocalDate deadLineDate, String deadLineName) {
        getCourse(courseName).addDeadline(deadLineDate, deadLineName);
    }

    //cmd-schedule
    public void addSchedule(String courseName, int year, int month, int day, int hour, int mins, int duration, String testName){
        getCourse(courseName).addSchedule(year, month, day, hour, mins, duration, testName);
    }

    //cmd-superProfessor
    public People superProfessor(){
        int numberOfStudents = 0;
        int professorIndex = -1;
        for(int i = 0; i < people.size(); i++){
            People tmp = people.get(i);
            if(tmp.getType().compareTo("Teacher")){
                if(numberOfStudents < tmp.getNumberOfStudents()){
                    numberOfStudents = tmp.getNumberOfStudents();
                    professorIndex = i;
                }
            }
        }return people.get(professorIndex);
    }

    //cmd-people
    public Iterator listPeople(){
        return people.iterator();
    }

    //cmd-courses
    public Iterator listCourses(){
        return courses.iterator();
    }

    //cmd-roster
    public Iterator<People> roster (String courseName){
        return getCourse(courseName).peopleIterator();
    }

    public Iterator <Events> eventsIterator(String courseName){
        return getCourse(courseName).eventsIterator();
    }

    //cmd-intersection
    public void intersection(String courseName1, String courseName2){ //ver return de algo
        Course tmp1 = getCourse(courseName1);
        intersection(courseName2, intersection(courseName2, tmp1.getAllPeople()));
    }

    //cmd-intersection
    private Array<People> intersection(String courseName, Array<People> intersectedPeople){
        Array<People> intersected = new ArrayClass<>();
        Course tmp = getCourse(courseName);

        for(int i = 0; i < intersectedPeople.size(); i++){
            for(int j = 0; j < tmp.getSize(); j++){
                    if(intersectedPeople.get(i).equals(tmp.getPeople(j))){
                intersected.insertLast(tmp.getPeople(j));
                 }
            }
        }
        return intersected;
    }

    private Course getCourse(String courseName){ //podemos fazer um metodo privado para o ppl como este
        Course courseTmp = new CourseClass(courseName);

        int courseIndex = courses.searchIndexOf(courseTmp);

       return courses.get(courseIndex);
    }
    
}
