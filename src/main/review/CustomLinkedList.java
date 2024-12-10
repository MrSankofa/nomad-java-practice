package src.main.review;

public class CustomLinkedList<T> {
  private Node head;

  // VarArgs so we can 0 or more data of that type
  public CustomLinkedList(T... data) {
    if (data.length < 1) {
      head = null;
    } else {
      for (int i = 0; i < data.length; i++) {
        add(data[i]);
      }
    }
  }

  public void add(T data) {
    insert(data, size());
  }

  public void insert(T data, int index) {
    if (this.head == null) {
      this.head = new Node(data);
    } else {
      Node iter = this.head;
      Node prev = null;

      if( index == 0) {
        this.head = new Node(data);
      } else if ( index < size()) {
        int count = 0;

        while ( count != index) {

          prev = iter;
          iter = iter.next;
          count++;
        }

        prev.next = new Node(data);
      } else {
        while (iter.next != null) {
          prev = iter;
          iter = iter.next;
        }

        iter.next = new Node(data);
      }
    }
  }

  public int size() {
    if (this.head == null) {
      return 0;
    } else {
      int count = 1;
      Node iter = this.head;
      while ( iter.next != null) {
        iter = iter.next;
        count++;
      }
      return count;
    }
  }

  public Boolean isEmpty() {
    return this.head == null;
  }

  public Node get(int index) {
    if (index < 0 || index >= size()) {
      return null;
    }

    if(index == 0) {
      return this.head;
    }

    Node iter = this.head;
    int count = 0;

    while ( count < size()) {
      if(index == count) {
        return iter;
      }
      iter = iter.next;
      count++;
    }

    return null;
  }

  // find the index,
  // use the prev.next and point it to current index ndex
  public Node remove(int index) {
    if (index < 0 || index >= size()) {
      return null;
    }

    if(index == 0) {
      Node temp = this.head;
      this.head = null;
      return temp;
    }

    Node iter = this.head;
    Node prev = null;
    int count = 0;

    while ( count < index) {
      prev = iter;
      iter = iter.next;
      count++;
    }

    prev.next = iter.next;

    return iter;
  }
}

