import java.util.Iterator;
import java.util.ListIterator;
public class Deque<Item> implements Iterable<Item>
{
    private node first;
    private node last;
    private int n = 0;
    private class node
    {
        Item contain;
        node next;
        node previous;
    }
    public Deque()
    {

    }// construct an empty deque
    public boolean isEmpty()
    {
        return n == 0;
    }// is the deque empty?
    public int size()
    {
        return n;
    }// return the number of items on the deque
    public void addFirst(Item item)
    {
        if(item == null)
        {
            throw new java.lang.IllegalArgumentException();
        }
        node oldfirst = first;
        first = new node();
        first.contain = item;
        if(oldfirst != null)
        {
            first.previous = oldfirst;
            oldfirst.next = first;
        }
        if(oldfirst == null)
        {
            last = first;
        }
        n++;
    }// add the item to the front
    public void addLast(Item item)
    {
        if(item == null)
        {
            throw new java.lang.IllegalArgumentException();
        }
        node oldlast = last;
        last = new node();
        last.contain = item;
        if(oldlast != null)
        {
            last.next = oldlast;
            oldlast.previous = last;
        }
        if(oldlast == null)
        {
            first = last;
        }
        n++;
    }// add the item to the end
    public Item removeFirst()
    {
        if(n ==0)
        {
            throw new java.util.NoSuchElementException();
        }
        n--;
        Item t = first.contain;
        if(first.previous != null)
        {
            first = first.previous;
            first.next = null;
        }
        else
        {
            first = null;
            last = first;
        }
        return t;
    }// remove and return the item from the front
    public Item removeLast()
    {
        if(n ==0)
        {
            throw new java.util.NoSuchElementException();
        }
        n--;
        Item t = last.contain;
        if(last.next != null)
        {
            last = last.next;
            last.previous = null;
        }
        else
        {
            last = null;
            first = last;
        }
        return t;
    }
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private node current = first;
        public boolean hasNext()
        {
            return current != null;
        }
        public Item next()
        {
            if(!hasNext())
            {
                throw new java.util.NoSuchElementException();
            }
            Item item = current.contain;
            current = current.previous;
            return item;
        }
        public void remove()
        {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
