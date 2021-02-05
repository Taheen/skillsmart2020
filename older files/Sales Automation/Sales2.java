import java.util.*;

public class Level1 {

    static String [] ShopOLAP(int N, String [] items){

        String [] duplicatesRemoved = removeDuplicates(items);
        String [] finalResult = bubbleSort(duplicatesRemoved);

        return finalString2(finalResult);
    }

    //removing duplicates, adding sale amounts
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

        String[] whatever = new String[list2.size()];
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

    //sorting elements with same sale amounts and different names
    static String[] finalString2 (String[] Str100){

        List<String> list222 = new ArrayList<>();
        for (int i = 0; i < Str100.length; i++){
            list222.add(Str100[i]);
        }

        ArrayList<String> duplicates = new ArrayList<>();
        duplicates.add(Str100[0]);

        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(0);

        for (int i = 1; i < Str100.length; i++){

            if (amount(Str100[i]) != amount(Str100[i - 1])) {
                Collections.sort(duplicates);
                for (int s = indexes.get(0), m = 0; m < indexes.size(); s++, m++){
                    list222.set(s, duplicates.get(m));
                }

                duplicates.clear();
                duplicates.add(Str100[i]);
                indexes.clear();
                indexes.add(i);
                continue;
            }

            duplicates.add(Str100[i]);
            indexes.add(i);

        }

        if (indexes.size() > 1) {
            Collections.sort(duplicates);
            for (int s = indexes.get(0), m = 0; m < indexes.size(); s++, m++){
                list222.set(s, duplicates.get(m));
            }

        }

        String[] sortedFinalStr = list222.toArray(new String[0]);
        return sortedFinalStr;
        
    }


}