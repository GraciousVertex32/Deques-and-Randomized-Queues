import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;
public class Permutation
{
    public static void main(String[] args)
    {
        RandomizedQueue<String> randomizedQueue= new RandomizedQueue<String>();
        int k = Integer.parseInt(args[0]);
        String input = StdIn.readString();
        try
        {
            while(input != null)
            {
                randomizedQueue.enqueue(input);
                input = StdIn.readString();
            }
        }
        catch (java.util.NoSuchElementException e)
        {
        }
        for(int i = 0;i<k;i++)
        {
            StdOut.println(randomizedQueue.dequeue());
        }
    }
}
