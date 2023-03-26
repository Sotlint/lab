import java.util.Comparator;
public class StartDateComparator  implements Comparator<Contract>{
    @Override
    public int compare(Contract o1, Contract o2) {
        return o1.getStartDate().compareTo(o2.getStartDate());
    }
}
