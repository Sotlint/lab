import java.util.Comparator;

public class CidComparator implements Comparator<Contract> {
    @Override
    public int compare(Contract o1, Contract o2) {
        return o1.getId()-o2.getId();
    }
}
