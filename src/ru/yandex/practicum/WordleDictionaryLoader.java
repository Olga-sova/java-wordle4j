package ru.yandex.practicum;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/*
этот класс содержит в себе всю рутину по работе с файлами словарей и с кодировками
    ему нужны методы по загрузке списка слов из файла по имени файла
    на выходе должен быть класс WordleDictionary
 */
public class WordleDictionaryLoader {
    public WordleDictionary loadDictionary(String filePath) throws IOException {
        WordleDictionary dictionary = new WordleDictionary();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                dictionary.addWord(word);
            }
        }
        return dictionary;
    }
}
