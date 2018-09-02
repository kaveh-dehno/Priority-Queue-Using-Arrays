/**
 * 
 */
package assignment3;

/** An interface describing the operations of a priority queue
 * @author kaveh DEHNO
 *
 */

// public interface PriorityQueueInterface<T extends Comparable<? super T >>
public interface PriorityQueueInterface<T extends Comparable<? super T >>
{
  /** Adds a new entry to the priority queue depending on its priority
   * 
   * @param newEntry The entry to be added
   * @param priority the priority of the entry to be added
   */
  public boolean enqueue(T newEntry);
  
  /** Removes an returns the the entry at the front of the priority queue
   * 
   * @return the entry at front of the priority queue that was removed
   */
  public T dequeue();
  
  /** Retrieves the entry and front of the priority queue
   * 
   * @return the entry at front of the priority queue
   */
  public T getFront();
  
  /** Detects whether this priority queue is empty.
   * @return True if the queue is empty, or false otherwise.
   */
  public boolean isEmpty();
  
  /** Removes all entries from this priority queue.
   */
  public void clear();
  
  
  /** Retrieves the entire queue
   * 
   * @return the entire queue
   */
  public T[] toPriorityQueue();

}
