package ru.yandex.practicum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

/*
этот класс содержит в себе всю рутину по работе с файлами словарей и с кодировками
    ему нужны методы по загрузке списка слов из файла по имени файла
    на выходе должен быть класс WordleDictionary
 */
public class WordleDictionaryLoader {
    public WordleDictionary loadDictionary(String filePath) throws IOException {
        WordleDictionary dictionary = new WordleDictionary();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)
        )) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim();  // убираем лишние пробелы и переносы строк
                dictionary.addWord(word);
            }
            return dictionary;
        }
    }
}
