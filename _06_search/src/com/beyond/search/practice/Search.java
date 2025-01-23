package com.beyond.search.practice;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.search.practice
 * <p>fileName       : Search
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
public class Search {

    // 정수형 배열에서 특정 숫자의 인덱스를 찾는 정적 메소드
    public static int linearSearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            } // if (numbers[i] == target) END

        } // for i END

        return -1;
    } // linearSearch(int[] numbers, int target) END

    // 문자열에서 특정 문자의 인덱스를 찾는 메소드
    public static int linearSearch(String str, char target) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                return i;
            } // if(str.charAt(i) == target) END

        } // for i END

        return -1;
    } // linearSearch(int[] numbers, int target) END

    // 정수형 배열의 요소에서 가장 작은 값을 찾는 메소드
    public static int minvalue(int[] numbers) {
        int minNum = numbers[0];
        for (int num : numbers) {
            if (num < minNum) {
                minNum = num;
            }
        }

        return minNum;
    } // minvalue(int[] numbers) END

    // 정수형 배열에서 특정 숫자의 인덱스를 찾는 메소드(이진 탐색, 반복문 사용)
    public static int binarySearch(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;

            }// if (numbers[mid] == target) END

        } // while (left <= right) END

        return -1;
    } // binarySearch(int[] numbers, int target) END

    // 정수형 배열에서 특정 숫자의 인덱스를 찾는 메소드(이진 탐색, 재귀 호출 사용)
    public static int binarySearch(int[] numbers, int target, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;

            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                return binarySearch(numbers, target, mid + 1, right);
            } else {
                return binarySearch(numbers, target, left, mid - 1);
            } // if (numbers[mid] == target) END

        } // if (left <= right) END

        return -1;
    } // binarySearch(int[] numbers, int target, int left, int right) END



}
