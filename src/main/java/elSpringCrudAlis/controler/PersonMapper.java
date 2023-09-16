package elSpringCrudAlis.controler;

import elSpringCrudAlis.models.Person;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {

        Person person =new Person();

        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("person_name"));
        person.setSurname(resultSet.getString("surname"));
        person.setTelephone(resultSet.getInt("telephone"));
        person.setEmail(resultSet.getString("email"));

        return person;
    }
}

