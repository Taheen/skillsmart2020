import java.util.*;

public class Sales {

    static String [] ShopOLAP(int N, String [] items){
        String [] duplicatesRemoved = removeDuplicates(items);
        String [] finalResult = bubbleSort(duplicatesRemoved);
        //sorting same sales groups (same sales numbers after whitespace)
        int offset = 0;
        for (int i = 1; i < finalResult.length; i++){
            if (amount(finalResult[i]) != amount(finalResult[i - 1])){
                Arrays.sort(finalResult, offset, i);
                offset = i;
            }
        }
        return finalResult;
    }

    static String[] removeDuplicates(String[] inputString) {
        int sum = 0;

        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < inputString.length; i++){
            list2.add(inputString[i]);
        }

        //creating array for duplicate item names
        ArrayList<Integer> duplicates = new ArrayList<>();
        int length = list2.size();

        //outer loop for name check
        for (int j = 0; j < length; j++) {
            sum = amount(list2.get(j));


            for (int i = j + 1; i < length; i++) {
                //calculating sum of sales of duplicate names
                if (itemName(list2.get(j)).equals(itemName(list2.get(i)))){
                    duplicates.add(i);
                    sum = sum + amount(list2.get(i));
                }
            }

            if (duplicates.size() == 1) {
                int a = duplicates.get(0);
                list2.remove(a);
                length--;
                //replacing current item with same name + total sales
                list2.set(j, itemName(list2.get(j)) + " " + sum);
                }

            if (duplicates.size() > 1) {
                int dupSize = duplicates.size();
                for (int r1 = dupSize - 1; r1 >= 0; r1--){
                    int a = duplicates.get(r1);
                    list2.remove(a);
                }
                length = length - dupSize;
                //replacing current item with same name + total sales
                list2.set(j, itemName(list2.get(j)) + " " + sum);
            }

            duplicates.clear();
        }

        String [] whatever = new String[list2.size()];
        list2.toArray(whatever);
        return whatever;
    }

    //method to extract numbers after whitespace as an int
    static int amount (String inputSubstr){
        int finalAmount = 0;
        int spaceIndex = 0;
        spaceIndex = inputSubstr.indexOf(' ');
        String subs = inputSubstr.substring(spaceIndex + 1);
        finalAmount = Integer.parseInt(subs);
        return finalAmount;
    }

    //method to extract item name (substring before whitespace)
    static String itemName (String inputStr1){
        int spaceIndex1 = 0;
        spaceIndex1 = inputStr1.indexOf(' ');
        String subs = inputStr1.substring(0, spaceIndex1);
        return subs;
    }

    // method to sort string array descending by numbers after whitespace
    static String[] bubbleSort(String[] inputStr3) {
        List<String> list1 = new ArrayList<>();

        for (int i = 0; i < inputStr3.length; i++){
            list1.add(inputStr3[i]);
        }
        list1.add("!!!temp!!!");
        int n = list1.size();

        for (int i = 0; i < (n - 1); i++) {

            for (int j = 1; j < (n - i - 1); j++) {

                if (amount(list1.get(j - 1)) < (amount(list1.get(j)))) {
                    list1.set(n - 1, list1.get(j - 1));
                    list1.set(j - 1, list1.get(j));
                    list1.set(j, list1.get(n - 1));
                }
            }
        }
        list1.remove(n - 1);

        String[] sortedStringArr = list1.toArray(new String[0]);
        return sortedStringArr;
    }



    public static void main(String[] args) {
        String[] test = {"bag32 22", "bag33 22"};
        int n = 8;

        String[] ttt = (ShopOLAP(n, test));
        System.out.println(Arrays.toString(ttt));





    }
}
