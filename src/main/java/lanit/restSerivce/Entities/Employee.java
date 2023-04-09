package lanit.restSerivce.Entities;

import java.util.UUID;

public class Employee implements Account {

    public final UUID id;
    private String name = "";
    private String role = "";
    private String surname = "";
    private String fullName;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        this.fullName = this.name + " " + this.surname;
    }

    @Override
    public String getRole() {
        return this.role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
        this.fullName = this.name + " " + this.surname;
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    public Employee(String name, String surname) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.fullName = name + " " + surname;
    }
}
