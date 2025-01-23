package com.beyond.sort.pracitce;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.sort.pracitce
 * <p>fileName       : ArraySort
 * <p>author         : hjsong
 * <p>date           : 2025-01-22
 * <p>description    :
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-22        hjsong             최초 생성
 */
public class ArraySort {
    public static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            for (; j >= 0 &&  array[j] > key; j--) {
                array[j + 1] = array[j];
            } // for j END

            array[j + 1] = key;
        } // for i END

    } // insertionSort(int[] array) END

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i -1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];

                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } // if (array[j] > array[j + 1]) END

            } // for j END

        } // for i END

    } // bubbleSort(int[] array) END

    // 재귀 메소드
    // 작업 중에 자기 자신을 호출하는 것을 재귀 호출이라 하고,
    // 재귀 호출을 하는 메소드를 재귀 메소드라고 한다.
    public static void mergeSort(int[] array, int left, int right) {
        // 분할할 부분이 남아 있는 경우
        if (left < right) {
            // 배열을 분할할 인덱스 계산
            int mid = (left + right) / 2;

            // 왼쪽 부분 배열 정렬
            mergeSort(array, left, mid);
            
            // 오른쪽 부분 배열 정렬
            mergeSort(array, mid + 1, right);

            // 정렬된 두 부분의 배열을 합치는 메소드
            merge(array, left, mid, right);


        } // if (left < right) END

    } // mergeSort(int[] array) END

    private static void merge(int[] array, int left, int mid, int right) {
        // 임시 배열 생성
        int[] temp = new int[right - left + 1];

        // 왼쪽 부분 배열의 시작 인덱스
        int i = left;
        // 오른쪽 부분 배열의 시작 인덱스
        int j = mid + 1;
        // 임시 배열의 인덱스
        int k = 0;

        // 두 부분 배열의 요소들을 비교하여 임시 배열에 정렬하여 저장
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            } // if (array[i] <= array[j]) END

        } // while (i <= mid && j <= right) END
        
        // 왼쪽 부분 배열에 남아 있는 요소가 있으면 임시 배열에 저장
        while (i <= mid) {
            temp[k++] = array[i++];
        } // while (i <= mid) END
        
        // 오른쪽 부분 배열에 남아 있는 요소가 있으면 임시 배열에 저장
        while (j <= right) {
            temp[k++] = array[j++];
        } // while (j <= right) END
        
        // 임시 배열의 요소들을 원래 배열에 저장
        for (k = 0; k < temp.length; k++) {
            array[left + k] = temp[k];
        } // for k END

    } // merge(int[] array, int left, int mid, int right) END

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // pivot을 기준으로 배열을 분할하고, pivot의 위치를 반환
            int pivotIndex = partition(array, left, right);

            // pivot을 기준으로 왼쪽 부분 배열 정렬
            quickSort(array, left, pivotIndex - 1);

            // pivot을 기준으로 오른쪽 부분 배열 정렬
            quickSort(array, pivotIndex + 1, right);
        } // if (left < right) END

    } // quickSort(int[] array, int left, int right) END

    private static int partition(int[] array, int left, int right) {
        // 배열의 마지막 요소를 pivot으로 설정
        int pivot = array[right];
        // 작은 요소들의 인덱스
        int i = left - 1;
        int temp = 0;

        // 배열을 탐색하면서 pivot보다 작은 요소를 왼쪽으로 이동시킨다.
        for (int j = left; j < right; j++) {
            if (array[j] < pivot){
                i++;

                // 작은 요소와 array[j]를 교환
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            
        }

        // pivot을 올바른 위치로 이동
        temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;

        // pivot의 최종 위치를 반환
        return (i + 1);
    }

}
