package mypackage;

// Explain the question
// Write a program to take longest nap with the task.

// Sample Input
// 4
// 10:00 12:00 Lectures
// 12:00 13:00 Lunch, like always.
// 13:00 15:00 Boring lectures…
// 16:45 17:45 Reading ( to be or not to be?)

// Sample Output
// Day #1: the longest nap starts at 15:00 and will last for 1 hours  and 45 minutes

import java.util.Scanner;

public class SweetNap {

    public static void bubblesort(int[] hh, int[] mm) {
        int n = hh.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (hh[j] > hh[j + 1]) {
                    int temp = hh[j];
                    hh[j] = hh[j + 1];
                    hh[j + 1] = temp;

                    int temp1 = mm[j];
                    mm[j] = mm[j + 1];
                    mm[j + 1] = temp1;
                }
            }
        }
    }

    private static void sortforsamehour(int[] hh, int[] mm) {
        int n = hh.length;
        for (int i = 0; i < n - 14; i++) {
            if (hh[i] == hh[i + 1]) {
                if (mm[i] > mm[i + 1]) {
                    int temp1 = mm[i];
                    mm[i] = mm[i + 1];
                    mm[i + 1] = temp1;
                }
            }
        }
    }

    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        Scanner sc = new Scanner(System.in);

        System.out.print("> ");
        int n = sc.nextInt();

        String[][] plan = new String[n][2];
        int[] hh = new int[n * 2];
        int[] mm = new int[n * 2];
        // int to = Integer.parseInt(from);

        for (int i = 0; i < n; i++) {
            System.out.print("> ");
            plan[i][0] = sc.next();
            plan[i][1] = sc.next();
        }

        // 10:00
        // 01234
        int k = 0;
        for (int i = 0; i < n * 2; i += 2) {
            hh[i] = Integer.parseInt(plan[k][0].substring(0, 2));
            hh[i + 1] = Integer.parseInt(plan[k][1].substring(0, 2));
            mm[i] = Integer.parseInt(plan[k][0].substring(3));
            mm[i + 1] = Integer.parseInt(plan[k][1].substring(3));
            k++;
        }

        bubblesort(hh, mm);
        sortforsamehour(hh, mm);

        // checking solved hh mm
        // for (int i = 0; i < hh.length; i++) {
        //   System.out.print(hh[i] + ":");
        //   System.out.println(mm[i]);
        // }

        int[] time = new int[n + 1];
        int n2 = hh.length;
        time[0] = ((hh[0] - 10) * 60) + mm[0];
        time[n] = ((18 - hh[n2 - 1]) * 60) + (60 - mm[n2 - 1]);

        int j = 1;
        for (int i = 2; i < n2 - 1; i += 2) {
            time[j] = ((hh[i] - hh[i - 1]) * 60) + (mm[i] - mm[i - 1]);
            j++;
        }

        // checking time
        // for(int i = 0; i < time.length; i++){
        //     System.out.println(time[i]);
        // }

        int max = time[0];
        int max_index1 = 0;
        for (int i = 1; i < time.length; i++) {
            if (max < time[i]) {
                max = time[i];
                max_index1 = 2 * i - 1;
            }
        }

        int big_hour = max / 60;
        int big_minute = max % 60;

        if (max_index1 == 0) {
            System.out.println(
                    "The longest nap starts at " +
                            "10:00" +
                            " and will last for " +
                            big_hour +
                            " hours " +
                            "and " +
                            big_minute +
                            " minutes."
            );
        } else {
            System.out.println(
                    "The longest nap starts at " +
                            hh[max_index1] +
                            ":" +
                            String.format("%02d", mm[max_index1]) +
                            " and will last for " +
                            big_hour +
                            " hours " +
                            "and " +
                            big_minute +
                            " minutes."
            );

            long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
            long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
            System.out.println("time : " + secDiffTime);
        }
        sc.close();
    }
}
