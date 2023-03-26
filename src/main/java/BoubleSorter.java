import java.util.Comparator;
public class BoubleSorter<T> implements ISorter<T>
{
    public void sort(T[] array, Comparator<T> comparator)
    {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++)
            {
                if (comparator.compare(array[i - 1], array[i]) > 0)
                {
                    T temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
