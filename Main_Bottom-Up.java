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
        // Bottom-Up 방식
        // A[n] = n개의 카드를 구매하는 최소 비용, P[i] = i개의 카드를 포함하는 카드팩의 가격
        // 점화식 : A[n] = min(A[n-i] + P[i])
        for (int i=1;i<num+1;i++) {
            for (int j=1;j<i+1;j++) {
                if (A[i]==-1 || A[i] > A[i-j] + P[j]) {
                    A[i] = A[i-j] + P[j];
                }
            }
        }
        return A[num];
    }
}
