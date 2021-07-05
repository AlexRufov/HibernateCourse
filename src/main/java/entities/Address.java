package entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class Address implements Serializable {
    //@Transient
    transient String street;
    int number;

    public Address() {
    }

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return number == address.number &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number);
    }
}
