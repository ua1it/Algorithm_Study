package mypackage;
import java.util.ArrayList;
import java.lang.Math;

public class Anything {
    static int[][] test =
            {{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,8,6,4}};
    //{{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,1,2,3}};
    static int row = 5;
    static int col = 6;
    static int INT_MAX = 100;
    static int[] dy = {-1,0,1};
    static int[] dx = {1,1,1};


    public static int cheapSum(int r, int c){
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

    public static int cheapestWay() {
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
