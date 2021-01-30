/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.wurstworks.folio.utilities.list;

public class LinkedList {
    private Node head;

    public void add(String element) {
        Node newNode = new Node(element);

        Node it = tail(head);
        if (it == null) {
            head = newNode;
        } else {
            it.next = newNode;
        }
    }

    public boolean remove(String element) {
        boolean result     = false;
        Node    previousIt = null;
        Node    it         = null;
        for (it = head; !result && it != null; previousIt = it, it = it.next) {
            if (0 == element.compareTo(it.data)) {
                result = true;
                unlink(previousIt, it);
                break;
            }
        }

        return result;
    }

    public int size() {
        int size = 0;

        for (Node it = head; it != null; ++size, it = it.next) {
        }

        return size;
    }

    public String get(int index) {
        Node it = head;
        while (index > 0 && it != null) {
            it = it.next;
            index--;
        }

        if (it == null) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        return it.data;
    }

    private void unlink(Node previousIt, Node currentIt) {
        if (currentIt == head) {
            head = currentIt.next;
        } else {
            previousIt.next = currentIt.next;
        }
    }

    private static class Node {
        final String data;
        Node next;

        Node(final String data) {
            this.data = data;
        }
    }

    private static Node tail(Node head) {
        Node it;

        for (it = head; it != null && it.next != null; it = it.next) {
        }

        return it;
    }
}
