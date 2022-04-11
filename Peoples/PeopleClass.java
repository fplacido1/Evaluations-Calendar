package Peoples;

public abstract class PeopleClass implements People{
    protected String name;
    protected String type;

    /*
    public PeopleClass(String name, String type) {
       this.name = name;
        this.type = type;
    }
*/
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
       return type;
    }

    @Override
    public boolean equals(Object e){
        if(this == e)
            return true;
            
        PeopleClass tmp =(PeopleClass) e;
        return tmp.getName().equals(name);
    }

    
}
