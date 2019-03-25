import java.util.Iterator;

public class Iter<T> implements Iterable<T> {
    private final T[] array;
    private  final int size;

    public Iter(int size) {
        this.array = (T[])(new Object[size]);
        this.size = size;
    }

    public void put(int index, T elem){
        if(index<0||index>=this.size){
            throw new IllegalArgumentException("out of range");
        }
        this.array[index]=elem;
    }
    public T get(int index){
        if(index<0||index>=this.size){
            throw new IllegalArgumentException("out of range");
        }
       return this.array[index];
    }


    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i=0;

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public boolean hasNext() {
                if(i<size) return true;
                return false;
            }

            public T next() {
                return array[i++];
            }
        };
    }
}
