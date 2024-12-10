package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomHeapTest {

  private CustomHeap<Integer> minHeap;
  private CustomHeap<Integer> maxHeap;

  @BeforeEach
  void setUp() {
    // Initialize min-heap and max-heap
    minHeap = new CustomHeap<>(HeapType.MIN_HEAP);
    maxHeap = new CustomHeap<>(HeapType.MAX_HEAP);
  }

  @Test
  void testIsEmpty() {
    assertTrue(minHeap.isEmpty(), "Min-heap should be empty initially");
    assertTrue(maxHeap.isEmpty(), "Max-heap should be empty initially");
  }

  @Test
  void testInsertSingleElement() {
    minHeap.insert(10);
    maxHeap.insert(10);
    assertFalse(minHeap.isEmpty(), "Min-heap should not be empty after insertion");
    assertFalse(maxHeap.isEmpty(), "Max-heap should not be empty after insertion");
    assertEquals(1, minHeap.size(), "Min-heap size should be 1 after one insertion");
    assertEquals(1, maxHeap.size(), "Max-heap size should be 1 after one insertion");
  }

  @Test
  void testPeek() {
    minHeap.insert(20);
    minHeap.insert(10);
    minHeap.insert(30);

    maxHeap.insert(20);
    maxHeap.insert(10);
    maxHeap.insert(30);

    assertEquals(10, minHeap.peek(), "Min-heap peek should return the smallest element");
    assertEquals(30, maxHeap.peek(), "Max-heap peek should return the largest element");
  }

  @Test
  void testExtract() {
    minHeap.insert(20);
    minHeap.insert(10);
    minHeap.insert(30);

    maxHeap.insert(20);
    maxHeap.insert(10);
    maxHeap.insert(30);

    assertEquals(10, minHeap.extract(), "Min-heap extract should return the smallest element");
    assertEquals(2, minHeap.size(), "Min-heap size should decrease after extraction");

    assertEquals(30, maxHeap.extract(), "Max-heap extract should return the largest element");
    assertEquals(2, maxHeap.size(), "Max-heap size should decrease after extraction");
  }

  @Test
  void testHeapPropertyAfterInsertions() {
    minHeap.insert(50);
    minHeap.insert(20);
    minHeap.insert(30);
    minHeap.insert(10);
    minHeap.insert(40);

    maxHeap.insert(50);
    maxHeap.insert(20);
    maxHeap.insert(30);
    maxHeap.insert(10);
    maxHeap.insert(40);

    assertEquals(10, minHeap.peek(), "Min-heap should maintain the min-heap property");
    assertEquals(50, maxHeap.peek(), "Max-heap should maintain the max-heap property");
  }

  @Test
  void testExtractAllElements() {
    int[] elements = {15, 10, 20, 17, 25};
    for (int elem : elements) {
      minHeap.insert(elem);
      maxHeap.insert(elem);
    }

    int[] expectedMinHeapOrder = {10, 15, 17, 20, 25};
    int[] expectedMaxHeapOrder = {25, 20, 17, 15, 10};

    for (int expected : expectedMinHeapOrder) {
      assertEquals(expected, minHeap.extract(), "Min-heap extract should return elements in ascending order");
    }
    assertTrue(minHeap.isEmpty(), "Min-heap should be empty after extracting all elements");

    for (int expected : expectedMaxHeapOrder) {
      assertEquals(expected, maxHeap.extract(), "Max-heap extract should return elements in descending order");
    }
    assertTrue(maxHeap.isEmpty(), "Max-heap should be empty after extracting all elements");
  }

  @Test
  void testInsertNullElement() {
    assertThrows(NullPointerException.class, () -> minHeap.insert(null), "Inserting null should throw NullPointerException");
  }

  @Test
  void testPeekFromEmptyHeap() {
    assertThrows(IllegalStateException.class, minHeap::peek, "Peeking from an empty heap should throw IllegalStateException");
  }

  @Test
  void testExtractFromEmptyHeap() {
    assertThrows(IllegalStateException.class, minHeap::extract, "Extracting from an empty heap should throw IllegalStateException");
  }

  @Test
  void testHeapify() {
    // Assume the heap can be built from an array
    Integer[] elements = {40, 20, 30, 10, 50};
    minHeap = new CustomHeap<>(HeapType.MIN_HEAP, elements);
    maxHeap = new CustomHeap<>(HeapType.MAX_HEAP, elements);

    assertEquals(10, minHeap.peek(), "Min-heap should correctly heapify from array");
    assertEquals(50, maxHeap.peek(), "Max-heap should correctly heapify from array");
  }

  @Test
  void testSize() {
    assertEquals(0, minHeap.size(), "Initial size should be 0");
    minHeap.insert(10);
    assertEquals(1, minHeap.size(), "Size should be 1 after one insertion");
    minHeap.insert(20);
    assertEquals(2, minHeap.size(), "Size should be 2 after two insertions");
    minHeap.extract();
    assertEquals(1, minHeap.size(), "Size should decrease after extraction");
  }
}
