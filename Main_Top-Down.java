import java.util.*;

public class Main {
    static int[] A; // 인덱스 개수의 카드를 구입하는데 든 최소 비용
    static int[] P; // 인덱스 개의 카드를 포함하는 카드팩의 가격
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int card = sc.nextInt();
        A = new int[card+1];
        P = new int[card+1];
        for (int i=1;i<card+1;i++) {
            P[i] = sc.nextInt();
            A[i] = -1;
        }
        System.out.println(minPrice(card));
    }

    public static int minPrice(int num) {
        // Top-Down 방식
        // A[n] = n개의 카드를 구매하는 최소 비용, P[i] = i개의 카드를 포함하는 카드팩의 가격
        // 점화식 : A[n] = min(A[n-i] + P[i])
        if (num < 1) {
            return 0;
        }
        if (A[num-1] == -1) {
            A[num-1] = minPrice(num-1);
        }
        for (int i=1;i<num+1;i++) {
            if (A[num]==-1 || A[num] > A[num-i] + P[i]) {
                A[num] = A[num-i] + P[i];
            }
        }
        return A[num];
    }
}
