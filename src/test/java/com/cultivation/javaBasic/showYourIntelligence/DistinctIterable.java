package com.cultivation.javaBasic.showYourIntelligence;


import java.util.*;

public class DistinctIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    public DistinctIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        this.forEach(result::add);
        return result;
    }
}

class DistinctIterator<E> implements Iterator<E> {
    // TODO: Implement the class to pass the test. Note that you cannot put all items into memory or you will fail.
    // <--start
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Iterator<E> iterator;
    private int size = 0;
    private List<E> distincList = new ArrayList<E>();
    private int currntIndex = 0;

    DistinctIterator(Iterator<E> iterator) {
        while (iterator.hasNext()) {
            E value = iterator.next();
            if (!distincList.contains(value)) {
                distincList.add(value);
            }
        }
        this.iterator = iterator;
        this.size = distincList.size();
    }

    @Override
    public boolean hasNext() {
        return currntIndex < size;
    }

    @Override
    public E next() {
        return distincList.get(currntIndex++);
    }
    // --end->
}