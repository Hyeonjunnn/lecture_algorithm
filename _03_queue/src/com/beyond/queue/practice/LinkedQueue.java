package com.beyond.queue.practice;

/**
 * <p>LinkedQueue 클래스
 * <p>packageName    : com.beyond.queue.practice
 * <p>fileName       : LinkedQueue
 * <p>author         : hjsong
 * <p>date           : 2025-01-21
 * <p>description    : Queue를 구현하는 LinkedQueue 클래스
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-21        hjsong             최초 생성
 */
public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;

    private Node<E> rear;

    private int size;

    @Override
    public void enqueue(E value) {
        Node<E> newNode = new Node<>(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    } // enqueue END

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("큐가 비어 있습니다.");
        }

        Node<E> tempNode = front;
        E value = tempNode.data;

        front = tempNode.next;

        tempNode.data = null;
        tempNode.next = null;

        size--;

        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("큐가 비어 있습니다.");
        }

        return front.data;
    }

    @Override
    public boolean contains(E value) {
        boolean result = false;
        Node<E> currentNode = front;

        while (currentNode != null) {
            if (currentNode.data.equals(value)) {
                result = true;

                break;
            }

            currentNode = currentNode.next;
        } // while END

        return result;
    } // contains END

    @Override
    public String toString() {
        Node<E> current = front;
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        while (current != null) {
            sb.append(current.data + ", ");

            current = current.next;
        }

        if (sb.lastIndexOf(",") != -1) {
            sb.replace(sb.lastIndexOf(","), sb.length(), "]");
        } else {

            sb.append("]");
        }

        return sb.toString();
    }

    private static class Node<E> {
        private E data;

        private Node<E> next;

        // 생성자
        public Node(E data) {
            this.data = data;
            this.next = null;
        } // 생성자 END

    } // Node<E> 클래스 END

}
