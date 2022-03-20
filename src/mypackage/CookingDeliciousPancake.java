package mypackage;

// Explain the question.
// Sorting a stack is done by a sequence of pancake “flips.”
// A flip consists of inserting a spatula between two pancakes in a  stack and flipping(reversing) all the pancakes on the spatula
// (reversing the sub-stack)

// Sample Input           Sample Output
// 1 2 3 4 5              1 2 3 4 5
// 5 4 3 2 1              5 4 3 2 1(1 2 3 4 5) -- > flip(1)
// 5 1 2 3 4   4 3 2 1 5  5 1 2 3 4(1 2 3 4 5) -- > flip(1), flip(2)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// bubble sort와 유사함. 뒤에서부터 큰 숫자를 정렬해나가는 방식.
public class CookingDeliciousPancake {

    public static void flip(int[] pancakes, int n) {
        int size = pancakes.length;
        n = size - n;
        int k = 0;
        for (int i = n; i > n / 2; i--) {
            int temp = pancakes[i];
            pancakes[i] = pancakes[k];
            pancakes[k] = temp;
            k++;
        }
    }

    // 이미 정렬된 sort를 제외하고 진행.
    public static int findMax(int[] pancakes, int n) {
        int max = 0;
        int max_index = 0;
        for (int i = n; i >= 0; i--) {
            if (max < pancakes[i]) {
                max = pancakes[i];
                max_index = i;
            }
        }
        return max_index;
    }

    public static void main(String[] args) {
        // ArrayList로 받거나, String으로 받아서 쪼갠 다음에 int로 바꾸기.
        // 엔터 하자마자 알아보는걸로 하려면 아무래도 후자의 방법이 가능할 듯 싶다.

        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        String a = sc.nextLine();
        String[] b = a.split(" ");
        int size = b.length;
        int[] pancakes = new int[size];

        for (int i = 0; i < size; i++) {
            pancakes[i] = Integer.parseInt(b[i]);
        }

        ArrayList<Integer> fliped = new ArrayList<>();

        int max = size - findMax(pancakes, size - 1);

        for (int i = 0; i < size; i++) {
            if (max != size - (size - i - 1)) {
                flip(pancakes, max);
                fliped.add(max);
                flip(pancakes, i + 1);
                fliped.add(i + 1);
            }
            max = findMax(pancakes, (size - 1) - (i + 1));
            max = size - max;
        }

        System.out.println("Result: " + Arrays.toString(pancakes));
        System.out.println("Fliped: " + fliped.toString());
        sc.close();

    }
}
