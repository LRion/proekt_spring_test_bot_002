package elSpringCrudAlis.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    // Устанавливаем правила @Valid

    @NotEmpty(message = "Name should not be empty") // нужна что бы в поле не было устого значения(null или росто устое значение
    @Size(min = 2, max = 30, message = "Name should be between 2 - 30 charters")  // устанавливаем длину строки
    private String name;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 30, message = "Surname should be between 2 - 30 charters ")
    private String surname;

    @Min(value = 0, message = "Telephone should be greater than 0")
   // @Size(min = 9, max = 9, message = "Surname should be 9 charters ")
    private int telephone;


    @NotEmpty(message = "Email should not be empty")
    @Size(min = 4, max = 30, message = "Surname should be between 2 - 30 charters ")
    @Email(message = " Email should be valid")
    private String email;

    public Person() {
    }

    public Person(int id, String name, String surname,int telephone, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
