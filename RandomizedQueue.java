import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;
public class RandomizedQueue<Item> implements Iterable<Item>
{
    private Item[] items;
    private int size = 0;
    public RandomizedQueue() // construct an empty randomized queue
    {
        items = (Item[]) new Object[1];
    }
    public boolean isEmpty() // is the randomized queue empty?
    {
        return size == 0;
    }
    public int size() // return the number of items on the randomized queue
    {
        return size;
    }
    public void enqueue(Item item)// add the item
    {
        if (item == null)
        {
            throw new java.lang.IllegalArgumentException();
        }
        if (items.length == size)
        {
            Item[] newarray = (Item[]) new Object[size * 2];
            for (int i = 0; i < size; i++)
            {
                newarray[i] = items[i];
            }
            items = newarray;
        }
        items[size] = item;
        size++;
    }
    public Item dequeue() // remove and return a random item
    {
        if (isEmpty())
        {
            throw new java.util.NoSuchElementException();
        }
        int index = StdRandom.uniform(size);
        Item a = items[index];
        items[index] = items[size - 1];
        items[size - 1] = null;
        if (items.length >= 4 * size)
        {
            Item[] newarray = (Item[]) new Object[items.length / 2];
            for (int i = 0; i < size; i++)
            {
                newarray[i] = items[i];
            }
            items = newarray;
        }
        size--;
        return a;
    }
    public Item sample() // return a random item (but do not remove it)
    {
        if (isEmpty())
        {
            throw new java.util.NoSuchElementException();
        }
        return items[StdRandom.uniform(size)];
    }
    public Iterator<Item> iterator() // return an independent iterator over items in random order
    {
        return new ListIterator(items,size);
    }
    private class ListIterator implements Iterator<Item>
    {
        private RandomizedQueue<Item> thisone = new RandomizedQueue<Item>();
        private ListIterator(Item[] original,int size)
        {
            thisone.items = (Item[]) new Object[size];
            thisone.size = size;
            for (int i = 0; i < size; i++)
            {
                thisone.items[i] = original[i];
            }
        }
        public Item next()
        {
            if (!hasNext())
            {
                throw new java.util.NoSuchElementException();
            }
            return thisone.dequeue();
        }
        public boolean hasNext()
        {
            return !(thisone.isEmpty());
        }
    }
}
