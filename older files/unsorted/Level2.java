import java.util.*;

public class Level1 {
	
  public static int odometer(int [] oksana) {
    int N = oksana.length;
	int distancePerHour = 0;
	int distanceTotal = 0;
	for (int i = 0; i < N; i += 2) {
		if (i < 2) {
			distancePerHour = oksana[i] * oksana[i + 1];
		  }
		else {
			distancePerHour = oksana[i] * (oksana[i + 1] - oksana[i - 1]);
		  }
		distanceTotal += distancePerHour;
		}
		return distanceTotal;
  }
}