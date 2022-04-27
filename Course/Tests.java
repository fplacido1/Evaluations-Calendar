package Course;

import java.time.*;

public class Tests extends EventsClass{

    private static final String TESTS = "Tests";
    
    private LocalTime startTime;
    private LocalTime endTime;

    public Tests(String name, LocalDate date, LocalTime startTime, LocalTime endTime){
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = TESTS; 
    }

   public LocalTime getStartTime(){
       return startTime;
   }

   public LocalTime getEndTime(){
       return endTime;
   }
    
}
