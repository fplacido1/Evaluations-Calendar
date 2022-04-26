package Course;

import Array.*;
import Peoples.*;

public class CourseClass implements Course{

    private String name;
    private int numberOfStudents;
    Array<People> participants;
    Array<Events> events;


    public CourseClass(String name) {
        this.name = name;
        this.numberOfStudents = 0;
    }

    @Override
    public void addStudents(People e) {
       participants.insertLast(e);
       numberOfStudents++;
       
       for(int i = 0; i < participants.size(); i++){
        People tmp = participants.get(i);
           if(tmp.getType().equals("Teacher")){
            tmp.addStudent(1);
           }
       }
    }

    @Override
    public void addTeacher(People e) {
        e.addStudents(numberOfStudents);
        participants.insertLast(e);
    }

    @Override
    public String getName() {
       return name;
    }

    public int getNumberOfStudents(){
        return numberOfStudents;
    }

    @Override
    public Iterator<People> peopleIterator() {
        // TODO Auto-generated method stub
        return participants.iterator();
    }

    @Override
    public Iterator<Events> eventsIterator() {
        // TODO Auto-generated method stub
        return events.iterator();
    }

    @Override
    public boolean equals(Object e) {
        if(this == e)
            return true;
            
        CourseClass tmp =(CourseClass) e;
        return tmp.getName().equals(name);
    }

    @Override
    public void addDeadline(int year, int month, int day, String deadLineName) {
       
        Projects project = new Projects(deadLineName, year, month, day); 

        events.insertLast(project);   
    }

    public void addSchedule(int year, int month, int day, int hour, int mins, int duration, String testName){
        Tests tmp = new Tests(name, year, month, day, hour, mins, duration);

        events.insertLast(tmp);
    }

    @Override
    public People getPeople(int i) {
        return participants.get(i);
    }

    public int getSize(){
        return participants.size();
    }

    @Override
    public Array<People> getAllPeople() {
        // TODO Auto-generated method stub
        return participants;
    }

    
}