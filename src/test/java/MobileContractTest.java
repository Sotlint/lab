import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MobileContractTest {
    LocalDate date = LocalDate.of(2001, 11, 1);
    LocalDate dateStart = LocalDate.of(2022, 11, 1);
    LocalDate dateEnd = LocalDate.of(2022, 11, 1);
    Person person = new Person(1,"Павел","Поваляев","Николаевич",date, Person.Gender.MALE,"0000000000" );
    MobileContract contract = new MobileContract(1,dateStart,dateEnd,"1234",person,500,100,25);
    @Test
    void getMinutes() {
        assertEquals(500,contract.getMinutes());
    }

    @Test
    void setMinutes() {
        contract.setMinutes(1000);
        assertEquals(1000,contract.getMinutes());
    }

    @Test
    void getSms() {
        assertEquals(100,contract.getSms());
    }

    @Test
    void setSms() {
        contract.setSms(10);
        assertEquals(10,contract.getSms());
    }

    @Test
    void getGb() {
        assertEquals(25,contract.getGb());
    }

    @Test
    void setGb() {
        contract.setGb(10);
        assertEquals(10,contract.getGb());
    }

    @Test
    void testToString() {
        System.out.println(contract.toString());
        String exp="MobileContract{" +
                "id=1, " +
                "startDate=2022-11-01, " +
                "endDate=2022-11-01, " +
                "number='1234', " +
                "owner=Person{id=1, " +
                "firstName='Павел', " +
                "lastName='Поваляев', " +
                "middleName='Николаевич', " +
                "dateOfBirth=2001-11-01, " +
                "gender=MALE, " +
                "passport='0000000000'}, " +
                "minutes=500, " +
                "sms=100, " +
                "gb=25}";
        assertEquals(exp,contract.toString());
    }
}