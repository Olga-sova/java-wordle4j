package ru.yandex.practicum;

import java.io.IOException;
import java.util.Scanner;

public class Wordle {
    public static void main() {
        System.out.println("Начата загрузка словаря");
        WordleDictionaryLoader loader = new WordleDictionaryLoader();
        WordleDictionary dictionary;
        try {
            dictionary = loader.loadDictionary("words_ru.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Словарь загружен успешно");

        WordleGame game = new WordleGame(dictionary);
        game.startGame();
    }
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

}

