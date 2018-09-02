/**
 * 
 */
package assignment3;

import java.util.EmptyStackException;

/** A class that implements the priority queue interface using an array
 * @author kaveh DEHNO
 *
 */
// public final class ArrayPriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T>
public final class ArrayPriorityQueue<T extends Object & Comparable<T>> implements PriorityQueueInterface<T>
{

  private T[] priorityQueue;
  
  private int frontIndex;
  private int backIndex;
  private boolean initialized = false;
  private static final int DEFAULT_CAPACITY = 10;
  private static final int MAX_CAPACITY = 10000;
  private int numberOfEntries = 0;
//  private int priority;
  
  
  public ArrayPriorityQueue()
  {
    this(DEFAULT_CAPACITY);
  }
  
  public ArrayPriorityQueue(int initialCapacity)
  {
    checkCapacity(initialCapacity);
    
    @SuppressWarnings("unchecked")
    T[] tempPriorityQueue = (T[]) new Object[initialCapacity + 1];
    priorityQueue = tempPriorityQueue;
    frontIndex = 0;
    backIndex = initialCapacity; 
    initialized = true;
  }
  
  
  /* (non-Javadoc)
   * @see assignment3.PriorityQueueInterface#enqueue(java.lang.Object, int)
   */
  public boolean enqueue(T newEntry)
  {
    // TODO Auto-generated method stub
    checkInitialization();
    ensureCapacity();
 //   int priority2 = compareTo(newEntry);
    

        backIndex = (backIndex +1) % priorityQueue.length;
        

        if (numberOfEntries == 0)
        {
  //        backIndex = (backIndex + 1) % priorityQueue.length;
          priorityQueue[backIndex] = newEntry; 
          numberOfEntries++;
          return true;
        }
        else
        {   

          
/*          T result;
          int index = 0;
          while ( (result <= 0) && index < numberOfEntries)
          {
            
          }
          */
            for (int index = 0; index < numberOfEntries; )
            {
              
     //         System.out.println(" entre the for loop");
              
              
              T result = priorityQueue[index];
 //             System.out.println("Priority number is: " + result);
              

              
//              System.out.println("  result is: " + result.compareTo(newEntry));
              if( result.compareTo(newEntry) >= 0)
              {
                makeRoom(index);
//                System.out.println("enters if");
//                System.out.println("making room with index of: "+ index);
                
  //              backIndex = (backIndex + 1) % priorityQueue.length;
                priorityQueue[index] = newEntry;
                numberOfEntries++;
                ensureCapacity();
                
//                System.out.println("\n\n\nbackIndex is: " + backIndex);
                
                return true;
              }
              

              else if (result.compareTo(newEntry) <= 0)
                  index++;
/*              for ( int index2 = 0; index2 < numberOfEntries; index2++)
                */

      //        }
//              System.out.println("iteration: "+ index);

            }
//            backIndex = (backIndex + 1) % priorityQueue.length;
//            System.out.println("\n\n\nbackIndex is: " + backIndex);
            priorityQueue[backIndex] = newEntry;
            numberOfEntries++;
            ensureCapacity();
            return true;
        }
        
 //       return false;
        
        


  }

  
  /* (non-Javadoc)
   * @see assignment3.PriorityQueueInterface#dequeue()
   */
  public T dequeue()
  {
    // TODO Auto-generated method stub
    checkInitialization();
    if (isEmpty())
      throw new EmptyStackException();
    else
    {
//      System.out.println("\n\n else excecuted");
      T front = priorityQueue[frontIndex];
      priorityQueue[frontIndex] = null;
      frontIndex = (frontIndex + 1) % priorityQueue.length;
//      numberOfEntries--;
      
      
//      System.out.println("\n\n\nhere");
      return front;
    }
  }

  /* (non-Javadoc)
   * @see assignment3.PriorityQueueInterface#getFront()
   */
  public T getFront()
  {
    // TODO Auto-generated method stub
    checkInitialization();
    if (isEmpty())
      throw new EmptyStackException();
    else
      return priorityQueue[frontIndex];
  }

  /* (non-Javadoc)
   * @see assignment3.PriorityQueueInterface#isEmpty()
   */
  public boolean isEmpty()
  {
    // TODO Auto-generated method stub
 //   boolean result = frontIndex == (backIndex + 1) % priorityQueue.length;
 //   System.out.println("\n\nisEmpty returns " + result);
    
 //   System.out.println("\n\nfront index is: " + frontIndex);
 //   System.out.println("\n\nbackindex is: " + backIndex);
    return frontIndex == (backIndex + 1) % priorityQueue.length;
  }

  /* (non-Javadoc)
   * @see assignment3.PriorityQueueInterface#clear()
   */
  public void clear()
  {
    // TODO Auto-generated method stub
    
    for ( int index = 0; index < priorityQueue.length; index++)
    {
      priorityQueue[index] = null;

    }
    
    frontIndex = 0;
    backIndex = priorityQueue.length - 1;
  }

  /**
   * ensures that the provided capacity is less than the maximum capacity.
   * @param initialCapacity is the requested capacity of the priority queue array 
   * @return true if the requested capacity is less than maximum capacity.
   */
  private boolean checkCapacity(int initialCapacity)
  {
    return initialCapacity <= MAX_CAPACITY;
  }
  
  /**
   * Checks whether the priority queue has been created properly.
   */
  private void checkInitialization()
  {
    if (!initialized)
      throw new SecurityException("The priority queue has not been initialized proparly.");
  }
  
  /**
   * Doubles the size of priority queue if it is full.
   */
  private void ensureCapacity()
  {
   if (frontIndex == ((backIndex + 2) % priorityQueue.length))
   {
     T[] oldQueue = priorityQueue;
     int oldSize = oldQueue.length;
     int newSize = oldSize * 2;
     checkCapacity(newSize);
     
     @SuppressWarnings("unchecked")
    T[] tempQueue = (T[]) new Object[newSize];
     priorityQueue = tempQueue;
     for (int index = 0; index < oldSize - 1; index++)
     {
       priorityQueue[index] = oldQueue[frontIndex];
       frontIndex = (frontIndex + 1) % oldSize;
     }
     
     frontIndex = 0;
     backIndex = oldSize - 2;
   }
  }

  public T[] toPriorityQueue()
  {
    @SuppressWarnings("unchecked")
    T[] result_queue = (T[]) new Object[numberOfEntries];
    for (int index = 0; index < numberOfEntries; index++)
    {
      result_queue[ index ] = priorityQueue[index];
    }
    
    return result_queue;
  }
/*  
  public int compareTo(T anEntry) 
  {
    T currentPosition = priorityQueue[0];
    
    while ( (currentPosition != null) && (anEntry.compareTo(currentPosition > 0)) )
    {
      
    }
  }*/
  
  private void makeRoom(int newPosition)
  {
    int newIndex = newPosition;
    int lastIndex = numberOfEntries;
    for (int index = lastIndex; index >= newIndex; index--)
    {
      priorityQueue[index + 1] = priorityQueue[index];
    }
  }

}
