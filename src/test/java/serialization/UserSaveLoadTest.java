package serialization;

import org.junit.Test;

/**
 * Создадим набор своих классов, поместим их в список
 * Сохраним в файл
 * Загрузим из файла обратно
 * Сравним с исходным списком
 */
public class UserSaveLoadTest {
    @Test
    public void testSaveLoadList() {
        // TODO: завершить пример
    }

    static class User {
        static int count = 0;
        String login;
        String password;
    }
}
