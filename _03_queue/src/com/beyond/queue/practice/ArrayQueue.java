package com.beyond.queue.practice;

/**
 * <p>ArrayQueue 클래스
 *
 * <p>packageName    : com.beyond.queue.practice
 * <p>fileName       : ArrayQueue
 * <p>author         : hjsong
 * <p>date           : 2025-01-21
 * <p>description    : Queue를 구혀하는 ArrayQueue 클래스
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-21        hjsong             최초 생성
 */
public class ArrayQueue<E> implements Queue<E> {
    // 큐의 첫 번째 데이터가 저장되어 있는 배열의 인덱스
    private int front;
    
    // 큐의 마지막 데이터가 저장되어 있는 배열의 인덱스
    private int rear;

    // 큐의 최대 크기
    private int maxSize;
    
    // 큐에 저장된 데이터의 수
    private int size;

    // 데이터를 저장할 배열
    private Object[] values;

    // 생성자
    public ArrayQueue() {
        this(16);
    }

    public ArrayQueue(int maxSize) {
        this.front = 0;
        this.rear = -1;
        this.maxSize = maxSize;
        this.size = 0;
        this.values = new Object[maxSize];
    }

    @Override
    public void enqueue(E value) {
        if (size == maxSize){
            throw new RuntimeException("큐가 가득 찼습니다.");
        }
        
        // 큐의 끝에 rear가 도달한 경우
        if (rear == (maxSize - 1)) {
            rear = -1;
        }

        values[++rear] = value;

        size++;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return (this.size == 0);
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new RuntimeException("큐가 비어 있습니다.");
        }

        E value = (E) values[front++];

        // 큐의 끝에 도달한 경우
        if (front == maxSize) {
            front = 0;
        }

        size--;

        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("큐가 비어 있습니다.");
        }

        return (E) values[front];
    }

    @Override
    public boolean contains(E value) {
        boolean result = false;
        int front = this.front;

        for (int i = 0; i < size; i++) {
            if (values[front].equals(value)){
                result = true;

                break;
            }

            front = (front + 1) % maxSize;
        }

        return result;
    }

    @Override
    public String toString() {
        int front = this.front;
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < size; i++) {

            sb.append(values[front] + ", ");

            front = (front + 1) % maxSize;
        }

        if (sb.lastIndexOf(",") != -1){
            sb.replace(sb.lastIndexOf(","), sb.length(), "]");
        } else {
            sb.append("]");
        }

        return sb.toString();
    }

}
