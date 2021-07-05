package entities;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    //@OneToOne(mappedBy = "person")
    //@JoinColumn(name = "homeId")
    //@OneToMany(mappedBy = "person")
//    @JoinTable(
//            joinColumns = @JoinColumn(name = "personId"),
//            inverseJoinColumns = @JoinColumn(name = "homeId")
//    )
    //@OrderBy("street")
    //@OrderColumn
//    @SortComparator(MyComparator.class)
    @ManyToMany
    private List<HomeAddress> homeAddress;

    //@ElementCollection
    //private List<HomeAddress> homeAddress;
    @NaturalId
    private String iCode;

    public Person(String name, List<HomeAddress> homeAddress) {
        this.name = name;
        this.homeAddress = homeAddress;
    }

    public Person() {
    }

    public Person(String name, List<HomeAddress> homeAddress, String iCode) {
        this.name = name;
        this.homeAddress = homeAddress;
        this.iCode = iCode;
    }
}
