import java.util.Comparator;
public interface ISorter<Contract> {
    void sort(Contract[] array, Comparator<Contract> comparator);
}
