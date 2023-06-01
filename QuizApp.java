import java.util.Scanner;
class Question {
    private final String question;
    private final String[] options;
    private final int correctOption;

    // Constructor for Question class
    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Getter method for question
    public String getQuestion() {
        return question;
    }

    // Getter method for options
    public String[] getOptions() {
        return options;
    }

    // Method to check if selected option is correct
    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOption;
    }
}

class Quiz {
    private Question[] questions;
    private int score;

    // Constructor for Quiz class
    public Quiz() {
        questions = new Question[0];
        score = 0;
    }

    // Method to add a question to the quiz
    public void addQuestion(Question question) {
        // Create a new array with increased length
        Question[] newQuestions = new Question[questions.length + 1];
        // Copy existing questions to the new array
        System.arraycopy(questions, 0, newQuestions, 0, questions.length);
        // Add the new question at the end
        newQuestions[questions.length] = question;
        // Update the questions array with the new array
        questions = newQuestions;
    }

    // Method to start the quiz
    public void start() {
        Scanner sc = new Scanner(System.in);

        // Iterate through each question
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            String[] options = question.getOptions();

            // Display options
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            // Prompt for user input
            System.out.print("Enter your answer (1-" + options.length + "): ");
            int selectedOption = sc.nextInt();

            // Check if the selected option is correct and update the score
            if (question.isCorrect(selectedOption)) {
                System.out.println("Correct!!  😁");
                score++;
            } else {
                System.out.println("Incorrect!!  ☹️");
            }

            System.out.println();
        }

        // Display final score
        System.out.println("Quiz finished. Your score: " + score + "/" + questions.length);
        remarks(score);
    }

    public void remarks(int score) {
        switch (score) {
            case 0 -> System.out.println("Better luck next time!! 😔");
            case 1 -> System.out.println("Its Okay! you can do better.. 🙂");
            case 2 -> System.out.println("Very good!! 😊");
            case 3 -> System.out.println("Impressive!! 😁");
            case 4 -> {
                System.out.println("🎉🎉🎊🎊🥳🥳");
                System.out.println("Excellent!! you're a champ.. 😎");
            }
        }
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Quiz quiz = new Quiz();

        // Display subject categories for the quiz
        System.out.println("Select a subject category for the quiz:");
        System.out.println("1. General Science");
        System.out.println("2. General Knowledge");
        System.out.println("3. Space Science");
        int chosenSubject = sc.nextInt();

        // Create quiz based on user's choice
        if (chosenSubject == 1) {
            createGeneralScienceQuiz(quiz);
        } else if (chosenSubject == 2) {
            createGeneralKnowledgeQuiz(quiz);
        }else if(chosenSubject==3){
            createSpaceScienceQuiz(quiz);
        }
        else {
            System.out.println("Invalid input. Exiting the program.");
            return;
        }

        // Start the quiz
        quiz.start();
    }

    // Method to create general science quiz
    public static void createGeneralScienceQuiz(Quiz quiz) {
        String[] q1Options = { "Tungsten", "Gold", "Silver", "Aluminium" };
        Question q1 = new Question("Q1. Which is the most malleable and ductile metal?", q1Options, 2);
        quiz.addQuestion(q1);

        String[] q2Options = { "Transpiration", "Phosphorylation", "Photosynthesis", "Osmosis" };
        Question q2 = new Question("Q2. By which process do plants prepare food?", q2Options, 3);
        quiz.addQuestion(q2);

        String[] q3Options = { "Transformer", "Transistor", "Diode", "Resistor" };
        Question q3 = new Question("Q3. A ______ (semiconductor) is a device to control the flow of current.", q3Options, 2);
        quiz.addQuestion(q3);

        String[] q4Options = { "Wasted food", "Glass", "Plastic", "Non-organic pesticides" };
        Question q4 = new Question("Q4. Which of the following is a biodegradable substance?", q4Options, 1);
        quiz.addQuestion(q4);
    }

    // Method to create general knowledge quiz
    public static void createGeneralKnowledgeQuiz(Quiz quiz) {
        String[] q1Options = { "Lal Bahadur Shastri", "Rajendra Prasad", "A.P.J. Abdul Kalam", "Jawahar Lal Nehru" };
        Question q1 = new Question("Q1. Who was the first president of India?", q1Options, 2);
        quiz.addQuestion(q1);

        String[] q2Options = { "North America", "Africa", "Asia", "Australia" };
        Question q2 = new Question("Q2. Which is the biggest continent in the world?", q2Options, 3);
        quiz.addQuestion(q2);

        String[] q3Options = { "Nile River", "Amazon River", "Ganges", "Volga River" };
        Question q3 = new Question("Q3. Which is the longest river in the world?", q3Options, 1);
        quiz.addQuestion(q3);

        String[] q4Options = { "Alfred Nobel", "Michael Faraday", "G. Marconi", "Graham Bell" };
        Question q4 = new Question("Q4. Who invented the radio?", q4Options, 3);
        quiz.addQuestion(q4);
    }

    //Method to create space science quiz
    public static void createSpaceScienceQuiz(Quiz quiz) {
        String[] q1Options = { "Mercury", "Jupiter", "Venus", "Mars" };
        Question q1 = new Question("Q1. Which planet is closest to sun?", q1Options, 1);
        quiz.addQuestion(q1);

        String[] q2Options = { "Neptune", "Saturn", "Jupiter", "Uranus" };
        Question q2 = new Question("Q2. Second biggest planet in our solar system is?", q2Options, 2);
        quiz.addQuestion(q2);

        String[] q3Options = { "Mercury", "Earth", "Venus", "Mars" };
        Question q3 = new Question("Q3. Which planet is known as 'Red planet'?", q3Options, 4);
        quiz.addQuestion(q3);

        String[] q4Options = { "Oxygen", "Helium", "Hydrogen", "Nitrogen" };
        Question q4 = new Question("Q4. Which is the most abundant element in the universe?", q4Options, 3);
        quiz.addQuestion(q4);
    }
}
