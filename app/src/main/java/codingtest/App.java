package codingtest;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

class Answer {
    private int answer;
    private int score;

    public Answer(int answer, int score) {
        this.answer = answer;
        this.score = score;
    }

    public int getAnswer() {
        return answer;
    }

    public int getScore() {
        return score;
    }
}

public class App {

    public static void main(String[] args) {
        List<Answer> answers1 = new ArrayList<>();
        answers1.add(new Answer(2, 3));
        answers1.add(new Answer(3, 4));
        answers1.add(new Answer(3, 5));

        System.out.println(getHighScore(answers1));

        List<Answer> answers2 = new ArrayList<>();
        answers2.add(new Answer(1, 5));
        answers2.add(new Answer(5, 5));
        answers2.add(new Answer(2, 4));

        System.out.println(getHighScore(answers2));

        List<Answer> answers3 = new ArrayList<>();
        answers3.add(new Answer(1, 3));
        answers3.add(new Answer(3, 3));
        answers3.add(new Answer(5, 3));

        System.out.println(getHighScore(answers3));
    }

    public static String getHighScore(List<Answer> answers) {
        int[] scores = new int[3];
        int[] answerPatterns = { 1, 3, 5 };

        // 점수 계산
        for (Answer answer : answers) {
            int ans = answer.getAnswer();
            int score = answer.getScore();

            for (int i = 0; i < answerPatterns.length; i++) {
                if (ans == answerPatterns[i]) {
                    scores[i] += score;
                }
            }
        }

        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        List<String> highScores = new ArrayList<>();
        if (scores[0] == maxScore) {
            highScores.add("a");
        }
        if (scores[1] == maxScore) {
            highScores.add("b");
        }
        if (scores[2] == maxScore) {
            highScores.add("c");
        }

        StringJoiner result = new StringJoiner(", ");
        for (String highScore : highScores) {
            result.add(highScore + " : " + maxScore);
        }

        return result.toString();
    }
}
