package mypackage;
import java.util.Scanner;
import java.lang.Math;

// Explain the question.
// For each dots, a line follows; each following line contains two real numbers indication the (x, y) coordinates of the dots.
// Program must print a single real number to two decimal places: the minimum total length of link lines that can connect all the dots.

//Sample

//Input
// 5
// 1 1
// 1 2
// 2 1
// 2 2
// 5 5

//Output
// 7.24

class coordinate{
    double x;
    double y;
}
public class SavingInk {
    static int MAX = 1000;

    public static double DistanceBetween(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt((Math.pow((x2-x1),2)) + (Math.pow((y2-y1),2)));
    }

    public static double SaveInk(coordinate[] c, int n)
    {
        double[] distances = new double[n];
        for(int i = 0; i < n-1; i++)
        {
            distances[i] = DistanceBetween(c[i].x, c[i].y, c[i+1].x, c[i+1].y);
        }
        distances[n-1] = DistanceBetween(c[0].x,c[0].y,c[n-1].x,c[n-1].y); // 가장 높은 점 - 가장 작은 점

        double min = MAX;
        double sum = 0;
        for(int i = 0; i < n; i++){
            int j = i;
            for(int k = 0; k < n-1; k++){
                if(j == n-1) j = 0; // 넘어가면 다시 0으로 돌아오기.
                sum += distances[j];
                j++;
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    public static void Bsort(coordinate[] c, int n)
    {
        for(int i =1; i < n; i++){
            for(int j = 0; j < n - i; j ++)
            {
                if(c[j].y > c[j+1].y){ // y 값 비교
                    double y = c[j].y;
                    c[j].y = c[j+1].y;
                    c[j+1].y = y;

                    double x = c[j].x;
                    c[j].x = c[j+1].x;
                    c[j+1].x = x;
                }
            }
        }
        for(int i =1; i < n; i++){
            for(int j = 0; j < n - i; j ++) // 시작 지점의 x는 가장 오른쪽이고, 그 다음부터는 왼쪽이 우선.
            {
                if(c[j].y == c[j+1].y) {
                    if(j == 0){
                        if(c[j].x < c[j + 1].x){ // 시작 지점의 x는 오른쪽
                            double x = c[j].x;
                            c[j].x = c[j + 1].x;
                            c[j + 1].x = x;
                        }
                    }
                    else if (c[j].x > c[j + 1].x) { // 시작 지점 이외의 x는 왼쪽 먼저.
                        double x = c[j].x;
                        c[j].x = c[j + 1].x;
                        c[j + 1].x = x;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        coordinate[] c = new coordinate[n];
        for(int i = 0; i < n; i++){
            c[i] = new coordinate();
            c[i].x = sc.nextDouble();
            c[i].y = sc.nextDouble();
        }
        Bsort(c, n);
        System.out.println(SaveInk(c, n));
    }
}