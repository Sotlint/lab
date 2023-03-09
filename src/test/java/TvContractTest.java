import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TvContractTest {
    LocalDate date = LocalDate.of(2001, 11, 1);
    LocalDate dateStart = LocalDate.of(2022, 11, 1);
    LocalDate dateEnd = LocalDate.of(2022, 11, 1);
    Person person = new Person(1,"Павел","Поваляев","Николаевич",date, Person.Gender.MALE,"0000000000" );
    TvContract contract = new TvContract(1,dateStart,dateEnd,"1234",person,"plus");
    @Test
    void getPackageChannels() {
    assertEquals("plus",  contract.getPackageChannels());
    }

    @Test
    void setPackageChannels() {
        contract.setPackageChannels("another");
        assertEquals("another",contract.getPackageChannels());
    }

    @Test
    void testToString() {
        String exp="DigitalTvContract{" +
                "id=1, startDate=2022-11-01, " +
                "endDate=2022-11-01, number='1234', " +
                "owner=Person{id=1, firstName='Павел', " +
                "lastName='Поваляев', " +
                "middleName='Николаевич', " +
                "dateOfBirth=2001-11-01, " +
                "gender=MALE, " +
                "passport='0000000000'}, " +
                "packageChannels='plus'}";
        assertEquals(exp,contract.toString());
    }
}