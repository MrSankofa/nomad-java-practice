package src.main.review;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
* Key Features Tested
Basic Operations:

put: Add elements to the map, including null keys and values.
get: Retrieve elements by key.
remove: Remove elements by key.
Edge Cases:

Handle duplicate keys.
Support for null keys and values.
Accessing non-existent keys.
Removing non-existent keys.
State and Size:

Verify the size of the map after each operation.
Confirm the map is empty when it should be.
Functional Features:

Collision handling.
Resizing (e.g., rehashing when the load factor exceeds a threshold).
Key and value existence checks.
Expected Custom HashMap Class
To pass these tests, your CustomHashMap class should include the following features:

Generic Type Support
Should work with any key-value pair types.
Hashing and Buckets
Internally use an array of buckets (linked lists or similar structures) to handle collisions.
Methods
put(K key, V value): Adds a key-value pair to the map.
get(K key): Retrieves the value associated with the key.
remove(K key): Removes the key-value pair from the map and returns the value.
size(): Returns the number of key-value pairs in the map.
isEmpty(): Checks if the map is empty.
clear(): Removes all entries from the map.
containsKey(K key): Checks if a key exists in the map.
containsValue(V value): Checks if a value exists in the map.
*
* */

class CustomHashMapTest {

  private CustomHashMap<String, Integer> map;

  @BeforeEach
  void setUp() {
    map = new CustomHashMap<>();
  }

  @Test
  void testPutAndGet() {
    map.put("key1", 10);
    assertEquals(10, map.get("key1"), "Value for 'key1' should be 10");
  }

  @Test
  void testPutDuplicateKey() {
    map.put("key1", 10);
    map.put("key1", 20); // Update value for the same key
    assertEquals(20, map.get("key1"), "Value for 'key1' should be updated to 20");
  }

  @Test
  void testPutNullKey() {
    map.put(null, 10);
    assertEquals(10, map.get(null), "Value for null key should be 10");
  }

  @Test
  void testPutNullValue() {
    map.put("key1", null);
    assertNull(map.get("key1"), "Value for 'key1' should be null");
  }

  @Test
  void testGetNonExistentKey() {
    assertNull(map.get("key2"), "Getting a non-existent key should return null");
  }

  @Test
  void testRemove() {
    map.put("key1", 10);
    map.put("key2", 20);
    Integer removed = map.remove("key1");
    assertEquals(10, removed, "Removed value for 'key1' should be 10");
    assertNull(map.get("key1"), "Key 'key1' should no longer exist in the map");
    assertEquals(1, map.size(), "Map size should decrease after removal");
  }

  @Test
  void testRemoveNonExistentKey() {
    assertNull(map.remove("key3"), "Removing a non-existent key should return null");
  }

  @Test
  void testSize() {
    assertEquals(0, map.size(), "Initial map size should be 0");
    map.put("key1", 10);
    map.put("key2", 20);
    assertEquals(2, map.size(), "Map size should be 2 after adding two elements");
  }

  @Test
  void testIsEmpty() {
    assertTrue(map.isEmpty(), "Map should be empty initially");
    map.put("key1", 10);
    assertFalse(map.isEmpty(), "Map should not be empty after adding an element");
  }

  @Test
  void testClear() {
    map.put("key1", 10);
    map.put("key2", 20);
    map.clear();
    assertTrue(map.isEmpty(), "Map should be empty after clear");
    assertEquals(0, map.size(), "Map size should be 0 after clear");
  }

  @Test
  void testContainsKey() {
    map.put("key1", 10);
    assertTrue(map.containsKey("key1"), "Map should contain 'key1'");
    assertFalse(map.containsKey("key2"), "Map should not contain 'key2'");
  }

  @Test
  void testContainsValue() {
    map.put("key1", 10);
    assertTrue(map.containsValue(10), "Map should contain the value 10");
    assertFalse(map.containsValue(20), "Map should not contain the value 20");
  }

  @Test
  void testHandleCollisions() {
    // Assuming the hash function generates collisions for "key1" and "key2"
    map.put("key1", 10);
    map.put("key2", 20); // Both keys hash to the same bucket
    assertEquals(10, map.get("key1"), "Value for 'key1' should be 10 despite collision");
    assertEquals(20, map.get("key2"), "Value for 'key2' should be 20 despite collision");
  }

  @Test
  void testResize() {
    // Insert many elements to trigger a resize operation
    for (int i = 0; i < 100; i++) {
      map.put("key" + i, i);
    }
    assertEquals(100, map.size(), "Map size should be 100 after adding 100 elements");
    for (int i = 0; i < 100; i++) {
      assertEquals(i, map.get("key" + i), "Map should correctly retrieve all inserted elements after resizing");
    }
  }
}

