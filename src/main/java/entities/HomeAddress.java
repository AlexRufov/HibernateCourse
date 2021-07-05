package entities;

import javax.persistence.*;
import java.util.List;

@Entity
//@Embeddable
public class HomeAddress {
    @Id
    @GeneratedValue
    int id;
    String street;
    //@OneToOne
    @ManyToMany
    List<Person> person;

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public HomeAddress(String street) {
        this.street = street;
    }

    public HomeAddress() {
    }
}
