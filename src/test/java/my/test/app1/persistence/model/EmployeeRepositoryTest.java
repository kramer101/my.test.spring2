package my.test.app1.persistence.model;

import my.test.app1.persistence.EmployeeRepository;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Configuration
@EnableJpaRepositories(basePackages = {"my.test.app1.persistence"})
@EntityScan(basePackages = {"my.test"})
@Import({ DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldSaveAndFetch() {

        Employee employee = new Employee();
        employee.setEmployeeId("1");
        employee.setName("Abc");

        Country country = new Country();
        country.setName("USA");
        employee.setCountries(Lists.newArrayList(country));

        employeeRepository.save(employee);

        assertThat(employeeRepository.findAll()).isNotEmpty();

        assertThat(
            employeeRepository.findOne("1").getCountries()).isNotEmpty();

        Employee employeeFetched = employeeRepository.findOne("1");

        Country country1 = new Country();
        country1.setName("Canada");

        List<Country> employeeCountries = Lists.newArrayList(employeeFetched.getCountries());
        employeeCountries.add(country1);

        employeeFetched.setCountries(employeeCountries);
        employeeRepository.save(employeeFetched);

        assertThat(
                employeeRepository.findOne("1").getCountries()).size().isEqualTo(2);

        employeeRepository.deleteAll();
        assertThat(employeeRepository.findAll()).isEmpty();
    }
}