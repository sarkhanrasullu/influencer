package teacher.entity;

import common.Person;

import java.io.Serializable;

public class Teacher extends Person  implements Serializable {

    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public Person person;

    public Teacher setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

}
