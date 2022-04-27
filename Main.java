import java.time.*;
import java.util.Scanner;
import Calendar.*;

import Array.*;
import Peoples.*;
import Course.*;

public class Main{
    

    //comands
    private static final String PEOPLE = "people";//quase
    private static final String PROFESSOR = "professor";//feito
    private static final String STUDENT = "student";//feito
    private static final String COURSES = "courses";//quase
    private static final String COURSE = "course";//feito
    private static final String ROSTER = "roster";//quase
    private static final String ASSIGN = "assign";//feito
    private static final String ENROL = "enrol";//feito
    private static final String INTERSECTION = "intersection";//quase
    private static final String COURSEDEADLINES = "coursedeadlines";
    private static final String PERSONALDEADLINES = "personaldeadlines";
    private static final String DEADLINE = "deadline";//feito
    private static final String COURSETESTS = "coursetests";
    private static final String PERSONALTESTS = "personaltests";
    private static final String SCHEDULE = "schedule";//feito
    private static final String SUPERPROFESSOR = "superprofessor";//feito
    private static final String STRESSOMETER = "stressometer";
    private static final String HELP = "help";
    private static final String EXIT = "exit";//feito


    //help mensages
    private static final String PEOPLE_MSG = "list all people";
    private static final String PROFESSOR_MSG = "adds a new professor";
    private static final String STUDENT_MSG = "adds a new student";
    private static final String COURSES_MSG = "lists all courses";
    private static final String COURSE_MSG = "adds a new course";
    private static final String ROSTER_MSG = "lists the professors and students of a course";
    private static final String ASSIGN_MSG = "adds a professor to a course";
    private static final String ENROL_MSG = "adds students to a course";
    private static final String INTERSECTION_MSG = "lists all people involved in all the given courses";
    private static final String COURSEDEADLINES_MSG = "lists all deadlines in a given course";
    private static final String PERSONALDEADLINES_MSG = "lists all the deadlines of a given person";
    private static final String DEADLINE_MSG = "adds a new deadline";
    private static final String COURSETESTS_MSG = "lists all tests in a given course";
    private static final String PERSONALTESTS_MSG = "lists all tests for a given student";
    private static final String SCHEDULE_MSG = "adds a new test to a course";
    private static final String SUPERPROFESSOR_MSG = "presents the professor with more students";
    private static final String STRESSOMETER_MSG = "presents the students with the top N stressful sequences of evaluations"; //stressful?
    private static final String HELP_MSG = "shows the available commands";
    private static final String EXIT_HELP_MSG = "terminates the execution of the program";

    //Error mesages
    private static final String EXIT_MESSAGE = "Bye!";


    //println(PEOPLE + " - " + helpMSG)
    private static final String pattern = "yyyy-MM-dd";

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
    String comm;
    SystemClass system = new SystemClass();

    do{

        comm = in.nextLine();
     comands(in, system, comm);

    }while(comm != EXIT);
    
}

private static void comands (Scanner in, SystemClass system, String comm){

    switch(comm){
        case PEOPLE:
        break;

        case DEADLINE:
        addDeadline(in, system);
        break;

        case SCHEDULE:
        addSchedule(in, system);
        break;

        case HELP:
        help();
        break;

        case EXIT:
        System.out.println(EXIT_MESSAGE);
        System.out.println();

    }

}
private static void help(){
    System.out.println("Available commands:");
    System.out.println(PEOPLE + " - " + PEOPLE_MSG );
    System.out.println(PROFESSOR + " - " +PROFESSOR_MSG);
    System.out.println( STUDENT + " - " + STUDENT_MSG);
    System.out.println(COURSES + " - " + COURSES_MSG);
    System.out.println(COURSE + " - " + COURSE_MSG);
    System.out.println(ROSTER + " - " + ROSTER_MSG);
    System.out.println(ASSIGN + " - " + ASSIGN_MSG);
    System.out.println(ENROL + " - " + ENROL_MSG);
    System.out.println(INTERSECTION + " - " + INTERSECTION_MSG);
    System.out.println(COURSEDEADLINES + " - " + COURSEDEADLINES_MSG);
    System.out.println(PERSONALDEADLINES + " - " + PERSONALDEADLINES_MSG);
    System.out.println(DEADLINE + " - " + DEADLINE_MSG);
    System.out.println(COURSETESTS + " - " + COURSETESTS_MSG);
    System.out.println(PERSONALTESTS + " - " + PERSONALTESTS_MSG);
    System.out.println(SCHEDULE + " - " + SCHEDULE_MSG);
    System.out.println(SUPERPROFESSOR + " - " + SUPERPROFESSOR_MSG);
    System.out.println(STRESSOMETER + " - " + STRESSOMETER_MSG);
    System.out.println(HELP + " - " + HELP_MSG);
    System.out.println(EXIT + " - " + EXIT_HELP_MSG);
}

private static void addProfessor(Scanner in, SystemClass system){
    String name = in.nextLine();

    //if(system.)
}

private static void intersection(Scanner in, SystemClass system){
    int numberOfCourses = in.nextInt();
    Array<People> intersected = null;

    for(int i = 0; i <  numberOfCourses - 1; i ++){
        String courseName = in.nextLine();
        Array<People> coursePeople = system.getCourseByName(courseName).getAllPeople();
        
       intersected = system.intersection(intersected, coursePeople);
    } // so preciso de chamar o iterador com o ult intersected
}

private static void addSchedule(Scanner in, SystemClass system){
    int year = in.nextInt();
    int month = in.nextInt();
    int day = in.nextInt();
    int hour = in.nextInt();
    int mins = in.nextInt();
    int duration = in.nextInt();

    LocalDate date = LocalDate.of(year, month, day);
    LocalTime startTime = LocalTime.of(hour, mins);
    LocalTime endTime = startTime.plusHours(duration);

    String courseName = in.nextLine().trim();
    String testName = in.nextLine().trim();

    system.addSchedule(courseName, date, startTime, endTime, testName);


}

private static void addDeadline(Scanner in, SystemClass system){ // temos de fazer os checks
    // SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    String courseName = in.nextLine().trim();
    int year = in.nextInt();
    int month = in.nextInt();
    int day = in.nextInt();
    LocalDate deadLineDate = LocalDate.of(year, month, day);

    String deadLineName = in.nextLine().trim();

    system.addDeadline(courseName, deadLineDate, deadLineName);

}


}