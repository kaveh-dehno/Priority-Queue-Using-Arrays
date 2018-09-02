/**
 * 
 */
package assignment3;

/**
 * @author kaveh DEHNO
 *
 */
public class TestingPriorityQueue
{

  /** A class to test the functionality of the priority queue
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    PriorityQueueInterface<Integer> priorityQueue = new ArrayPriorityQueue<>();
    int[] to_be_stored = {2, 1, 4, 3, 3 , 7, 5};
    testAdd(priorityQueue, to_be_stored);
    
    System.out.println("The priority queue contains: ");
    displayQueue(priorityQueue);
    
    System.out.println("\n\nRemoving elements from the priority queue.");
    testRemove(priorityQueue);
    testRemove(priorityQueue);
    
//    System.out.println("\n\n\nhow about here");
    displayQueue(priorityQueue);
//    System.out.println("\n\n\nbut not here");
    
    System.out.println("\n\nThe front element of the priority queue is: \n" + front(priorityQueue));
    
    
    System.out.println("\n\nclearing the priority queue.");
    clearQueue(priorityQueue);
    displayQueue(priorityQueue);
    
    System.out.println("\n\nRemoving elements from an empty priority queue.\n\n\n");
    testRemove(priorityQueue);
  }
  
  private static void testAdd(PriorityQueueInterface<Integer> pQueue, int[] content)
  {
    System.out.println("Adding the following " + content.length +
        " integer(s) to the queue.");
    for (int index = 0; index < content.length; index++)
    {
      if (pQueue.enqueue(content[index]))
        System.out.print(content[index] + ", ");
      else
        System.out.print("\nUnable to add " + content[index] + " to the priority queue.");
    }
    
    System.out.println();
    System.out.println();

  }
  
  private static void displayQueue(PriorityQueueInterface<Integer> pQueue)
  {
    Object[] queueArray = pQueue.toPriorityQueue();
    
//    System.out.println("\n\n\nlength of the queue: " + queueArray.length);
    int iteration = queueArray.length;
    for (int index = 0; index < iteration; index++)
    {
 //     index++;
      if (queueArray[index] == null)
      {
//        iteration++;
//      System.out.print("\n\niteration: " + iteration);
//        System.out.print("\n\n\nindex:: " + index +  " " );
      }
     else if (queueArray[index] != null)
        {
//       System.out.print("\n\n\nindex:: " + index +  " " );
          System.out.print(queueArray[index] + ", ");
          
        }
 //     index++;
   
    }
    System.out.println("\nDisplay ended");
  }
  
  private static void testRemove(PriorityQueueInterface<Integer> pQueue)
  {
    pQueue.dequeue();
//    System.out.println("\n\n\ndoes it end here");
  }
  
  private static void clearQueue(PriorityQueueInterface<Integer> pQueue)
  {
    pQueue.clear();
  }
  
  private static int front(PriorityQueueInterface<Integer> pQueue)
  {
    
    return pQueue.getFront();
  }

}
