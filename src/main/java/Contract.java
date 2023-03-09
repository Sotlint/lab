import java.time.LocalDate;
public abstract class Contract {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String contractNumber;
    private Person owner;

    /**
     * Создает новый контракт
     * @param id ID контракта
     * @param startDate дата начала контракта
     * @param endDate дата окончания контракта
     * @param contractNumber номер контракта
     * @param owner владелец контракта
     */
    public Contract(int id, LocalDate startDate, LocalDate endDate, String contractNumber, Person owner) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractNumber = contractNumber;
        this.owner = owner;
    }
    public int getId() {
        return id;
    }
    public String getContractNumber() {
        return contractNumber;
    }
    public  LocalDate getStartDate()
    {
        return startDate;
    }

    public  LocalDate getEndDate()
    {
        return endDate;
    }

    public Person getPerson()
    {
        return owner;
    }
}
