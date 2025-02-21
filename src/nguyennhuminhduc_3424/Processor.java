package nguyennhuminhduc_3424;

import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        BookList bookList = new BookList();
        while (true) {
            System.out.println("1. Add new book");
            System.out.println("2. Update new book");
            System.out.println("3. Delete book by ID");
            System.out.println("4. Find book by ID");
            System.out.println("5. Display all book");
            System.out.println("6. Exit");
            System.out.println("Choose a option: ");
            int choice = kb.nextInt();
            kb.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Choose book type: ");
                    System.out.println("1. TextBook");
                    System.out.println("2. ReferenceBook");
                    int bookType = kb.nextInt();
                    kb.nextLine();

                    if (bookType == 1) {
                        TextBook textBook = new TextBook();
                        bookList.addBook(textBook);
                    } else if (bookType == 2) {
                        ReferenceBook referenceBook = new ReferenceBook();
                        bookList.addBook(referenceBook);
                    } else {
                        System.out.println("Lua chon khong dung");
                    }
                    break;
                case 2:
                    System.out.println("Enter id sach de update: ");
                    String updateId = kb.nextLine();
                    bookList.updateBook(updateId);
                    break;
                case 3:
                    System.out.println("Enter id book to delete: ");
                    String deleteId = kb.nextLine();
                    bookList.deleteBookById(deleteId);
                    break;
                case 4:
                    System.out.println("Enter id book to find: ");
                    String findId = kb.nextLine();
                    Book findBook = bookList.findBookById(findId);
                    if (findBook != null) {
                        findBook.displayBook();
                    }
                    break;
                case 5:
                    bookList.displayAllBook();
                    break;
                case 6:
                    System.out.println("Exit...");
                    kb.close();
                    return;
                default:
                    System.out.println("Khong co lua chon dung");
            }
        }
    }
}
