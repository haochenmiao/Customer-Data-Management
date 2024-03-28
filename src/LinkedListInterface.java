/**
 * @param <E>   Generic Type
 * @Author      Haochen Miao
 * @version     2/14/2023
 */
public interface LinkedListInterface<E> {

    /**
     * Retrieves the matching existing value given a search value.
     * While this may seem odd, we need to remember that "matching" might mean
     * different things to different clients, and that sometimes a dummy lookup
     * object can contain little information, perhaps only an ID, that can serve
     * as a lookup for the existing element of interest.
     *
     * @param value     the value to look up
     * @return          a reference to an existing element, or null if not found
     */
    public E get(E value);
}
