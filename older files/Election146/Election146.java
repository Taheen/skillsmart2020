public class Election146 {

    public static String MassVote(int N, int [] Votes){
        float totalVotes = 0;
        int mostVote = Votes[0];
        int candidate = 0;
        int j = 0;
        float percentage = 0;

        for (int i = 0; i < Votes.length; i++){
            totalVotes = totalVotes + Votes[i];
        }

        for (j = 1; j < Votes.length; j++){
            if (Votes[j] > mostVote){
                mostVote = Votes[j];
                candidate = j;
            }
            else if (Votes[j] == mostVote){
                return "no winner";
            }
        }
        percentage = (totalVotes/Votes[candidate]);

        if (percentage >= 2) {
            String finalResult = "minority winner " + (candidate + 1);
            return finalResult;
        }
        else {
            String finalResult = "majority winner " + (candidate + 1);
            return finalResult;
        }
    }

}
