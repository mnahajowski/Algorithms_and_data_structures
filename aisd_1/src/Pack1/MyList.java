package Pack1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import java.util.NoSuchElementException;

public class MyList <T> implements Iterable <T>{

	private Object[] data;
	private int default_size;
	private int size;
	
	public MyList(T [] data, int default_size) {
		this.data = data;
		this.size = default_size;
	}
	
	public int size() {
		return size;
	}
	
	
	public boolean contains(T o1) {
		Iterator<T> iter=this.iterator();
		while(iter.hasNext()) {
			T item = iter.next();
			if(item == o1)
				return true;
		}
		return false;
		
	}
	
	public int indexOf(T o1) {
		Iterator<T> iter=this.iterator();
		int counter = 0;
		while(iter.hasNext()) {
			T item = iter.next();
			counter++;
			if(item == o1)
				return counter; 
		}
		return -1;
		
	}
	
	public Object get(int indexOf) throws NoSuchElementException {
		if(data[indexOf] != null)
			return data[indexOf];
		else
			throw new NoSuchElementException();
	}
	
	public void set(int indexOf, T o1)  throws NoSuchElementException{
		if(data[indexOf] != null)
			data[indexOf] = o1;
		else
			throw new NoSuchElementException();
	}
	
	public void add(T o1) {
		Iterator<T> iter = this.iterator();
		int counter = 0;
		while(iter.hasNext() && iter.next() != null) {
			counter++;
		}
		if(counter >= size) {
			Object [] data1 = Arrays.copyOf(data, size*2);
			data1[size] = o1;
			size*=2;
			data = data1;
		}
		else {
			data[counter] = o1;
		}
	}
	
	public void remove(int indexOf) {
		for(int i = indexOf; i < size-1; i++) {
			data[i] = data[i+1];
		}
		data[size-1] = null;
	}

	public boolean isEmpty() {
		Iterator<T> iter=this.iterator();
		while(iter.hasNext()) {
			if(iter.next() != null)
				return false;
		}
		return true;
		
	}
	

	
	public void clear() {
		for(int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;
	}
	
	public void show() {
		Iterator<T> iter = this.iterator();
		while(iter.hasNext()) {
			T item = iter.next();
			if(item != null)
				System.out.println(item);
			else
				break;	
		}	
	}
	
	
	@Override
    public Iterator<T> iterator(){
        Iterator<T> iterator = new Iterator<T>() {
        	
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
            	return currentIndex < data.length;
            }
            


            @Override
            public T next() throws NoSuchElementException{
            	if(hasNext()) {
            		return (T)data[currentIndex++];
            	}
            	else
            		throw new NoSuchElementException();
            	
            }
            

            @Override
            public void remove(){
            	MyList.this.remove(currentIndex);
            }
        };

        return iterator;
    }
	
	
}
