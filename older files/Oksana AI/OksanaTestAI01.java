public class OksanaTestAI {
    public static int SumOfThe(int N, int[] data){
        int finalint = 0;
        for(int i = 0; i < data.length; i++){
            if(findSumOfArray(data) - data[i] == data[i]){
                finalint = data[i];
                break;
            }
        }
        return finalint;
    }

    public static int findSumOfArray(int[] array){
        int sum = 0;
        for (int value: array) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        int arrLength = 7;
        int someArray[] = {10, -25, -45, -35, 5};
        System.out.println(SumOfThe(7,someArray));


    }
}
