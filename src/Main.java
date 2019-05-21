import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
//        prompt user for name
        System.out.print("Please Enter Your Name: ");
        String userName = read.nextLine();

        System.out.println("User: " + userName);

//        create hashmap of questions with position keys
        HashMap<Integer, String> quizSet = new HashMap<>();
        try{
//            read file
            File file = new File("quizzer.txt");
            Scanner readFile = new Scanner(file);
            Integer count = 0;
//            fill hashmap with questions
            while (readFile.hasNextLine()){
                String txt = readFile.nextLine();
                Integer indexPosition = count;
                String question = txt;
                quizSet.put(indexPosition,question);
                count ++;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
//        hashmap for random questions
        HashMap<Integer, String> randomSet = new HashMap<>();
//        prompt user with randomized questions
        for (int i : printRandomNumbers(5,6)) {
            if(quizSet.get(i) != null){
                Integer count = 0;
                System.out.println(quizSet.get(i));
                randomSet.put(count,quizSet.get(i));
                String answer = read.nextLine();
                count ++;
            }
        }
        System.out.println("Thanks " + userName);
    }

//    get some amount of random numbers (n) between some range(maxRange)
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
}
