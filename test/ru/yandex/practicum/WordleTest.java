package ru.yandex.practicum;

import static org.junit.jupiter.api.Assertions.*;

class WordleTest {
    @org.junit.jupiter.api.Test
    void testStartGame() {

        WordleDictionary dictionary = new WordleDictionary();
        dictionary.addWord("apple");
        dictionary.addWord("banana");

        WordleGame game = new WordleGame(dictionary);
        assertTrue(dictionary.containsWord("apple"));
        game.startGame("пример_слова");
        assertEquals(WordleGame.MAX_ATTEMPTS, game.getSteps());
    }
}
