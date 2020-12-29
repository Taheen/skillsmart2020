import java.util.*;

public class Level1 {

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

}