import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InternetContractTest {

    LocalDate date = LocalDate.of(2001, 11, 1);
    LocalDate dateStart = LocalDate.of(2022, 11, 1);
    LocalDate dateEnd = LocalDate.of(2022, 11, 1);
    Person person = new Person(1,"Павел","Поваляев","Николаевич",date, Person.Gender.MALE,"0000000000" );
    InternetContract contract = new InternetContract(1,dateStart,dateEnd,"1234",person,100);
    @Test
    void getId() {

        assertEquals(1,contract.getId());
    }

    @Test
    void getContractNumber() {
        assertEquals("1234",contract.getContractNumber());
    }

    @Test
    void getStartDate() {
        assertEquals(dateStart,contract.getStartDate());
    }

    @Test
    void getEndDate() {
        assertEquals(dateEnd,contract.getEndDate());
    }

    @Test
    void getPerson() {
        assertEquals(person,contract.getPerson());
    }

    @Test
    void getSpeed() {
        assertEquals(100,contract.getSpeed());
    }

    @Test
    void setSpeed() {
       contract.setSpeed(200);
       assertEquals(200,contract.getSpeed());

    }

    @Test
    void testToString() {
        String exp = "WiredInternetContract{" +
                "id=1, " +
                "startDate=2022-11-01, " +
                "endDate=2022-11-01, " +
                "number='1234', " +
                "owner=Person{" +
                "id=1, " +
                "firstName='Павел', " +
                "lastName='Поваляев', " +
                "middleName='Николаевич', " +
                "dateOfBirth=2001-11-01, " +
                "gender=MALE, " +
                "passport='0000000000'}, " +
                "speed=100}";

        assertEquals(exp,contract.toString());
    }
}