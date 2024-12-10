package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomStackTest {

  private CustomStack<Integer> stack;

  @BeforeEach
  void setUp() {
    stack = new CustomStack<>();
  }

  @Test
  void testIsEmpty() {
    assertTrue(stack.isEmpty(), "Stack should be empty initially");
  }

  @Test
  void testPush() {
    stack.push(10);
    assertFalse(stack.isEmpty(), "Stack should not be empty after push");
    assertEquals(1, stack.size(), "Stack size should be 1 after one push");
  }

  @Test
  void testPushMultipleElements() {
    stack.push(10);
    stack.push(20);
    stack.push(30);
    assertEquals(3, stack.size(), "Stack size should be 3 after three pushes");
  }

  @Test
  void testPop() {
    stack.push(10);
    stack.push(20);
    int popped = stack.pop();
    assertEquals(20, popped, "Popped element should be the last pushed element");
    assertEquals(1, stack.size(), "Stack size should decrease after pop");
  }

  @Test
  void testPopFromEmptyStack() {
    assertThrows(IllegalStateException.class, stack::pop, "Popping from an empty stack should throw an exception");
  }

  @Test
  void testPeek() {
    stack.push(10);
    stack.push(20);
    int top = stack.peek();
    assertEquals(20, top, "Peek should return the last pushed element");
    assertEquals(2, stack.size(), "Stack size should remain unchanged after peek");
  }

  @Test
  void testPeekFromEmptyStack() {
    assertThrows(IllegalStateException.class, stack::peek, "Peeking into an empty stack should throw an exception");
  }

  @Test
  void testClear() {
    stack.push(10);
    stack.push(20);
    stack.clear();
    assertTrue(stack.isEmpty(), "Stack should be empty after clear");
    assertEquals(0, stack.size(), "Stack size should be 0 after clear");
  }

  @Test
  void testPushNullElement() {
    assertThrows(NullPointerException.class, () -> stack.push(null), "Pushing null should throw a NullPointerException");
  }
}
