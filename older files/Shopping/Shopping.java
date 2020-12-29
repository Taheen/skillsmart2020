import java.util.*;

public class Shopping {

    static int MaximumDiscount(int N, int [] price) {
        int discount = 0 ;

        Arrays.sort(price);
        int [] sortDescend = new int [N];
        for (int i = 0, j = N - 1; i < N; i++, j--){
            sortDescend[j] = price[i];
        }

        if (N < 3){
            discount = 0;
        }
        else if (N == 3){
            discount = sortDescend[N - 1];
        }
        else {
            for (int k = 2; k < N; k += 3){
                discount = discount + sortDescend[k];
            }
        }

        return discount;
    }

    public static void main(String[] args) {

        int [] prices = new int[] {40, 40, 100, 100, 111, 111, 50, 60, 70, 20, 20, 20, 10};
        int L = prices.length;


        System.out.println(MaximumDiscount(L, prices));



    }
}
