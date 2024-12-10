package src.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import src.main.review.CustomLinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TestCustomLinkedList {

  private CustomLinkedList<Integer> list;

  @BeforeEach
  void setUp() {
    list = new CustomLinkedList<Integer>();
  }

  @Test
  public void testIsEmpty() {
    assertTrue(list.isEmpty(), "List should be empty initially");
  }

  @Test
  public void testAddElement() {
    list.add(1);
    assertFalse(list.isEmpty(), "List should not be empty after adding an element");
    assertEquals(1, list.size(), "Size should be 1 after adding one element");
  }

  @Test
  public void testAddMultipleElements() {
    list.add(1);
    list.add(2);
    list.add(3);
    assertEquals(3, list.size(), "Size should be 3 after adding three elements");
    assertEquals(1, list.get(0).data, "First element should be 1");
    assertEquals(2, list.get(1).data, "Second element should be 2");
    assertEquals(3, list.get(2).data, "Third element should be 3");
  }

  @Test
  public void testRemoveElement() {
    list.add(1);
    list.add(2);
    list.add(3);
    list.remove(1);
    assertEquals(2, list.size(), "Size should be 2 after removing one element");
    assertEquals(1, list.get(0), "First element should still be 1");
    assertEquals(3, list.get(1), "Second element should now be 3");
  }

//  @Test
//  public void testRemoveFromEmptyList() {
//    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0), "Removing from an empty list should throw an exception");
//  }

  @Test
  public void testGetElement() {
    list.add(1);
    list.add(2);
    list.add(3);
    assertEquals(2, list.get(1).data, "Getting the second element should return 2");
  }

  @Test
  public void testGetElementOutOfBounds() {
    list.add(1);
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(5), "Getting an out-of-bounds index should throw an exception");
  }

  @Disabled("clear not implemented")
  @Test
  public void testClearList() {
    list.add(1);
    list.add(2);
//    list.clear();
    assertTrue(list.isEmpty(), "List should be empty after clearing");
    assertEquals(0, list.size(), "Size should be 0 after clearing the list");
  }

  @Disabled("contains not implemented")
  @Test
  public void testContainsElement() {
    list.add(1);
    list.add(2);
//    assertTrue(list.contains(2), "List should contain the element 2");
//    assertFalse(list.contains(3), "List should not contain the element 3");
  }

  @Disabled("Iteration not set up this way")
  @Test
  public void testIteration() {
    list.add(1);
    list.add(2);
    list.add(3);
    int[] expected = {1, 2, 3};
    int index = 0;
//    for (int value : list) {
//      assertEquals(expected[index], value, "Element at index " + index + " should match expected value");
//      index++;
//    }
  }
}
