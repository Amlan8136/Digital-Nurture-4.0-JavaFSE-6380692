public class DocumentFactoryMain {

    public interface Document {
        void open();
    }

    public static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening Word document.");
        }
    }

    public static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening PDF document.");
        }
    }

    public static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Opening Excel document.");
        }
    }

    public static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    public static class WordDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    public static class PdfDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    public static class ExcelDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }
}
