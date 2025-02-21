package nguyennhuminhduc_3424;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public abstract class Book implements IBook {

    private String bookId;
    private String publisher;
    private Date entryDate;
    private double unitPrice;
    private double quantity;

    public Book(String bookId, String publisher, Date entryDate, double unitPrice, double quantity) {
        this.bookId = bookId;
        this.publisher = publisher;
        this.entryDate = entryDate;
        this.unitPrice = unitPrice;
        this.quantity = quantity;

    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public void addBook() {
        try {
            Scanner kb = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Enter book id: ");
            setBookId(kb.nextLine());
            System.out.println("Enter publisher: ");
            setPublisher(kb.nextLine());
            System.out.println("Enter entry date: ");
            String entryDateS = kb.nextLine();
            setEntryDate(sdf.parse(entryDateS));
            System.out.println("Enter price: ");
            setUnitPrice(kb.nextDouble());
            System.out.println("Enter quantity: ");
            setQuantity(kb.nextDouble());

        } catch (ParseException e) {
            System.out.println(e);
        }
    }

    public void updateBook(String Id) {
        if (this.bookId.equals(Id)) {
            try {

                Scanner kb = new Scanner(System.in);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Enter publisher: ");
                setPublisher(kb.nextLine());
                System.out.println("Enter entry date: ");
                String entryDateS = kb.nextLine();
                setEntryDate(sdf.parse(entryDateS));
                System.out.println("Enter price: ");
                setUnitPrice(kb.nextDouble());
                System.out.println("Enter quantity: ");
                setQuantity(kb.nextDouble());

            } catch (ParseException e) {
                System.out.println(e);
            }
        }
    }

    public void displayBook() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Id: " + getBookId() + ", Publisher: " + getPublisher() + ", Unit Price: " + getUnitPrice() + ", Quantity: " + getQuantity() + ", Date: " + sdf.format(entryDate));

    }
}
