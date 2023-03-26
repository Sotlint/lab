
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.Comparator;
public class ContractRepository
{
    private Contract[] contracts;
    private int size;

    ISorter<Contract> sorter;



    public void sort(Comparator<Contract> comparator) {
            sorter.sort(contracts, comparator);
    }


    /**
     * Создает новый репозиторий для контрактов
     */
    public ContractRepository(ISorter<Contract> sorter)
    {
        this.sorter = sorter;
        size = 0;
        contracts = new Contract[size];
    }

    /**
     * Проверка id до добавления контракта в репозиторий
     * @param contract контракт для добавления
     * @return true, если контракт с таким id уже есть в репозитории, false если такого id нет
     */
    public boolean checkID(Contract contract)
    {
        for (int i = 0; i < size; i++)
        {
            if (contracts[i].getId() == contract.getId())
            {
                return true;
            }

        }
        return false;
    }


    /**
     * Добавляет контракт в репозиторий
     * @param contract контракт для добавления
     * @return true, если контракт добавлен, иначе false
     */
    public boolean addContract(Contract contract)
    {
        if (size == contracts.length)
        {
            contracts = Arrays.copyOf(contracts, contracts.length + 1);
        }

            if(!checkID(contract)) {
                contracts[size++] = contract;
                return true;
            }
            else
            {
                return false;
            }
    }

    /**
     * Удаляет контракт из репозитория по ID
     * @param id ID контракта для удаления
     * @return true, если контракт был удален, false, если контракт не найден
     */
    public boolean removeContractById(int id)
    {
        for (int i = 0; i < size; i++)
        {
            if (contracts[i].getId() == id)
            {
                System.arraycopy(contracts, i + 1, contracts, i, size - i - 1);
                size--;
                contracts[size] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Получает контракт из репозитория по ID
     * @param id ID контракта для получения
     * @return контракт с указанным ID, или null, если контракт не найден
     */
    public Contract getContractById(int id)
    {
        for (int i = 0; i < size; i++)
        {
            if (contracts[i].getId() == id)
            {
                return contracts[i];
            }
        }
        return null;
    }

    /**
     * Получает все контракты в репозитории
     * @return массив всех контрактов в репозитории
     */
    public Contract[] getAllContracts()
    {
        return contracts;
    }


    public Contract[] searchContract(Predicate<Contract>... predicates)
    {
        int size = 0;
        Contract[] findContracts = new Contract[size];

        for (Contract contract : contracts) {

            for (Predicate<Contract> predicate : predicates) {
                if (predicate.test(contract)) {
                    if (size == findContracts.length) {
                        findContracts = Arrays.copyOf(findContracts, findContracts.length + 1);
                    }
                    findContracts[size++] = contract;
                }
            }
        }
            if(size>=1) {
                return findContracts;
            }
            else
            {
                return null;
            }


    }



}
