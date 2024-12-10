package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {

  private CustomQueue<Integer> queue;

  @BeforeEach
  void setUp() {
    queue = new CustomQueue<>();
  }

  @Test
  void testIsEmpty() {
    assertTrue(queue.isEmpty(), "Queue should be empty initially");
  }

  @Test
  void testEnqueue() {
    queue.enqueue(10);
    assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
    assertEquals(1, queue.size(), "Queue size should be 1 after one enqueue");
  }

  @Test
  void testEnqueueMultipleElements() {
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    assertEquals(3, queue.size(), "Queue size should be 3 after three enqueues");
  }

  @Test
  void testDequeue() {
    queue.enqueue(10);
    queue.enqueue(20);
    int dequeued = queue.dequeue();
    assertEquals(10, dequeued, "Dequeued element should be the first enqueued element");
    assertEquals(1, queue.size(), "Queue size should decrease after dequeue");
  }

  @Test
  void testDequeueFromEmptyQueue() {
    assertThrows(IllegalStateException.class, queue::dequeue, "Dequeuing from an empty queue should throw an exception");
  }

  @Test
  void testPeek() {
    queue.enqueue(10);
    queue.enqueue(20);
    int front = queue.peek();
    assertEquals(10, front, "Peek should return the first enqueued element");
    assertEquals(2, queue.size(), "Queue size should remain unchanged after peek");
  }

  @Test
  void testPeekFromEmptyQueue() {
    assertThrows(IllegalStateException.class, queue::peek, "Peeking into an empty queue should throw an exception");
  }

  @Test
  void testClear() {
    queue.enqueue(10);
    queue.enqueue(20);
    queue.clear();
    assertTrue(queue.isEmpty(), "Queue should be empty after clear");
    assertEquals(0, queue.size(), "Queue size should be 0 after clear");
  }

  @Test
  void testEnqueueNullElement() {
    assertThrows(NullPointerException.class, () -> queue.enqueue(null), "Enqueuing null should throw a NullPointerException");
  }
}
