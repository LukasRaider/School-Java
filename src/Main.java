import java.util.ArrayList;

abstract class Person {
    protected int age;
    private static int count = 0;

    public Person() {
        count++;
    }

    public Person(int age) {
        this.age = age;
        count++;
    }

    public abstract void writeInfo();

    public static int getCount() {
        return count;
    }
}

abstract class Employee extends Person {
    protected int salary;

    public Employee() {}

    public Employee(int age, int salary) {
        super(age);
        this.salary = salary;
    }

    @Override
    public void writeInfo() {
        System.out.print("Count persons: " + Person.getCount() + ", age: " + age);
        System.out.print(", salary: " + salary);
    }
}

class Student extends Person {
    protected int scholarship;

    public Student(int age, int scholarship) {
        super(age);
        this.scholarship = scholarship;
    }

    @Override
    public void writeInfo() {
        System.out.print("Count persons: " + Person.getCount() + ", age: " + age);
        System.out.println(", scholarship: " + scholarship);
    }

    @Override
    public String toString() {
        return "Student " + age + ", " + scholarship;
    }
}

class Accountant extends Employee {
    public Accountant(int age, int salary) {
        super(age, salary);
    }

    @Override
    public void writeInfo() {
        super.writeInfo();
        System.out.println();
    }
}

class Teacher extends Employee {
    protected int teachingTime;

    public Teacher(int age, int salary, int teachingTime) {
        super(age, salary);
        this.teachingTime = teachingTime;
    }

    @Override
    public void writeInfo() {
        super.writeInfo();
        System.out.println(", count teaching hours: " + teachingTime);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(20, 1000);
        s1.writeInfo();
        System.out.println(s1.toString());
        System.out.println(s1);

        Accountant e1 = new Accountant(30, 12000);
        e1.writeInfo();

        Teacher u1 = new Teacher(40, 20000, 22);
        u1.writeInfo();

        System.out.println("All count persons: " + Person.getCount() + ", age person u1: " + u1.age);
    }
}
