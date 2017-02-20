package contacts;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContactBookTest {

    @Test
    public void testSaveLoad() throws Exception {
        // Impl - implementation
        ContactBook book = new ContactBookImpl();
        assertEquals(0, book.size());
        book.add(new Contact("Пётр", "+79112345678"));
        assertEquals(1, book.size());

        book.save("book.dat");

        ContactBook bookCopy = new ContactBookImpl();
        bookCopy.load("book.dat");
        assertEquals(1, bookCopy.size());

        // TODO: удалять book.dat после окончания тестов
    }

    @Test
    public void testSearch() throws Exception {
        ContactBook book = new ContactBookImpl();
        book.add(new Contact("Иван", "+79112345689"));
        book.add(new Contact("Пётр", "+79112345789"));

        List<Contact> find1 =
                book.search("Нет такого");
        assertEquals(0, find1.size());
    }
}
