package nguyennhuminhduc_3424;

import java.util.ArrayList;

public class BookList {

    private ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        book.addBook();
        bookList.add(book);
        System.out.println("Da them sach trung id:" + book.getBookId());

    }

    public void updateBook(String Id) {
        for (Book book : bookList) {
            if (book.getBookId().equals(Id)) {
                book.updateBook(Id);
                System.out.println("Cap nhat sach voi id:" + Id);
                return;
            }
        }
        System.out.println("Khong tim thay sach trung voi id");
    }

//DELETE SE DUNG LENH MOI
//BOOLEAN REMOVED = BOOKLIST.REMOVELF(BOOK -> BOOK.GETBOOKID().EQUALS(ID));
    public void deleteBookById(String Id) {
        for (Book book : bookList) {
            bookList.remove(book);
            System.out.println("Xoa id: " + Id);
        }
        System.out.println("Id khong co " + Id);
    }

    public Book findBookById(String Id) {
        for (Book book : bookList) {
            if (book.getBookId().equals(Id)) {
                return book;
            }

        }
        System.out.println("Id khong co " + Id);
        return null;
    }

    public void displayAllBook() {
        if (bookList.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Book book : bookList) {
                book.displayBook();
            }
        }
    }
}
