package cleanupTest;

/**
 * Created by Jo_seungwan on 2017. 4. 23..
 */

@FunctionalInterface
public interface UseInstance<T, X extends Throwable> {
    void accept(T instance) throws X;
}
