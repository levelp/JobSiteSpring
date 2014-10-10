package jobsite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 *
 */
@Entity
public class User2 {

    @Id
    @GeneratedValue
    public Long id;

    @Column
    public String name;

    @Column(length = 1024)
    public String surname;

    @Column(nullable = false)
    public int age;
}
