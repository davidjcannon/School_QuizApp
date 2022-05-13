import java.util.*;

enum Type {tf, select}

public class Project6 {
    public static class QuizApp {

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Question> quiz1Questions = new ArrayList<>();
        ArrayList<Question> quiz2Questions = new ArrayList<>();
        ArrayList<Quiz> quizes = new ArrayList<Quiz>();

        public static void main(String[] args) {

            QuizApp quizapp = new QuizApp();
            quizapp.createUser();
            quizapp.createQuizQuestions();
            quizapp.printQuiz(0);
            quizapp.printInstructQuiz(0);
            quizapp.printQuiz(1);
            quizapp.printInstructQuiz(1);
        }

        public void createUser() {
            users.add(new User("David", "david@dccc.edu", true));
        }

        public void printQuiz(int quizNum) {
            System.out.println(users.toString());

            System.out.println(quizes.get(quizNum).toString());

            // Generates first number
            int num = (int)(Math.random() * (4));

            // Adds to list of used numbers
            ArrayList<Integer> usedID = new ArrayList<Integer>();
            // Saves question 1
            usedID.add(num);

            // Question 1
            System.out.println("1. " + quizes.get(quizNum).questions.get(num).toString());
            printAnswers(quizNum, num);

            // Gives next new question
            num = refreshNum(usedID, num);
            // Saves question 2
            usedID.add(num);

            // Question 2
            System.out.println("2. " + quizes.get(quizNum).questions.get(num).toString());
            printAnswers(quizNum, num);
            num = refreshNum(usedID, num);
            // Saves question 3
            usedID.add(num);

            // Question 3
            System.out.println("3. " + quizes.get(quizNum).questions.get(num).toString());
            printAnswers(quizNum, num);
            num = refreshNum(usedID, num);
            // Saves question 4
            usedID.add(num);

            // Question 4
            System.out.println("4. " + quizes.get(quizNum).questions.get(num).toString());
            printAnswers(quizNum, num);
        }

        public void printInstructQuiz(int quizNum) {
            System.out.println("====================");
            System.out.println("INSTRUCTOR VERSION");
            System.out.println("====================");

            System.out.println(users.toString());

            System.out.println(quizes.get(quizNum).toString());

            // Generates first number
            int num = (int)(Math.random() * (4));

            // Adds to list of used numbers
            ArrayList<Integer> usedID = new ArrayList<Integer>();
            // Saves question 1
            usedID.add(num);

            // Question 1
            System.out.println("1. " + quizes.get(quizNum).questions.get(num).toString());
            printAnswer(quizNum, num);

            // Gives next new question
            num = refreshNum(usedID, num);
            // Saves question 2
            usedID.add(num);

            // Question 2
            System.out.println("2. " + quizes.get(quizNum).questions.get(num).toString());
            printAnswer(quizNum, num);
            num = refreshNum(usedID, num);
            // Saves question 3
            usedID.add(num);

            // Question 3
            System.out.println("3. " + quizes.get(quizNum).questions.get(num).toString());
            printAnswer(quizNum, num);
            num = refreshNum(usedID, num);
            // Saves question 4
            usedID.add(num);

            // Question 4
            System.out.println("4. " + quizes.get(quizNum).questions.get(num).toString());
            printAnswer(quizNum, num);
        }

        public void printAnswers(int quizNum, int num) {
            if (quizes.get(quizNum).questions.get(num).type == Type.tf) {
                System.out.println("True, False");
            } else
                System.out.println(quizes.get(quizNum).questions.get(num).answers.toString());
        }

        public void printAnswer(int quizNum, int num) {
            for (int i = 0; i < quizes.get(quizNum).questions.get(num).answers.size(); i++) {
                if (quizes.get(quizNum).questions.get(num).answers.get(i).isCorrect == true)
                    System.out.println(quizes.get(quizNum).questions.get(num).answers.get(i).toString());
            }
        }

        public int refreshNum(ArrayList<Integer> usedID, int num) {

            num = (int)(Math.random() * (4));
            while (usedID.contains(num)) {
                num = (int)(Math.random() * (4));
            }
            return num;
        }

        public void createQuizQuestions() {

            // QUIZ 1

            // Question 1 answers
            ArrayList<Answer> Q1Answers = new ArrayList<Answer>();
            Q1Answers.add(new Answer(true, "Bad luck"));
            Q1Answers.add(new Answer(false, "Good luck"));
            Q1Answers.add(new Answer(false, "A dinosaur"));
            Q1Answers.add(new Answer(false, "Bad"));
            Collections.shuffle(Q1Answers);
            // Question 1
            quiz1Questions.add(new Question(1, Type.select, "What is a bad omen?", Q1Answers));

            // Question 2 answers
            ArrayList<Answer> Q2Answers = new ArrayList<Answer>();
            Q2Answers.add(new Answer(true, "Geometry"));
            Q2Answers.add(new Answer(false, "Cheese"));
            Q2Answers.add(new Answer(false, "Pizza"));
            Q2Answers.add(new Answer(false, "Bad"));
            Collections.shuffle(Q2Answers);
            // Question 2
            quiz1Questions.add(new Question(2, Type.select, "Which of the following words are math-related?", Q2Answers));

            // Question 3 answer
            ArrayList<Answer> Q3Answers = new ArrayList<Answer>();
            Q3Answers.add(new Answer(true, "True"));
            // Question 3
            quiz1Questions.add(new Question(3, Type.tf, "Is cheddar a cheese?", Q3Answers));

            // Question 4 answer
            ArrayList<Answer> Q4Answers = new ArrayList<Answer>();
            Q4Answers.add(new Answer(true, "False"));
            // Question 4
            quiz1Questions.add(new Question(4, Type.tf, "Is a mayonnaise an instrument?", Q4Answers));

            quizes.add(new Quiz("Random", "This quiz designed to cover all bases and give an accurate assessment of your IQ", quiz1Questions));
            quizes.add(new Quiz("Random", "This quiz designed to cover all bases and give an accurate assessment of your IQ", quiz2Questions));

            // QUIZ 2

            // Question 1 Answers2
            ArrayList<Answer> Q1Answers2 = new ArrayList<Answer>();
            Q1Answers2.add(new Answer(true, "Olive Garden"));
            Q1Answers2.add(new Answer(false, "Attack On Titan!"));
            Q1Answers2.add(new Answer(false, "Instagram"));
            Q1Answers2.add(new Answer(false, "Eggroll"));
            Collections.shuffle(Q1Answers2);
            // Question 1
            quiz2Questions.add(new Question(1, Type.select, "Which of these is a restaurant?", Q1Answers2));

            // Question 2 Answers2
            ArrayList<Answer> Q2Answers2 = new ArrayList<Answer>();
            Q2Answers2.add(new Answer(true, "Obama"));
            Q2Answers2.add(new Answer(false, "I don't know"));
            Q2Answers2.add(new Answer(false, "Uh, Barack?"));
            Q2Answers2.add(new Answer(false, "Oh god, I don't know :("));
            Collections.shuffle(Q2Answers2);
            // Question 2
            quiz2Questions.add(new Question(2, Type.select, "What is Obama's last name?", Q2Answers2));

            // Question 3 answer
            ArrayList<Answer> Q3Answers2 = new ArrayList<Answer>();
            Q3Answers2.add(new Answer(true, "400ft"));
            Q3Answers2.add(new Answer(false, "6000ft"));
            Q3Answers2.add(new Answer(false, "The sky is the limit"));
            Q3Answers2.add(new Answer(false, "6.5ft"));
            Collections.shuffle(Q3Answers2);
            // Question 3
            quiz2Questions.add(new Question(2, Type.select, "What's the highest you can legally fly a drone?", Q3Answers2));

            // Question 4 answer
            ArrayList<Answer> Q4Answers2 = new ArrayList<Answer>();
            Q4Answers2.add(new Answer(true, "False"));
            // Question 4
            quiz2Questions.add(new Question(4, Type.tf, "John has 5 apples, David takes away 3 of these apples, does the moon stop existing during the daytime?", Q4Answers2));
        }

        class Question {
            int questionID;
            Type type;
            String questionText;
            ArrayList<Answer> answers;

            public Question(int questionID, Type type, String questionText, ArrayList<Answer> answers) {
                this.questionID = questionID;
                this.type = type;
                this.questionText = questionText;
                this.answers = answers;
            }

            public int getQuestionID() {
                return questionID;
            }

            public Type getType() {
                return type;
            }

            public String getQuestionText() {
                return questionText;
            }

            public ArrayList<Answer> getAnswers() {
                return answers;
            }

            @Override
            public String toString() {
                return questionText;
            }
        }

        class Answer {
            boolean isCorrect;
            String answerText;

            public Answer(boolean isCorrect, String answerText) {
                this.isCorrect = isCorrect;
                this.answerText = answerText;
            }

            public boolean isCorrect() {
                return isCorrect;
            }

            public String getAnswerText() {
                return answerText;
            }

            @Override
            public String toString() {
                return answerText;
            }
        }

        class Quiz {
            String topic;
            String summary;
            ArrayList<Question> questions;

            public Quiz(String topic, String summary, ArrayList<Question> questions) {
                this.topic = topic;
                this.summary = summary;
                this.questions = questions;
            }

            public String getTopic() {
                return topic;
            }

            public String getSummary() {
                return summary;
            }

            public ArrayList<Question> getQuestions() {
                return questions;
            }

            @Override
            public String toString() {
                return "Quiz Topic: " + topic +
                        "\n" + summary;
            }
        }

        class User {
            String firstName;
            String email;
            boolean isHost;

            public User(String firstName, String email, boolean isHost) {
                this.firstName = firstName;
                this.email = email;
                this.isHost = isHost;
            }

            public String getFirstName() {
                return firstName;
            }

            public String getEmail() {
                return email;
            }

            public boolean isHost() {
                return isHost;
            }

            @Override
            public String toString() {
                return "User:" +
                        " Name: " + firstName + ',' +
                        " Email: " + email + ',' +
                        " Host: " + isHost;
            }

            public void printUsers() {
                for (User output: users) {
                    System.out.println(output);
                }
            }
        }

    }
}
