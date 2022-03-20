package mypackage;

// Explain the question.
// Compute the minimum amount of money that must change hands in order to equalize(within one won) all the student's costs.
// ouput a line stating the total amount of money, in won units, that must be exchanged to equalize the students's costs.
// Calculate the movement of the amount incurred in the cost calculation.
// Sample Input         Sample Output
// 3                    10000
// 10000                11990
// 20000
// 30000
// 4
// 15000
// 15010
// 3000
// 3010
// 0

import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class Thanksgivingtrip {

    public static double avg(int[] money) {
        int sum = 0;
        int size = money.length;
        for (int i = 0; i < size; i++) sum += money[i];
        double avg = sum / size;
        return avg;
    }

    public static void findUnderAvg(int[] money, int avg) { // 평균보다 작은 값들 - 원래의 값. && 평균보다 큰 값은 0
        int size = money.length;
        for (int i = 0; i < size; i++) {
            if (money[i] >= avg) money[i] = 0; else {
                money[i] = avg - money[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> answer = new ArrayList<>();

        while (true) {
            System.out.print(">> ");
            int num = sc.nextInt();
            if (num == 0) break;
            int[] money = new int[num];

            for (int i = 0; i < num; i++) {
                System.out.print("> ");
                money[i] = sc.nextInt();
            }

            int avg = (int) Math.round(avg(money)); // double to int
            avg = (avg / 10) * 10; // 1의 자리 없애기
            findUnderAvg(money, avg);

            int sum = 0;
            for (int i = 0; i < money.length; i++) {
                sum += money[i];
            }
            answer.add(sum);
        }
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
        sc.close();
    }
}
