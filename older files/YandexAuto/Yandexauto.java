public class Yandexauto {
    public static int Unmanned(int L, int N, int [][] track){

        int initialTime = L;
        int totalTime = 0; //final result
        int light = 0;
        int stop = 0;
        int red = 0;
        int green = 0;

        for (int i = 1; i <= initialTime; i++){
            totalTime++;

            if (light < (N - 1) && track[light][0] == i) {  //reached traffic light
                stop = i;
                red = track[light][1];
                green = track[light][2];
                if (stop > (red + green)) {
                    stop = totalTime % (red + green);
                }

                if (stop > red) { //green light
                    light++;
                }
                else { //red light
                    light++;
                    totalTime = totalTime + (green - stop); // adding stoppage time
                }
            }
        }
        return totalTime;
    }

    public static void main(String[] args) {
        int initialTime = 10;
        int N = 2;
        int [][] lights = {{3, 5, 5}, {5, 2, 2}};



        System.out.println(Unmanned(initialTime, N, lights));

    }
}
