import java.time.LocalDate;
import java.time.Period;

public class Person {
    private int id;
    private  String firstName;
    private String lastName;
    private  String middleName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String passport;


    public Person(int id, String firstName, String lastName, String middleName, LocalDate dateOfBirth, Gender gender, String passport) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.passport = passport;
    }

    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", passport='" + passport + '\'' +
                '}';
    }

    public enum Gender {
        MALE,
        FEMALE
    }

    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public Gender getGender()
    {
        return gender;
    }

    public String getPassport()
    {
        return passport;
    }

    public int getAge()
    {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }


}
