package entities;

import Enums.Days;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "Stud")
public class Student {
//    @Id
//    @GeneratedValue
//    private int id;

    //@Basic(optional = false, fetch = FetchType.LAZY)
    //@Column(name = "StudentName", unique = true, nullable = false, updatable = false)
    //@Type(type = "text")
    private String name;

    @Enumerated(EnumType.STRING)
    private Days days;

    //@Temporal(TemporalType.DATE)
    @CreationTimestamp
    //@UpdateTimestamp
    private Date date;

    private int age = 20;

    @Formula("id + age")
    private int idPlusAge;

    @EmbeddedId
    private Address address;


    public Student() {
    }

    public Student(String name, Days days) {
        this.name = name;
        this.days = days;
    }

    public Student(String name, Days days, Date date) {
        this.name = name;
        this.days = days;
        this.date = date;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }

    public int getIdPlusAge() {
        return idPlusAge;
    }

    public void setIdPlusAge(int idPlusAge) {
        this.idPlusAge = idPlusAge;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
