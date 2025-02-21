package nguyennhuminhduc_3424;

import java.util.Date;
import java.util.Scanner;

public class TextBook extends Book {

    private String status;

    public TextBook(String bookId, String publisher, Date entryDate, double unitPrice, double quantity, String status) {
        super(bookId, publisher, entryDate, unitPrice, quantity);
        this.status = status;

    }

    public TextBook() {
        super("", "", new Date(), 0.0, 0.0);
        this.status = "";

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void addBook() {
        Scanner kb = new Scanner(System.in);
        super.addBook();
        System.out.println("Enter status: ");
        setStatus(kb.nextLine());
        System.out.println("Da them thanh cong sach voi id: " + getBookId());
    }

    @Override
    public void updateBook(String Id) {
        if (getBookId().equals(Id)) {
            Scanner kb = new Scanner(System.in);
            super.updateBook(Id);
            System.out.println("Enter status: ");
            setStatus(kb.nextLine());
            System.out.println("Cap nhat thanh cong " + Id);

        }
        System.out.println("TextBook khong trung voi " + Id);
    }

    @Override
    public void displayBook() {
        super.displayBook();
        System.out.println("TextBook Id:" + getStatus());
    }
}
