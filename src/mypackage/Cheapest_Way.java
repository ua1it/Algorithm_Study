package mypackage;
import java.lang.Math;

// Explain the question.
// Given a mxn matrix of integers, you are to write a program that computes a path of minimal weight from left to right across the matrix.
// The weight of a pate is the sum of the integers in each of the n cells of the matrix that are visited.

//Sample
// 3 4 1 2 8 6
// 6 1 8 2 7 4
// 5 9 3 9 9 5
// 8 4 1 3 2 6
// 3 7 2 1 2 3

//Output
// 11 (Cheapest Way)
// 3 -> 1 -> 1 -> 1 -> 2 -> 3


// 재귀함수를 통해서 모든 path를 계산하고, 그 path에서 가장 작은 값을 결과값으로 도출.
// 첫번째 줄에서의 최소, 두번째 줄에서의 최소.. 를 다 구한 뒤에(cheapSum)
// cheapSum에서 구한 모든 최소에서 제일 최소를 구하는(CheapestWay)

// 재귀함수를 쓸 때는, return을 먼저 쓰는게 이해에 도움이 될 것 같다. return이 어떻게 돌아갈지 계산하고, 그 return에 따른 과정을 구하는 편이 내 머리로는 이해가 더 잘 됨.
public class Cheapest_Way {

    static int[][] test =
           // {{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,8,6,4}};
          {{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,1,2,3}};
    static int row = 5;
    static int col = 6;
    static int INT_MAX = 100;
    static int[] dy = {-1,0,1};
    static int[] dx = {1,1,1};


    public static int cheapSum(int r, int c){ // 각 줄마다 최소를 탐색
        if(r == row)
            return cheapSum(0,c);
        if(r == -1)
            return cheapSum(row-1,c);
        if(c == col - 1)
            return test[r][c];

        int min = INT_MAX;
        for(int i = 0; i < 3; i++){
            min = Math.min(min, cheapSum(r+dy[i],c+dx[i]));
        }
        return test[r][c] + min;

    }

    public static int cheapestWay() { // 전체에서 최소를 탐색
        int min = INT_MAX;
        for(int i = 0; i < row; i++)
        {
            min = Math.min(min, cheapSum(i,0));
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(cheapestWay());
    }
}
