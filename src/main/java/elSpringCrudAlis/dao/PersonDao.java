package elSpringCrudAlis.dao;

import elSpringCrudAlis.controler.PersonMapper;
import elSpringCrudAlis.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {


    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // Выводим данные из базы
    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM Person",new PersonMapper());
    }
    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?",new Object[]{id},
                new PersonMapper()).stream().findAny().orElse(null);
    }

    // Добавляем новые данные базу данных
   public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person VALUES(1,?,?,?,?)",
               person.getName(),person.getSurname(),person.getTelephone(),person.getEmail());
    }

   public void update(int id, Person personUpdate){
            jdbcTemplate.update("UPDATE Person SET person_name=?, surname=?, telephone=?, email=? WHERE id=?",
                    personUpdate.getName(),personUpdate.getSurname(),
                    personUpdate.getTelephone(),personUpdate.getEmail(), id);
   }

    public void deletePerson(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

}

