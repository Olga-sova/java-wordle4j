package ru.yandex.practicum;

import java.util.Scanner;

/*
в этом классе хранится словарь и состояние игры
    текущий шаг
    всё что пользователь вводил
    правильный ответ

в этом классе нужны методы, которые
    проанализируют совпадение слова с ответом
    предложат слово-подсказку с учётом всего, что вводил пользователь ранее

не забудьте про специальные типы исключений для игровых и неигровых ошибок
 */
public class WordleGame {

    private String answer;

    private int steps;

    private WordleDictionary dictionary;

    public WordleGame(WordleDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void startGame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Игра началась!");
        answer = dictionary.getRandomWord();
        steps = 6;
        new StringBuilder("-".repeat(answer.length()))
        StringBuilder feedback = new StringBuilder();
        while (steps > 0) {

            System.out.println("Введите слово:");
            String playerWord = scanner.nextLine();

            try {
                if (playerWord.length() != answer.length()) {
                    throw new IllegalArgumentException("Длина введённого слова не соответствует длине секретного слова.");
                }

                if (!dictionary.containsWord(playerWord)) {
                    throw new IllegalArgumentException("Введённое слово не найдено в словаре.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (playerWord.equals(answer)) {
                System.out.println("Вы угадали слово!");
                break;
            } else {
                steps--;
                System.out.println("Неправильно. Осталось попыток: " + steps);
                for (int i = 0; i < answer.length(); i++) {
                    char playerChar = playerWord.charAt(i);
                    char secretChar = answer.charAt(i);

                    if (playerChar == secretChar) {
                        feedback.append(playerChar);
                    } else if (answer.contains(String.valueOf(playerChar))) {
                        feedback.append("(").append(Character.toLowerCase(playerChar)).append(")");
                    } else {
                        feedback.append("-");
                    }
                }
                System.out.println("Ваш ответ: " + feedback);
            }
        }

        if (steps == 0) {
            System.out.println("Вы проиграли. Правильное слово было: " + answer);
        }
    }
}


