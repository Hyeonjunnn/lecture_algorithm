package com.beyond.search;

import com.beyond.search.practice.Search;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.search
 * <p>fileName       : Application
 * <p>author         : hjsong
 * <p>date           : 2025-01-23
 * <p>description    :
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-23        hjsong             최초 생성
 */
public class Application {
    public static void main(String[] args) {

        int[] numbers = {3, 8, 5, 4, 9, 2};

        System.out.println(Search.linearSearch(numbers, 50));
        System.out.println(Search.linearSearch("Hello", 'e'));
        System.out.println(Search.minvalue(numbers));
        System.out.println();

        numbers = new int[] {2, 3, 5, 9, 12, 15, 30};
        System.out.println(Search.binarySearch(numbers, 30));
        System.out.println(Search.binarySearch(numbers, 5, 0, numbers.length - 1));
        System.out.println();
    }
}
