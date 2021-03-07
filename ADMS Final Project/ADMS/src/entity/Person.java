package entity;
import java.lang.*;

public class Person
{
    private String personId;
    private String password;
    private String status;
    
    public Person() {}

    public Person(String personId, String password, String status)
    {
        this.password = password;
        this.personId = personId;
        this.status = status;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPersonId() {
        return personId;
    }

    public String getPassword() {
        return password;
    }
}