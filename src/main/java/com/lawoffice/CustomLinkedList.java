package com.lawoffice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomLinkedList<T> {

  private Node<T> head;

  public CustomLinkedList() {
    head = null;
  }

  public void addFirst(T data) {
    head = new Node<T>(data, head);
  }

  public void addLast(T data) {
    if (head == null) {
      addFirst(data);
    } else {
      Node<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new Node<T>(data, null);
    }
  }

  public T removeFirst() {
    if (head == null) {
      throw new NoSuchElementException();
    }
    T data = head.data;
    head = head.next;
    return data;
  }

  public List<T> convertToArrayList() {
    List<T> retList = new ArrayList<>();
    Node<T> currentNode = this.head;
    while (currentNode != null) {
      // System.out.println(currentNode.getData());
      currentNode = currentNode.next;

      retList.add(currentNode.data);
    }

    return retList;
  }

  public boolean contains(T data) {
    Node<T> current = head;
    while (current != null) {
      if (current.data.equals(data)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  public int size() {
    int count = 0;
    Node<T> current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  private static class Node<T> {
    T data;
    Node<T> next;

    public Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
    }
  }
}

