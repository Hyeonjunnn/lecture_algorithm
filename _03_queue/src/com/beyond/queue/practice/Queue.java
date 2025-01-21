package com.beyond.queue.practice;

/**
 * <p>Queue 인터페이스
 * <p>packageName    : com.beyond.queue.practice
 * <p>fileName       : Queue
 * <p>author         : hjsong
 * <p>date           : 2025-01-21
 * <p>description    : Queue 인터페이스
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-21        hjsong             최초 생성
 */
public interface Queue<E> {
    void enqueue(E value);

    int size();

    boolean isEmpty();

    E dequeue();

    E peek();

    boolean contains(E value);

}
