import java.util.Scanner;

public class FactoryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of document to open (word/pdf/excel): ");
        String input = scanner.nextLine().trim().toLowerCase();

        DocumentFactoryMain.DocumentFactory factory = null;

        switch (input) {
            case "word":
                factory = new DocumentFactoryMain.WordDocumentFactory();
                break;
            case "pdf":
                factory = new DocumentFactoryMain.PdfDocumentFactory();
                break;
            case "excel":
                factory = new DocumentFactoryMain.ExcelDocumentFactory();
                break;
            default:
                System.out.println("Invalid document type entered.");
                System.exit(0);
        }

        DocumentFactoryMain.Document document = factory.createDocument();
        document.open();

        scanner.close();
    }
}
