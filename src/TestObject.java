import java.util.*;
import java.lang.String;

public class TestObject implements Comparable{

    private String name;
    private int id;

    public TestObject(String name, int id){
        this.name=name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null || getClass() != o.getClass()){
            return false;
        }
        TestObject to = (TestObject) o;
        return this.id == to.id && Objects.equals(this.name, to.name);
    }

    @Override
    public int compareTo(Object o) {
        TestObject to = (TestObject) o;
        if(this.id>to.id){
            return 1;
        }
        if(this.id<to.id){
            return -1;
        }
        return this.name.compareTo(to.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
