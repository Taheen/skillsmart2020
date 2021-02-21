import java.util.*;

public class Level1 {

    public static int undoMarker = 0;
    public static boolean undoReset = false;
    public static StringBuilder finalString = new StringBuilder();

    public static LinkedList commandList = new LinkedList();
    public static LinkedList redoList = new LinkedList();


    static String BastShoe(String command){

        //possible error checks
        if (command == null || command.isEmpty())
            return finalString.toString();
        char c = command.charAt(0);
        //command in not a number between 1 - 5
        if (c < '0' || c > '5')
            return finalString.toString();
        //commands 1-3 do not contain whitespace or shorter than 3 characters
        if ((c > '0' && c < '4') && (!command.contains(" ") || command.length() < 3)) {
            return finalString.toString();
        }
        //commands 2-3 contain not digits
        if (c == '2' || c == '3') {
            String test = subString1(command);
            for (char t : test.toCharArray()) {
                if (!Character.isDigit(t)) {
                    return finalString.toString();
                }
            }
        }
        //commands 4-5 are longer than 1 symbol
         if ((c == '4' || c == '5') && command.length() > 1)
            return finalString.toString();


        // Command 3 - returning Char at index (as string)
        if (operationNumber(command) == 3) {
            int displayIndex = numberOfSymbolsToRemove(command);
            StringBuilder someString = new StringBuilder();
            if (displayIndex <= finalString.length()) {
                someString.append(finalString.charAt(displayIndex));
                return someString.toString();
            }
            return "";

        }

        // adding command to commandList
        if (operationNumber(command) == 1 || operationNumber(command) == 2) {
            if (undoReset) {
                undoMarker = commandList.size();
                undoReset = false;
            }
            commandList.add(command);
            redoList.clear();
        }

        // Command 4 - Undo
        if (command.equals("4")) {
            undoReset = true;
            if (commandList.size() > undoMarker) {
                redoList.add(commandList.removeLast());
            }
        }

        // Command 5 - Redo
        if (command.equals("5")) {
            if (redoList.size() > 0) {
                commandList.add(redoList.removeLast());
            }
        }

        finalString.setLength(0);
        executeCommands(commandList);

        return finalString.toString();
    }

    public static void executeCommands (LinkedList<String> inputList) {

        for (int i = 0; i < inputList.size(); i++) {

            // Command 1 - add clean
            if (inputList.size() > 0 && operationNumber(inputList.get(i)) == 1) {
                finalString.append(subString1(inputList.get(i)));
            }

            // Command 2 - delete clean
            if (inputList.size() > 0 && operationNumber(inputList.get(i)) == 2) {
                int amount = numberOfSymbolsToRemove(subString1(inputList.get(i)));
                int length = finalString.length();

                if (amount > length) {
                    finalString.setLength(0);
                } else {
                    finalString.delete(length - amount, length);
                }
            }
        }

    }

    // extracting command number from given string (for all commands)
    static int operationNumber (String inputStr1){
        int finalAmount;
        int spaceIndex;
        spaceIndex = inputStr1.indexOf(' ');

        if (inputStr1.length() == 1){
            finalAmount = Integer.parseInt(inputStr1);
        }
        else {
            String subs1 = inputStr1.substring(0, spaceIndex);
            finalAmount = Integer.parseInt(subs1);
        }
        return finalAmount;
    }

    // extracting substring after whitespace (for command 1)
    static String subString1 (String inputStr2){
        int spaceIndex1;
        spaceIndex1 = inputStr2.indexOf(' ');
        String subs2 = inputStr2.substring(spaceIndex1 + 1);
        return subs2;
    }

    // extracting substring after whitespace, convert to int (for command 2)
    static int numberOfSymbolsToRemove(String inputStr3){
        int amountOfSymbolsToRemove;
        int spaceIndex2;
        spaceIndex2 = inputStr3.indexOf(' ');
        String subs3 = inputStr3.substring(spaceIndex2 + 1);
        amountOfSymbolsToRemove = Integer.parseInt(subs3);
        return  amountOfSymbolsToRemove;
    }

}