package database.entity;

import javax.persistence.*;

/**
 * Created by Shanshan Jiang on 4/10/2016.
 */


@Entity
@Table(name = "cb_people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    int id;

    @Column(name = "object_id", nullable = false)
    String object_id;

    @Column(name = "first_name", nullable = false)
    String first_name;

    @Column(name = "last_name", nullable = false)
    String last_name;

    @Column(name = "birthplace", nullable = true)
    String birthplace;

    @Column(name = "affiliation_name", nullable = true)
    String affiliation_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObject_id() {
        return object_id;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getAffiliation_name() {
        return affiliation_name;
    }

    public void setAffiliation_name(String affilation_name) {
        this.affiliation_name = affilation_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (!object_id.equals(person.object_id)) return false;
        if (!first_name.equals(person.first_name)) return false;
        return last_name.equals(person.last_name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + object_id.hashCode();
        result = 31 * result + first_name.hashCode();
        result = 31 * result + last_name.hashCode();
        return result;
    }
}
