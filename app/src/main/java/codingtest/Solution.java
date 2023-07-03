package codingtest;

public class Solution {

    public static int solution(int a) {
        if (a < 4) {
            System.out.println("a값은 4이상이어야 합니다.");
            return 0;
        }

        boolean[] decimals = new boolean[a + 1];
        decimals[0] = decimals[1] = false;

        for (int i = 2; i <= a; i++) {
            decimals[i] = true;
        }

        for (int i = 2; i * i <= a; i++) {
            if (decimals[i]) {
                for (int j = i * i; j <= a; j += i) {
                    decimals[j] = false;
                }
            }
        }

        int sum = 0;
        for (int i = 2; i <= a; i++) {
            if (decimals[i]) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int a = 5;
        int result = solution(a);

        a = 5;
        result = solution(a);
        System.out.println(result);

        a = 50;
        result = solution(a);
        System.out.println(result);

        a = 4;
        result = solution(a);
        System.out.println(result);

    }
}
