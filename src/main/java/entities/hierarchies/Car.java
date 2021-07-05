package entities.hierarchies;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@MappedSuperclass
//@OptimisticLocking(type = OptimisticLockType.NONE)
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//@NamedQueries(@org.hibernate.annotations.NamedQuery(name = "getCarByNumber", query = "select c from Car c where c.number = :number"))
public class Car {
    @Id
    @GeneratedValue
    private int id;
    private String number;
    @Version
    int version;

    public Car() {}
    public Car(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
