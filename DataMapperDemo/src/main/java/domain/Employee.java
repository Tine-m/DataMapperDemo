package domain;

public class Employee {

   private final int id;
   private final String ename;
   private final int sal;
   private final int comm;
   
    public Employee(int id, String ename, int sal, int comm) {
        this.id = id;
        this.ename = ename;
        this.sal = sal;
        this.comm = comm;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", ename=" + ename + ", sal=" + sal + ", comm=" + comm + '}';
    }

}
