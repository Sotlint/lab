import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
class PersonTest  {
    LocalDate date = LocalDate.of(2001, 11, 1);
    Person person = new Person(1,"Павел","Поваляев","Николаевич",date, Person.Gender.MALE,"0000000000" );
    @Test
    void GetId() {

        assertEquals(1,person.getId());

    }

    @Test
    void getFirstName() {

        assertEquals("Павел",person.getFirstName());
    }

    @Test
    void getLastName() {

        assertEquals("Поваляев",person.getLastName());
    }

    @Test
    void getMiddleName() {

        assertEquals("Николаевич",person.getMiddleName());
    }

    @Test
    void getDateOfBirth() {

        assertEquals(date,person.getDateOfBirth());
    }

    @Test
    void getGenderMale() {

        assertEquals(Person.Gender.MALE,person.getGender());
    }

    @Test
    void getGenderFemale()
    {
        LocalDate date = LocalDate.of(2001, 8, 21);
        Person person1 = new Person(1,"Мария","Волкова","Сергеевна",date, Person.Gender.FEMALE,"0000000000" );
        assertEquals(Person.Gender.FEMALE,person1.getGender());
    }

    @Test
    void getPassport() {

        assertEquals("0000000000",person.getPassport());
    }

    @Test
    void getAge() {

        assertEquals(21,person.getAge());
    }

    @Test
    void testToString() {

        String exp ="Person{id=1, firstName='Павел', lastName='Поваляев', middleName='Николаевич', dateOfBirth=2001-11-01, gender=MALE, passport='0000000000'}";
        assertEquals(exp,person.toString());

    }
}