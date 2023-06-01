# Simple-Quiz-Project

1. The 'Question' class:
The 'Question' class represents a single question in the quiz. It has three private fields:
- 'question': A String that holds the question text.
- 'options': An array of Strings that stores the available options for the question.
- 'correctOption': An integer representing the index of the correct option in the 'options' array.

It also includes the following methods:
- 'getQuestion()': A getter method that returns the question text.
- 'getOptions()': A getter method that returns the array of options.
- 'isCorrect()': A method that takes the index of a selected option as an argument and checks if it matches the correct option index. It returns 'true' if the selected option is correct, and 'false' otherwise.

2. The 'Quiz' class:
The 'Quiz' class manages the collection of questions and keeps track of the user's score. It has two private fields:
- 'questions': An array of 'Question' objects that holds all the questions in the quiz.
- 'score': An integer that keeps track of the user's score.

It includes the following methods:
- 'addQuestion()': A method that adds a 'Question' object to the 'questions' array. It dynamically increases the size of the array using 'System.arraycopy()'.
- 'start()': A method that starts the quiz. It uses a 'Scanner' object to receive user input for each question. It iterates through each question, displays the question text and options, prompts the user for an answer, checks if the answer is correct, updates the score accordingly, and provides feedback.
- 'remarks()': A method that prints remarks based on the user's score.

3. The 'QuizApp' class:
The 'QuizApp' class is the entry point of the program. It allows users to choose a subject category and creates a quiz accordingly. It includes the following methods:
- 'main()': The main method of the program. It prompts the user to select a subject category, creates a 'Quiz' object, and calls the appropriate method to create the quiz based on the user's choice. Finally, it starts the quiz by calling the 'start()' method of the 'Quiz' object.
- 'createGeneralScienceQuiz()', 'createGeneralKnowledgeQuiz()', 'createSpaceScienceQuiz()': These methods create quizzes with specific questions in different subjects. They create 'Question' objects and add them to the 'Quiz' object using the 'addQuestion()' method.

Overall, this code allows users to participate in quizzes by answering questions, provides immediate feedback on their score, and encourages learning through interactive programming.
