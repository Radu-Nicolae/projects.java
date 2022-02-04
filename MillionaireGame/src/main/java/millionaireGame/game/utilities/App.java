package millionaireGame.game.utilities;

import millionaireGame.database.DataBase;
import millionaireGame.question.Question;

import java.util.*;

public class App {

    static Scanner scn = new Scanner(System.in);
    static Random rnd = new Random();

    public static List<Question> separateQuestions(List<Question> questions, String difficulty) {
        List<Question> separatedQuestions = new ArrayList<>();

        for (Question question : questions) {
            if (question.getDifficulty().equalsIgnoreCase(difficulty)) {
                separatedQuestions.add(question);
            }
        }
        return separatedQuestions;
    }

    public static Integer[] shuffleArray(int size) {
        Integer[] shuffledArray = new Integer[size];

        for (int i = 0; i < size; i++) {
            shuffledArray[i] = i;
        }

        List<Integer> intList = Arrays.asList(shuffledArray);
        Collections.shuffle(intList);
        intList.toArray(shuffledArray);

        return shuffledArray;
    }

    public static List<Question> shuffleQuestions(Integer[] shuffledArray, List<Question> questions, int howMany) {
        List<Question> shuffledQuestions = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            shuffledQuestions.add(questions.get(shuffledArray[i]));
        }
        return shuffledQuestions;
    }

    public static List<String> printQuestion(Question question, int index) {
        List<String> strings = new ArrayList<>();
        String integers;

        String correctAnswer = "";
        int index2 = 0;

        List<String> answers = new ArrayList<>();
        answers.add(question.getCorrectAnswer());
        answers.add(question.getWrongAnswers().get(0));
        answers.add(question.getWrongAnswers().get(1));
        answers.add(question.getWrongAnswers().get(2));

        Integer[] intArray = new Integer[]{0, 1, 2, 3};

        Collections.shuffle(Arrays.asList(intArray));
        integers = intArray[0].toString() + intArray[1].toString() + intArray[2].toString() + intArray[3].toString();

        System.out.println("");
        System.out.println((++index) + ". " + question.getQuestion());
        System.out.println("A) " + answers.get(intArray[0]));
        System.out.println("B) " + answers.get(intArray[1]));
        System.out.println("C) " + answers.get(intArray[2]));
        System.out.println("D) " + answers.get(intArray[3]));
        System.out.println("You currently have " + DataBase.getPrize(index - 1) + "€.");

        System.out.print("\nYour answer: ");

        for (int i = 0; i < 4; i++) {
            if (intArray[i] == 0) {
                index2 = i;
            }
        }

        switch (index2) {
            case 0:
                correctAnswer = "A";
                break;
            case 1:
                correctAnswer = "B";
                break;
            case 2:
                correctAnswer = "C";
                break;
            case 3:
                correctAnswer = "D";
                break;
        }

        strings.add(correctAnswer);
        strings.add(integers);

        return strings;
    }

    public static String getUserAnswer() {
        String input;
        boolean isInputInvalid = true;

        do {
            input = scn.next();

            if (input.equalsIgnoreCase("A") || input.equalsIgnoreCase("B")
                    || input.equalsIgnoreCase("C") || input.equalsIgnoreCase("D")
                    || input.equalsIgnoreCase("retreat")
                    || input.equalsIgnoreCase("50") || input.equalsIgnoreCase("50 50")) {
                isInputInvalid = false;
            } else {
                System.out.print("Please choose a valid answer: ");
            }
        } while (isInputInvalid);

        return input;
    }

    public static String retreat(String checkpoint) {
        boolean isInputInvalid;
        String answer = "";

        System.out.println("Are you sure you want to retreat?");
        System.out.println("You will have " + checkpoint + "€.");
        System.out.print("Your answer: ");
        isInputInvalid = true;

        do {
            answer = scn.next();
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                isInputInvalid = false;
            } else {
                System.out.print("Please enter a valid answer: ");
            }
        } while (isInputInvalid);


        return answer;
    }


    public static List<Boolean> levels(List<Question> levelQuestions, int iterationsNo, int index, String checkpoint) {
        Question question;
        String correctAnswer;
        String input;
        boolean didHeRetreat = false;
        boolean didHeLose = false;
        boolean isGameNotOver = true;
        boolean is5050NotUsed = true;
        boolean isInputInvalid = true;

        List<Boolean> booleans = new ArrayList<>();

        for (int i = 0; i < iterationsNo; i++) {
            question = levelQuestions.get(i);
            List<String> strings = App.printQuestion(question, index);
            correctAnswer = strings.get(0);

            input = App.getUserAnswer();

            if (input.equalsIgnoreCase("retreat")) {
                String answer;
                answer = App.retreat(checkpoint);

                if (answer.equalsIgnoreCase("yes")) {
                    didHeRetreat = true;
                    isGameNotOver = false;
                    didHeLose = true;
                    break;
                } else {
                    System.out.print("Enter the answer for the previous question: ");
                    input = App.getUserAnswer();
                }
            }
            if (input.equalsIgnoreCase("50 50") || input.equalsIgnoreCase("50") || input.equalsIgnoreCase("5050")){
                if (is5050NotUsed){
                    fiftyFifty(question, strings.get(1));
                    input = App.getUserAnswer();
                    is5050NotUsed = false;
                }
                else {
                    System.out.println("You cannot use this option until the next checkpoint!");
                    System.out.println("\nChoose the correct letter!");
                    System.out.print("Your answer: ");
                    isInputInvalid = true;
                    do {
                        input = App.getUserAnswer();
                        if (input.equalsIgnoreCase("50")){
                            System.out.print("\nYou can't choose 50 50! You have already used this option for this checkpoint!");
                            System.out.print("\nYour answer: ");
                        }
                        else {
                            isInputInvalid = false;
                        }
                    }
                    while (isInputInvalid);
                }
            }
            if (input.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Congratulations! Correct answer!");
                index++;

            } else {
                isGameNotOver = false;
                didHeLose = true;
                break;
            }
        }

        booleans.add(didHeRetreat);
        booleans.add(didHeLose);
        booleans.add(isGameNotOver);

        return booleans;
    }


    public static void fiftyFifty(Question question, String integers) {
        List<String> wrongAnswers = question.getWrongAnswers();

        int wrongAnswerId = rnd.nextInt(3);
        int letterId;
        int letterIdCorrect;

        String wrongAnswer = wrongAnswers.get(wrongAnswerId);


        System.out.println("50 50 applied!");

        letterIdCorrect = integers.indexOf("0");



        int a = 0;
        for (int i = 0; i < question.getWrongAnswers().size(); i++) {
            if (wrongAnswer.equalsIgnoreCase(wrongAnswers.get(i))){
               a = i + 1;
               break;
            }
        }

        letterId = integers.indexOf(Integer.toString(a));




        if (letterId > letterIdCorrect){
            switch (letterIdCorrect){
                case 0:
                    System.out.println("A) " + question.getCorrectAnswer());
                    break;
                case 1:
                    System.out.println("B) " + question.getCorrectAnswer());
                    break;
                case 2:
                    System.out.println("C) " + question.getCorrectAnswer());
                    break;
                case 3:
                    System.out.println("D) " + question.getCorrectAnswer());
                    break;
            }

            switch (letterId){
                case 0:
                    System.out.println("A) " + wrongAnswer);
                    break;
                case 1:
                    System.out.println("B) " + wrongAnswer);
                    break;
                case 2:
                    System.out.println("C) " + wrongAnswer);
                    break;
                case 3:
                    System.out.println("D) " + wrongAnswer);
                    break;
            }

            System.out.print("\nYour answer: ");
        }

        else {
            switch (letterId){
                case 0:
                    System.out.println("A) " + wrongAnswer);
                    break;
                case 1:
                    System.out.println("B) " + wrongAnswer);
                    break;
                case 2:
                    System.out.println("C) " + wrongAnswer);
                    break;
                case 3:
                    System.out.println("D) " + wrongAnswer);
                    break;
            }

            switch (letterIdCorrect){
                case 0:
                    System.out.println("A) " + question.getCorrectAnswer());
                    break;
                case 1:
                    System.out.println("B) " + question.getCorrectAnswer());
                    break;
                case 2:
                    System.out.println("C) " + question.getCorrectAnswer());
                    break;
                case 3:
                    System.out.println("D) " + question.getCorrectAnswer());
                    break;
            }

            System.out.print("\nYour answer: ");
        }

    }


}
