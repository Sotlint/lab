import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ContractRepositoryTest {
    ContractRepository repository = new ContractRepository();

        LocalDate date = LocalDate.of(2001, 11, 1);
        Person person = new Person(1,"Павел","Поваляев","Николаевич",date, Person.Gender.MALE,"0000000000" );
        LocalDate dateStart = LocalDate.of(2022, 11, 1);
        LocalDate dateEnd = LocalDate.of(2022, 11, 1);
        MobileContract mobileContract = new MobileContract(1,dateStart,dateEnd,"1234",person,500,100,25);
        InternetContract internetContract = new InternetContract(2,dateStart,dateEnd,"1234",person,100);
        TvContract tvContract = new TvContract(3,dateStart,dateEnd,"1234",person,"plus");



    @Test
    void addContract() {

        assertEquals(true,repository.addContract(tvContract));
        assertEquals(true,repository.addContract(mobileContract));
        assertEquals(true,repository.addContract(internetContract));
        assertEquals(false,repository.addContract(internetContract));

    }

    @Test
    void removeContractById() {
        repository.addContract(mobileContract);
        repository.addContract(internetContract);
        repository.addContract(tvContract);

        assertEquals(true,repository.removeContractById(1));
        assertEquals(false,repository.removeContractById(15));

    }


    @Test
    void getContractById() {
        repository.addContract(mobileContract);
        repository.addContract(internetContract);
        repository.addContract(tvContract);
        assertEquals(mobileContract,repository.getContractById(1));
        assertEquals(tvContract,repository.getContractById(3));
        assertEquals(internetContract,repository.getContractById(2));
        assertNull(repository.getContractById(10));
    }

    @Test
    void getAllContracts() {
        repository.addContract(mobileContract);
        repository.addContract(internetContract);
        repository.addContract(tvContract);


        Contract[] contract=new Contract[3];
        contract=repository.getAllContracts();

        assertEquals(contract[0],mobileContract);
        assertEquals(contract[1],internetContract);
        assertEquals(contract[2],tvContract);
    }
}