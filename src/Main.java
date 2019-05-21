import java.io.File;
import java.util.*;

public class Main {

    private static void getQuestion(){
        HashMap<String, String> quizSet = new HashMap<>();
        try{
            File file = new File("quizzer.txt");
            Scanner read = new Scanner(file);
            while (read.hasNextLine()){
//                System.out.println(read.nextLine());
                String txt = read.nextLine();
                String question = txt.split(",")[0];
                String answer = txt.split(",")[5];
//                System.out.println(question);
//                System.out.println(answer);
                quizSet.put(question,answer);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(quizSet);
    }

    private static final Random gen = new Random();
    private static int[] printRandomNumbers(int n, int maxRange) {
        assert n <= maxRange : "cannot get more unique numbers than the size of the range";

        int[] result = new int[n];
        Set<Integer> used = new HashSet<>();

        for (int i = 0; i < n; i++) {

            int newRandom;
            do {
                newRandom = gen.nextInt(maxRange+1);
            } while (used.contains(newRandom));
            result[i] = newRandom;
            used.add(newRandom);
        }
        return result;
    }

    private static void iterateRandom() {

        for (int i : printRandomNumbers(5,6)) {
            System.out.println(i);
        }

    }

    private static void promptUser(){
        Scanner read = new Scanner(System.in);

        System.out.print("Please Enter Your Name: ");
        String userName = read.nextLine();

        iterateRandom();

        System.out.println("Enter option A, B, C or D");
        String choice1 = read.next();
        System.out.println("Enter option A, B, C or D");
        String choice2 = read.next();
        System.out.println("Enter option A, B, C or D");
        String choice3 = read.next();

        System.out.println(userName + " chose " + choice1 + choice2 + choice3);
    }

    public static void main(String[] args) {
        getQuestion();
    }
}
