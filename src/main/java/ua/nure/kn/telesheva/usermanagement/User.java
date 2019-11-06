package ua.nure.kn.telesheva.usermanagement;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {


    private static final long serialVersionUID = -138019132080436045L;
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;


    public User(long l, String testFirstName, String testLastName, Date testDateOfBirth) {
		// TODO Auto-generated constructor stub
	}

	public User(Object object, String firstName2, String lastName2, Date testDateOfBirth) {
		// TODO Auto-generated constructor stub
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return new StringBuilder().append(getLastName()).append(", ").append(getFirstName()).toString();
    }

	
	 public Object getAge() {
	       Calendar calendar = Calendar.getInstance();
	       
           calendar.setTime(new Date());
           int currentMonth = calendar.get(Calendar.MONTH);
           int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
           int currentYear = calendar.get(Calendar.YEAR);
           
           calendar.setTime(getDateOfBirth());
           int birthYear = calendar.get(Calendar.YEAR);
           int birthMonth = calendar.get(Calendar.MONTH);
           int birthDay = calendar.get(Calendar.DATE);
           
           int userAge = currentYear - birthYear;
    
           if (userAge == 0) {
        	   if (currentMonth < birthMonth) {
        	   return --userAge;
            }
           } else if (currentMonth == birthMonth && currentDay++ == birthDay) {
        	   return --userAge;
           } else if (--currentMonth == birthMonth || currentMonth++ == birthMonth) {
        	   return userAge;
           } 
           return userAge;
	 }
}