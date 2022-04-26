package Course;

public class Tests extends EventsClass{

    private static final String TESTS = "Tests";
    private int hour;
    private int mins;
    private int duration;

    public Tests(String name, int year, int month, int day, int hour, int mins, int duration){
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.mins = mins;
        this.duration = duration;
        this.type = TESTS;
    }

    public int getHour(){
        return hour;
    }

    public int getMins(){
        return mins;
    }

    public int getDuration(){
        return duration;
    }
    
}
