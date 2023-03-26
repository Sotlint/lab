import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class ContractRepositoryTest {
    ContractRepository repository = new ContractRepository(new MergeSorter<>());

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


    @Test
    void tsearchContract()
    {
        Contract[] testcontracts=new Contract[3];
        Contract[] testcontracts2=new Contract[3];
        repository.addContract(mobileContract);
        repository.addContract(internetContract);
        repository.addContract(tvContract);

        int ownerId1=1;
        int ownerId2=2;
        Predicate<Contract> ownerPredicate1 = c -> c.getPerson().getId() == ownerId1;
        Predicate<Contract> ownerPredicate2 = c -> c.getPerson().getId() == ownerId2;

        testcontracts=repository.getAllContracts();
        testcontracts2=repository.searchContract(ownerPredicate1);
        assertEquals(testcontracts[0],testcontracts2[0]);
        assertEquals(testcontracts[1],testcontracts2[1]);
        assertEquals(testcontracts[2],testcontracts2[2]);

        assertEquals(null,repository.searchContract(ownerPredicate2));
    }


    @Test
    void testSort()
    {
        ContractRepository repository = new ContractRepository(new MergeSorter<>());
        repository.addContract(tvContract);//id 3
        repository.addContract(internetContract); //id 2
        repository.addContract(mobileContract); // id 1

        CidComparator comparator=new CidComparator();
        repository.sort(comparator);

        Contract[] testcontracts=new Contract[3];
        testcontracts=repository.getAllContracts();

        assertEquals(mobileContract,testcontracts[0]);

        ContractRepository repository1 = new ContractRepository(new BoubleSorter<>());
        repository1.addContract(tvContract);//id 3
        repository1.addContract(internetContract); //id 2
        repository1.addContract(mobileContract); // id 1

        repository1.sort(comparator);
        Contract[] testcontracts1=new Contract[3];
        testcontracts1=repository1.getAllContracts();
        assertEquals(mobileContract,testcontracts1[0]);



    }

    @Test
    void testSortStartDate() {
        ContractRepository repository3 = new ContractRepository(new BoubleSorter<>());
        LocalDate dateStart1 = LocalDate.of(2022, 11, 1);
        LocalDate dateEnd1 = LocalDate.of(2022, 11, 1);
        MobileContract mobileContract1 = new MobileContract(1,dateStart1,dateEnd1,"1234",person,500,100,25);

        LocalDate dateStart2 = LocalDate.of(2021, 11, 1);
        LocalDate dateEnd2 = LocalDate.of(2021, 11, 1);
        InternetContract internetContract1 = new InternetContract(2,dateStart2,dateEnd2,"1234",person,100);


        LocalDate dateStart3 = LocalDate.of(2020, 11, 1);
        LocalDate dateEnd3 = LocalDate.of(2020, 11, 1);
        TvContract tvContract1 = new TvContract(3,dateStart3,dateEnd3,"1234",person,"plus");

        repository3.addContract(mobileContract1);
        repository3.addContract(internetContract1);
        repository3.addContract(tvContract1);

        StartDateComparator comparatorSdate=new StartDateComparator();

        repository3.sort(comparatorSdate);
        Contract[] testcontracts3=new Contract[3];
        testcontracts3=repository3.getAllContracts();

        assertEquals(tvContract1,testcontracts3[0]);
    }

    @Test
    void testSortEndDate() {
        ContractRepository repository3 = new ContractRepository(new BoubleSorter<>());
        LocalDate dateStart1 = LocalDate.of(2022, 11, 1);
        LocalDate dateEnd1 = LocalDate.of(2022, 11, 1);
        MobileContract mobileContract1 = new MobileContract(1,dateStart1,dateEnd1,"1234",person,500,100,25);

        LocalDate dateStart2 = LocalDate.of(2021, 11, 1);
        LocalDate dateEnd2 = LocalDate.of(2021, 11, 1);
        InternetContract internetContract1 = new InternetContract(2,dateStart2,dateEnd2,"1234",person,100);


        LocalDate dateStart3 = LocalDate.of(2020, 11, 1);
        LocalDate dateEnd3 = LocalDate.of(2020, 11, 1);
        TvContract tvContract1 = new TvContract(3,dateStart3,dateEnd3,"1234",person,"plus");

        repository3.addContract(mobileContract1);
        repository3.addContract(internetContract1);
        repository3.addContract(tvContract1);


        EndDateComparator comparatorEdate=new EndDateComparator();


        repository3.sort(comparatorEdate);
        Contract[] testcontracts3=new Contract[3];
        testcontracts3=repository3.getAllContracts();

        assertEquals(tvContract1,testcontracts3[0]);
    }


}