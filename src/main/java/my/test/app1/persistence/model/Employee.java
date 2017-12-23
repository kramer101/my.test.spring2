package my.test.app1.persistence.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "my_employee")
public class Employee implements Serializable {


    @Id
    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "name")
    private String name;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "employee_countries")
    private List<Country> countries;


    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
