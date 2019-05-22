import java.io.File;
import java.util.*;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
//        prompt user for name
        System.out.print("Please Enter Your Name: ");
        String userName = read.nextLine();

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
                quizSet.put(indexPosition,txt);
                count ++;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
//        hashmap for random questions
        HashMap<Integer, String> randomSet = new HashMap<>();
//        prompt user with randomized questions
        Integer count = 0;
        Integer correctAnswer =0;
        for (int i : printRandomNumbers(5,5)) {
//            System.out.println(i);
//            System.out.println(quizSet.get(i));
            randomSet.put(count,quizSet.get(i));
//            formatQuestions(randomSet.get(count))
            if(formatQuestions(randomSet.get(count))){
                correctAnswer ++;
            }
            count ++;
        }
        System.out.println(userName + " you score is " + correctAnswer + "/5");
    }

    private static Boolean formatQuestions(String questionSet){

        Scanner read = new Scanner(System.in);

//        parse question set into question, choices, and correct answer
        String question = questionSet.split(",")[0];
        String choiceA = questionSet.split(",")[1];
        String choiceB = questionSet.split(",")[2];
        String choiceC = questionSet.split(",")[3];
        String choiceD = questionSet.split(",")[4];
        String answer = questionSet.split(",")[5];

//        prompt user with question and choices and grab their answer
        System.out.println(ANSI_CYAN + question.toUpperCase() + ANSI_RESET);
        System.out.println("A. " + choiceA);
        System.out.println("B. " + choiceB);
        System.out.println("C. " + choiceC);
        System.out.println("D. " + choiceD);
        String userAnswer = read.nextLine();

        Boolean quizScore=false;

//        check the user answer to see if it is correct
        if(userAnswer.toLowerCase().equals("a") && answer.equals("1")){
            quizScore =true;
            System.out.println(ANSI_YELLOW +"CORRECT"+ ANSI_RESET);
        }
        else if(userAnswer.toLowerCase().equals("b") && answer.equals("2")){
            quizScore =true;
            System.out.println(ANSI_YELLOW +"CORRECT"+ ANSI_RESET);
        }
        else if(userAnswer.toLowerCase().equals("c") && answer.equals("3")){
            quizScore =true;
            System.out.println(ANSI_YELLOW +"CORRECT"+ ANSI_RESET);
        }
        else if(userAnswer.toLowerCase().equals("d") && answer.equals("4")){
            quizScore =true;
            System.out.println(ANSI_YELLOW +"CORRECT"+ ANSI_RESET);
        }
        else{
            System.out.println(ANSI_YELLOW +"INCORRECT"+ ANSI_RESET);
        }

       return quizScore;
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
