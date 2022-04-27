package Course;

import java.time.LocalDate;
import java.time.LocalTime;

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

    public int getNumberOfPeople(){
        return participants.size();
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

    @Override
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
    public void addDeadline(LocalDate date, String deadLineName) {
       
        Projects project = new Projects(deadLineName, date); 

        events.insertLast(project);   
    }

    @Override
    public void addSchedule(LocalDate date, LocalTime startTime, LocalTime endTime, String testName){
        Tests tmp = new Tests(name, date, startTime, endTime);

        events.insertLast(tmp);
    }

    @Override
    public People getPeople(int i) {
        return participants.get(i);
    }

    @Override
    public int getSize(){
        return participants.size();
    }

    @Override
    public Array<People> getAllPeople() {
        // TODO Auto-generated method stub
        return participants;
    }

    @Override
    public boolean conflictDate(LocalDate date){
        for (int i = 0; i < events.size(); i++){
            Events tmp = events.get(i);
            if(tmp.getType().compareTo("Tests") == 0){
                if(tmp.getDate().compareTo(date) == 0)
                    return true;
            }
        }return false;
    }

    @Override
    public boolean conflictTime(LocalTime startTime, LocalTime endTime){
        for(int i = 0; i < events.size(); i++){
            Events tmp = events.get(i);
            LocalTime begining = tmp.getStartTime();// possivel erro
            LocalTime ending = tmp.getEndTime();//possivel erro

            if(tmp.getType().compareTo("Tests") == 0)
             if((begining.isAfter(startTime) && begining.isBefore(endTime)) || (ending.isAfter(startTime) && ending.isBefore(endTime))
                || (startTime.isAfter(begining) && startTime.isBefore(ending)) || (endTime.isAfter(begining) && endTime.isBefore(ending))){
                    return true;
             }
        }return false;
    }

    
}