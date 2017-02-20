package contacts;

import java.io.IOException;
import java.util.List;

public interface ContactBook {
    /**
     * Сохранение списка контактов в файл
     *
     * @param fileName Имя файла для сохранения
     */
    void save(String fileName) throws IOException;

    /**
     * Загрузка контактов из файла
     * Список контактов из файла добавляется в список
     *
     * @param fileName Имя файла для загрузки контактов
     */
    void load(String fileName) throws IOException, ClassNotFoundException;

    /**
     * Поиск всех контаков начинающихся на заданную строку start
     * Используется для автодополнения
     *
     * @param start Начало имени или телефона
     * @return Список подходящих контактов
     */
    List<Contact> search(String start);

    /**
     * Добавить новый контакт
     *
     * @param contact добавляемый контакт
     */
    void add(Contact contact);

    /**
     * @return количество контактов
     */
    int size();
}