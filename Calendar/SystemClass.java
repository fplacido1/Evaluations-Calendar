package Calendar;
import java.time.*;

import javax.lang.model.util.ElementScanner14;

import Array.*;
import Peoples.*;
import Course.*;



public class SystemClass implements SystemInterface{
    private static final String SEVERE = "Severe";//quase
    private static final String MILD = "Mild";//feito
    private static final String FREE = "Free";//feito
    
    
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
    @Override
    public void addSchedule(String courseName, LocalDate date, LocalTime startTime, LocalTime endTime, String testName){
        getCourse(courseName).addSchedule(date, startTime, endTime, testName);
    }
    
    public String conflictClassificationName(LocalDate date, LocalTime startTime, LocalTime endTime){
       String problem = null;
        for(int i = 0; i < courses.size(); i++){
            Course tmp = courses.get(i);
        if(tmp.conflictDate(date)){
            if(tmp.conflictTime(startTime, endTime))
                problem = "Severe";
                else{
                problem = "Mild";  }
         }else{
                problem = "Free";
            }
        }return problem;
    }

    public int conflictClassificationNumber(LocalDate date, LocalTime startTime, LocalTime endTime, String job, String problem){
        Array<Course> tmpCourses = new ArrayClass<Course>();

        switch(problem){ //metodo privado
        
            case SEVERE:
                
                for(int i = 0; i < courses.size(); i++){
                Course tmp1 = courses.get(i);
                if(tmp1.conflictDate(date) && tmp1.conflictTime(startTime, endTime)){
                    tmpCourses.insertLast(tmp1);
              
                }
            }
            break;

            case MILD:
            for(int i = 0; i < courses.size(); i++){
                Course tmp1 = courses.get(i);
                if(tmp1.conflictDate(date) && !tmp1.conflictTime(startTime, endTime)){
                    tmpCourses.insertLast(tmp1);;
               
                }
            }
            break;

            case FREE:
            for(int i = 0; i < courses.size(); i++){
                Course tmp1 = courses.get(i);
                if(!tmp1.conflictDate(date)){
                    tmpCourses.insertLast(tmp1);
                }
            }
            break;
        }
    int nOfPeople = 0;
    Array<People> intersected = null;

    for(int i = 0; i <  tmpCourses.size() - 1; i ++){
        Array<People> coursePeople = tmpCourses.get(i).getAllPeople();
        intersected = intersection(intersected, coursePeople);
    }


        for(int i = 0; i < intersected.size(); i++){
            if(intersected.get(i).getType().compareTo(job) == 0){
                nOfPeople++;
            }
        }

        return nOfPeople;
    }



    //cmd-superProfessor
    @Override
    public People superProfessor(){//duvida
        int numberOfStudents = 0;
        int professorIndex = -1;
        for(int i = 0; i < people.size(); i++){
            if(people.get(i).getType().compareTo("Teacher") == 0){
            	Teachers tmp = (Teachers)people.get(i);
                if(numberOfStudents < tmp.getNumberOfStudents()){
                    numberOfStudents = tmp.getNumberOfStudents();
                    professorIndex = i;
                }
            }
        }return people.get(professorIndex);
    }

    //cmd-people
    @Override
    public Iterator listPeople(){
        return people.iterator();
    }

    //cmd-courses
    @Override
    public Iterator listCourses(){
        return courses.iterator();
    }

    //cmd-roster
    @Override
    public Iterator<People> roster (String courseName){
        return getCourse(courseName).peopleIterator();
    }

    @Override
    public Iterator <Events> eventsIterator(String courseName){
        return getCourse(courseName).eventsIterator();
    }

    public Course getCourseByName(String courseName){ //podemos fazer um metodo privado para o ppl como este
        Course courseTmp = new CourseClass(courseName);

        int courseIndex = courses.searchIndexOf(courseTmp);

       return courses.get(courseIndex);
    }

//cmd interseciont
    public Array <People> intersection (Array<People> people1, Array <People> people2){
        Array<People> intersected = new  ArrayClass<People>();
        if(people1 == null){// 1 vez, people1 e sempre null
            return people2;
        }else{
            for(int i = 0; i < people1.size(); i++){
                if(people2.searchForward(people1.get(i)))
                    intersected.insertLast(people1.get(i));
            }
            return intersected;
        }

    }

    private Course getCourse(String courseName){ //podemos fazer um metodo privado para o ppl como este
        Course courseTmp = new CourseClass(courseName);

        int courseIndex = courses.searchIndexOf(courseTmp);

       return courses.get(courseIndex);
    }

  
    
}
