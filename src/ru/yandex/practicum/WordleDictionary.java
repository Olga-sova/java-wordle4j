package ru.yandex.practicum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
этот класс содержит в себе список слов List<String>
    его методы похожи на методы списка, но учитывают особенности игры
    также этот класс может содержать рутинные функции по сравнению слов, букв и т.д.
 */
public class WordleDictionary {
    private static final int WORD_LENGTH = 5;
    private final List<String> words = new ArrayList<>();

    public void addWord(String word) {
        words.add(word);
    }

    public String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(words.size());
        String word = words.get(index);
        while (word.length() != WORD_LENGTH) {
            index = random.nextInt(words.size());
            word = words.get(index);
        }
        return word;
    }

    public boolean containsWord(String word) {
        return words.contains(word);
    }
}

