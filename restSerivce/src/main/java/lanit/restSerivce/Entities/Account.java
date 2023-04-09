package lanit.restSerivce.Entities;

public interface Account extends Entity {
    String getRole();
    void setRole(String role);
    String getSurname();
    void setSurname(String surname);
    String getFullName();
}
