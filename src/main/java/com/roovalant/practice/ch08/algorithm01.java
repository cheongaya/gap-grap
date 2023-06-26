package com.roovalant.practice.ch08;

public class algorithm01 {

    /**
     * 나열된 수에서 최솟값과 최댓값 구하기
     *
     * [문제정의]
     * - 여러 개의 수가 배열에 있을 때 그 중 가장 큰 값과 가장 작은 값을 찾는다
     * - 배열의 몇 번째에 있는지 순서를 찾는다
     * - 반복문을 한번만 사용하여 문제를 해결한다
     * - 수의 예 : [10, 55, 23, 2, 79, 101, 16, 82, 30, 45]
     *
     * [해결하기]
     * 1. 배열에 있는 수 중 맨처음에 있는 값을 max 와 min 으로 가정한다
     * 2. 배열의 마지막 수까지 비교하면서 더 큰수나 더 작은수가 나올때 max와 min의 값을 바꾸도록한다
     * 3. 그때의 위치를 변수에 저장한다
     *
     * [수행 시간 분석]
     * - 반복문의 한번 수행으로 두 개의 원하는 값을 모두 찾을 수 있다
     * - 이 경우 수행 속도는 나열된 수의 개수에 비례하므로 O(n)이 된다
     */

    public static void main(String[] args) {

        int[] numbers = {10, 55, 23, 2, 79, 101, 16, 82, 30, 45};

        int min = numbers[0];
        int max = numbers[0];
        int minPos = 0;
        int maxPos = 0;

        // 왜 int i=1 부터 시작할까? numbers[0] 은 10 이라는 걸 아니까, numbers[1] 부터 돌린다
        for (int i=1; i<numbers.length; i++) {

            if (min > numbers[i]) {
                min = numbers[i];
                minPos = i+1;
            }

            if (max < numbers[i]) {
                max = numbers[i];
                maxPos = i+1;
            }
        }

        System.out.println("가장 큰 값은 " + max + " 이고, 위치는 " + maxPos + "번째 입니다.");
        System.out.println("가장 작은 값은 " + min + " 이고, 위치는 " + minPos + "번째 입니다.");
    }
}
