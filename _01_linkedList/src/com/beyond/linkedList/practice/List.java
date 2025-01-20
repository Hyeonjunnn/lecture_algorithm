package com.beyond.linkedList.practice;

/**
 * <p>List 인터페이스
 *
 * <p>packageName    : linkedList.practice
 * <p>fileName       : List
 * <p>author         : hjsong
 * <p>date           : 2025-01-20
 * <p>description    :
 *
 * @param <T> the type parameter
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-20        hjsong             최초 생성
 */
public interface List<T> {
    void addFirst(T data);

    void addLast(T data);

    void add(int index, T data);

    int size();

    T get(int index);

    boolean contains(T data);

    void removeFirst();

    void removeLast();

    void remove(int index);

    void remove(T data);
}
