package nguyennhuminhduc_3424;

import java.util.Date;
import java.util.Scanner;

public class ReferenceBook extends Book {

    private double tax;

    public ReferenceBook(String bookId, String publisher, Date entryDate, double unitPrice, double quantity, double tax) {
        super(bookId, publisher, entryDate, unitPrice, quantity);
        this.tax = tax;
    }

    public ReferenceBook() {
        super("", "", new Date(), 0.0, 0.0);
        this.tax = 0.0;

    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public void addBook() {
        Scanner kb = new Scanner(System.in);
        super.addBook();
        System.out.println("Enter tax: ");
        setTax(kb.nextDouble());
        System.out.println("Da them sach voi id: " + getBookId());
    }

    @Override
    public void updateBook(String Id) {
        if (getBookId().equals(Id)) {
            Scanner kb = new Scanner(System.in);
            super.updateBook(Id);
            System.out.println("Enter tax: ");
            setTax(kb.nextDouble());
            System.out.println("Cap nhat sach TextBook:" + Id);
        } else {
            System.out.println("Khong co id trung khop" + Id);
        }
    }

    @Override
    public void displayBook() {
        super.displayBook();
        System.out.println("TextBook Id:" + getBookId());
    }

}
