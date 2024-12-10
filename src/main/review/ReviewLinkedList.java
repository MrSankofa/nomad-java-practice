package src.main.review;

import java.util.LinkedList;

public class ReviewLinkedList {
  public static void main(String[] args) {
    LinkedList<String> linkedList = new LinkedList<>();

    linkedList.add("linked");
    linkedList.add("lists");
    linkedList.add("are");
    linkedList.add("neat");

    System.out.println("LinkedList elements: " + linkedList);

    // Add an element to the front of the list
    linkedList.addFirst("Java");
    System.out.println(
        "After addFirst() " + linkedList);

    // Remove an element from the LinkedList
    linkedList.remove("Java");
    System.out.println(
        "After remove(\"Java\"): " + linkedList);

    // Check if list contains an element
    if (linkedList.contains("neat")) {
      System.out.println("Print: LinkedList contains neat, if it contains neat");
    }

    // Check the size of the LinkedList
    System.out.println(
        "Size of the LinkedList: " + linkedList.size());

    // Iterate the LinkedList using enhanced for loop
    System.out.print("LinkedList elements (iterating): ");
    for (String word : linkedList) {
      System.out.print(word + " print ");
    }
    System.out.println();

    // clear the LinkedList
    linkedList.clear();

    // Check the size of the LinkedList again
    System.out.println(
        "Size of the LinkedList: " + linkedList.size());
  }
}
