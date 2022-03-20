package mypackage;

// Explain the question.
// A subsequence of a given sequence S consists of S with zero or more elements deleted.
// Write a program that counts the number of occurrences of Z in X as a subsequence such that each has a distinct index sequence.

//Sample
//babgbag
//bag               -> Output : 5
//rabbbit
//rabbit            -> Output : 3


public class Distinct_Subsequence {

    // 2차원 dp를 구현. ansarr에서 시작하고, 해당되는 word가 완성되었을 때, 왼쪽 위 + 왼쪽으로 dp[i][j] 설정하기.
    public static void main(String[] args) {

        String pw = "babgbag";
        String ans = "bag";

        String[] pwarr = pw.split("");
        String[] ansarr = ans.split("");

        int[][] dp = new int[ansarr.length][pwarr.length];
        String word = "";
        for(int i = 0; i < ansarr.length; i++){
            int path = 0;
            word = word + ansarr[i];
            int count = 0;

            char li = word.charAt(word.length() - 1);
            String last_index = Character.toString(li);

            for(int j = 0; j < pwarr.length; j++) {
                for (int k = 0; k < word.length(); k++) {
                    if (ansarr[k].equals(pwarr[j])) {
                        count++;
                    }
                }
                if (count >= word.length()) {
                    if (i == 0 && pwarr[j].equals(last_index)) path += 1;
                    else if (pwarr[j].equals(last_index))
                        path = dp[i - 1][j - 1] + dp[i][j - 1];
                }
                dp[i][j] = path;
            }
        }
        // dp 배열 출력
//        for(int i = 0; i < ansarr.length; i++){
//            for(int j = 0; j < pwarr.length; j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println("Count: "+dp[ansarr.length-1][pwarr.length-1]);

    }
}
