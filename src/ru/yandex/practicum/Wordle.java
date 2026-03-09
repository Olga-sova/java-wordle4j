package ru.yandex.practicum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/*
в главном классе нам нужно:
    создать лог-файл (он должен передаваться во все классы)
    создать загрузчик словарей WordleDictionaryLoader
    загрузить словарь WordleDictionary с помощью класса WordleDictionaryLoader
    затем создать игру WordleGame и передать ей словарь
    вызвать игровой метод в котором в цикле опрашивать пользователя и передавать информацию в игру
    вывести состояние игры и конечный результат
 */
public class Wordle {
    private static final Logger logger = LoggerFactory.getLogger(Wordle.class);

    public static void main(String[] args) {
        logger.info("Начата загрузка словаря");
        WordleDictionaryLoader loader = new WordleDictionaryLoader();
        WordleDictionary dictionary = null;
        try {
            dictionary = loader.loadDictionary("words_ru.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("Словарь загружен успешно");

        WordleGame game = new WordleGame(dictionary);
        game.startGame();
    }
}
