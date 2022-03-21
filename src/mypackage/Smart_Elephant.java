package mypackage;

// Explain the question
// If these sequence of n elephants are a[1], a[2], …, a[n] then it must  be the case that W(weight) S(IQ)
// W[a[1]] < W[a[2]]< … < W[a[n]] and S[a[1]] > S[a[2]] > … > S[a[n]]i
// In order for the answer to be correct, n must be as large as possible.
// All  inequalities are strict: weights must be strictly increasing, and IQs must  be strictly decreasing.


//Sample input              Sample Output
// 6008 1300                4 (num)
// 6000 2100                4
// 500 2000                 5
// 1000 4000                9
// 1100 3000                7
// 6000 2000
// 8000 1400
// 6000 1200
// 2000 1900


class elephant{
    int we;
    int iq;
    int num;
}

public class Smart_Elephant {

    public static void Sort(elephant[] e, int n){
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n - i; j++) {
                if (e[j].we > e[j+1].we) {
                    int temp = e[j].we;
                    e[j].we = e[j+1].we;
                    e[j+1].we = temp;

                    int temp1 = e[j].iq;
                    e[j].iq = e[j+1].iq;
                    e[j+1].iq = temp1;

                    int temp2 = e[j].num;
                    e[j].num = e[j+1].num;
                    e[j+1].num = temp2;
                }
            }
        }
    }

    public static int find_max(int[] arr){
        int max = arr[0];
        int max_index = 0;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]) {
                max = arr[i];
                max_index = i;
            }
        }
        return max_index;
    }

    public static void find_ans(elephant[] e, int[] answer, int n){
        int[] count = new int[n];
        int[][] ans = new int[n][n];
        int next = 0;

        for(int i = 0; i < n; i ++){
            for(int j = i; j < n-1; j ++) {
                if(j == i){
                    next = e[i].iq;
                    ans[i][0] = e[i].num;
                }
                if (next > e[j + 1].iq) {
                    next = e[j + 1].iq;
                    count[i] += 1;
                    ans[i][j + 1] = e[j + 1].num;
                }
            }

        }
        int max_index = find_max(count);

        System.out.println("answer");
        for(int i = 0; i < n; i++){
            answer[i] = ans[max_index][i];
            if(answer[i] == 0) continue;
            System.out.println(answer[i]);
        }



    }


    public static void main(String[] args) {
        //Sample Input : Both Integers are between 1 and 10,000. And most 1,000 elephants.
//        int[] W = {6008, 6000, 500, 1000, 1100, 6000, 8000, 6000, 2000};
//        int[] S = {1300, 2100, 2000, 4000, 3000, 2000, 1400, 1200, 1900};
//        int[] W = {6000, 1000, 8000, 2000, 6008, 500};
//        int[] S = {2100, 4000, 1400, 1900, 1300, 2000};
        int[] W = {6008, 6000, 500, 1000, 1100, 8000, 3000, 2000};
        int[] S = {1300, 2100, 2000, 3500, 4000, 1400, 1500, 1900};
        int n = W.length;

        int[] answer = new int[n];
        elephant[] e = new elephant[n];
        for(int i = 0; i < n; i++){
            e[i] = new elephant();
            e[i].we = W[i];
            e[i].iq = S[i];
            e[i].num = i + 1;
        }

        Sort(e,n);
        find_ans(e, answer, n);



//        Checking Structure
//        for(int i = 0; i < n; i ++){
//            System.out.println("Weight: "+e[i].we+" IQ: "+e[i].iq+" Num: "+e[i].num);
//        }



    }
}
