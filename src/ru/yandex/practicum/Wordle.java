package ru.yandex.practicum;

import java.util.Scanner;
import java.io.IOException;

public class Wordle {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
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
        String input = scanner.nextLine();
        game.startGame(input);
    }
}

