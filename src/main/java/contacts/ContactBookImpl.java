package contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactBookImpl implements ContactBook {
    List<Contact> contacts = new ArrayList<>();

    /**
     * Сохранение списка контактов в файл
     *
     * @param fileName Имя файла для сохранения
     */
    @Override
    public void save(String fileName) throws IOException {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(fileName)
                             ))) {
            out.writeObject(contacts);
        }
    }

    /**
     * Загрузка контактов из файла
     *
     * @param fileName Имя файла для загрузки контактов
     */
    @Override
    public void load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(fileName)
                             ))) {
            List<Contact> list = (List<Contact>) in.readObject();
            contacts.addAll(list);
        }
    }

    /**
     * Поиск всех контаков начинающихся на заданную строку start
     * Используется для автодополнения
     *
     * @param start Начало имени или телефона
     * @return Список подходящих контактов
     */
    @Override
    public List<Contact> search(String start) {
        List<Contact> found = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().startsWith(start))
                found.add(contact);
            else {
                for (String phone : contact.getPhones()) {
                    if (phone.startsWith(start)) {
                        found.add(contact);
                        break;
                    }
                }
            }
        }
        return found;
    }

    /**
     * Добавить новый контакт
     *
     * @param contact добавляемый контакт
     */
    @Override
    public void add(Contact contact) {
        contacts.add(contact);
    }

    /**
     * @return количество контактов
     */
    @Override
    public int size() {
        return contacts.size();
    }
}
