package database.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Shanshan Jiang on 4/10/2016.
 */

@Entity
@Table(name = "cb_degrees")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    int id;

    @Column(name = "object_id", nullable = false)
    String object_id;

    @Column(name = "degree_type", nullable = false)
    String degree_type;

    @Column(name = "subject", nullable = true)
    String subject;

    @Column(name = "institution", nullable = true)
    String institution;

    @Column(name = "graduated_at", nullable = true)
    Timestamp graduated_at;

    @Column(name = "created_at", nullable = true)
    Timestamp created_at;

    @Column(name = "updated_at", nullable = true)
    Timestamp updated_at;

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

    public String getDegree_type() {
        return degree_type;
    }

    public void setDegree_type(String degree_type) {
        this.degree_type = degree_type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Timestamp getGraduated_at() {
        return graduated_at;
    }

    public void setGraduated_at(Timestamp graduated_at) {
        this.graduated_at = graduated_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Degree degree = (Degree) o;

        if (id != degree.id) return false;
        if (!object_id.equals(degree.object_id)) return false;
        return degree_type.equals(degree.degree_type);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + object_id.hashCode();
        result = 31 * result + degree_type.hashCode();
        return result;
    }
}
