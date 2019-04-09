package no.oslomet.data.models;

import no.oslomet.common.api.User;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDatabaseImpl implements User {

    @Id
    private String id;
    private String password;
    private String firstName;
    private String lastName;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return null;
    }

    public String getTweeterId() {
        return null;
    }
}
