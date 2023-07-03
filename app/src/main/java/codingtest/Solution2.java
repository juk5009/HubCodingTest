package codingtest;

public class Solution2 {
    private static int getGCD(int a, int b) {
        while (b != 0) {
            int result = a % b;
            a = b;
            b = result;
        }
        return a;
    }

    private static int getLCM(int a, int b) {
        int gcd = getGCD(a, b);
        return (a * b) / gcd;
    }

    public static boolean sameCheck(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Integer solution(int[] arr) {
        // 배열 길이가 3 미만인 경우 예외 처리
        if (arr.length < 3) {
            System.out.println("배열의 길이는 최소 3이어야 합니다.");
            return null;
        }

        // 중복 체크
        if (sameCheck(arr)) {
            System.out.println("중복된 원소가 있습니다.");
            return null;
        }

        int lcmSum = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int lcm = getLCM(arr[i], arr[j]);
                lcmSum += lcm;
            }
        }

        return lcmSum;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1 };
        Integer result = solution(arr);
        if (result != null) {

            System.out.println(result);
        }
    }
}
