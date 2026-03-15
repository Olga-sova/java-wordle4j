package ru.yandex.practicum;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

import static java.lang.System.err;

/*
этот класс содержит в себе всю рутину по работе с файлами словарей и с кодировками
    ему нужны методы по загрузке списка слов из файла по имени файла
    на выходе должен быть класс WordleDictionary
 */
public class WordleDictionaryLoader {
    public WordleDictionary loadDictionary(String filePath) throws IOException {
        WordleDictionary dictionary = new WordleDictionary();
        try {
            File file = new File(filePath);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String word = scanner.nextLine();
                    dictionary.addWord(word);
                }
            }
        } catch (IOException e) {
            err.printf("Ошибка чтения файла: %s%n", e.getMessage());
        }
        return dictionary;
    }
}
