package jobsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
