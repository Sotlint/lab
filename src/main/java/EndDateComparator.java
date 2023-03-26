import java.util.Comparator;
public class EndDateComparator  implements Comparator<Contract>{
    @Override
    public int compare(Contract o1, Contract o2) {
        return o1.getEndDate().compareTo(o2.getEndDate());
    }
}
