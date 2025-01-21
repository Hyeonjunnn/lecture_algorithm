package com.beyond.stack.practice;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.stack.practice
 * <p>fileName       : SinglyLinkedList
 * <p>author         : hjsong
 * <p>date           : 2025-01-20
 * <p>description    :
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-20        hjsong             최초 생성
 */

public class SinglyLinkedList<E> implements Stack<E> {
    private Node<E> top;

    private int size;

    public SinglyLinkedList() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E value) {
        Node<E> newNode = new Node<>(value);

        newNode.next = top;
        top = newNode;

        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            throw new RuntimeException("스택이 비어 있습니다.");
        }

        Node<E> tempNode = top;
        E data = tempNode.data;

        top = tempNode.next;
        tempNode.data = null;
        tempNode.next = null;

        size--;

        return data;
    }

    @Override
    public boolean contains(E value) {
        boolean result = false;

        Node<E> currentNode = top;

        while (currentNode != null){
            if (currentNode.data.equals(value)){
                result = true;

                break;
            }

            currentNode = currentNode.next;
        }

        return result;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("스택이 비어 있습니다.");
        }

        return top == null ? null : top.data;
    }

    @Override
    public String toString() {
        Node<E> currentNode = top;
        StringBuilder sb = new StringBuilder();

        while(currentNode != null){
            sb.append(currentNode.data + ", ");

            currentNode = currentNode.next;
        }

        sb.insert(0, "[");

        if(sb.lastIndexOf(",") != -1){
            sb.replace(sb.lastIndexOf(","), sb.length(), "]");
        } else {
            sb.append("]");
        }

        return sb.toString();
    }

    private static class Node<E> {
        private E data;

        private Node<E> next;

        public Node(E data){
            this.data = data;
            this.next = null;
        }

    }
}
