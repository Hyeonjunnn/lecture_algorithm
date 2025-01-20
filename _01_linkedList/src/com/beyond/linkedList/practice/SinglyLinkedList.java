package com.beyond.linkedList.practice;

/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-20        hjsong             최초 생성
 */
public class SinglyLinkedList<T> implements List<T> {
    // 연결 리스트와 첫 번째 노드를 가리키는 참조
    private Node<T> head;
    private int size;

    // 생성자
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    @Override
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if(head == null){
            head = newNode;
        } else {
            Node<T> lastNode = search(size - 1);

            lastNode.next = newNode;
        }
        size ++;
    }

    @Override
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0){
            addFirst(data);

            return;
        }

        if (index == size){
            addLast(data);

            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> prevNode = search(index - 1);
        newNode.next = prevNode.next;
        prevNode.next = newNode;

        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        return search(index).data;
    }

    @Override
    public void removeFirst(){
        if (head == null){
            return;
        } else {
            Node<T> first = head;

            head = first.next;
            first.data = null;
            first.next = null;

            size--;
        }

    }

    @Override
    public void removeLast(){
        if (head == null){
            return;
        } else if ((size - 2) < 0) {
          removeFirst();

          return;
        } else {
            Node<T> lastPrevNode = search(size - 2);;

            lastPrevNode.next.data = null;
            lastPrevNode.next = null;

            size--;
        }

    }

    @Override
    public void remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        if (index == 0){
            removeFirst();

            return;
        }

        if (index == (size - 1)){
            removeLast();

            return;
        }

        Node<T> prevNode = search(index - 1);
        Node<T> targetNode = prevNode.next;

        prevNode.next = targetNode.next;
        targetNode.data = null;
        targetNode.next = null;

        size--;
    }

    @Override
    public void remove(T data){
        Node<T> currentNode = head;

        // 리스트가 비어있는 경우
        if (currentNode == null){
            return;
        }

        // 삭제할 노드가 헤드인 경우
        if(currentNode.data.equals(data)){
            removeFirst();

            return;
        }

        for (int i = 0; i < size - 1; i++) {
            if (currentNode.next.data.equals(data)){
                Node<T> nextNode = currentNode.next;

                currentNode.next = nextNode.next;
                nextNode.data = null;
                nextNode.next = null;

                size--;

                break;
            }

            currentNode = currentNode.next;
        }

    }

    @Override
    public boolean contains(T data) {
        Node<T> current = head;

        while (current != null){
            if (current.data.equals(data)){
                return true;
            }

            current = current.next;
        }

        return false;
    }

    @Override
    public String toString() {
        Node<T> current = head;
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        while (current != null){
            sb.append(current.data + ", ");

            current = current.next;
        }

        // If no such value of k exists, then -1 is returned.
        // , 이 존재하지 않으면 -1 반환
        if (sb.lastIndexOf(",") != -1){
            sb.replace(sb.lastIndexOf(","), sb.length(), "]");
        } else {
            sb.append("]");
        }

        return sb.toString();
    }


    /**
     *
     * @return
     */
    private Node<T> search(int index) {
        // Head에서부터 차례로 index까지 검색
        Node<T> current = head;

        for (int i = 0; i < index; i++){
            current = current.next;
        }
        
        return current;
    }

    private static class Node<T> {
        // 노드가 저장하는 데이터
        private T data;

        // 다음 노드를 가리키는 참조
        private Node<T> next;

        // 생성자
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

}
