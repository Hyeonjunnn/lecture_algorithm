package com.beyond.stack.practice;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.stack.practice
 * <p>fileName       : Stack
 * <p>author         : hjsong
 * <p>date           : 2025-01-20
 * <p>description    :
 *
 * @param <E> the type parameter
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-20        hjsong             최초 생성
 */
public interface Stack<E> {
    void push(E value);

    int size();

    boolean isEmpty();

    E pop();

    boolean contains(E value);

    E peek();
}
