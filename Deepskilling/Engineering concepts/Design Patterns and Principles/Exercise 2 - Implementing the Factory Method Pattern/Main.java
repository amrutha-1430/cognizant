// 1. PRODUCT INTERFACE
interface Document {
    void open();
}

// 2. CONCRETE PRODUCTS
class WordDocument implements Document {
    public void open() { System.out.println("Opening Word Document (.docx)..."); }
}

class PdfDocument implements Document {
    public void open() { System.out.println("Opening PDF Document (.pdf)..."); }
}

class ExcelDocument implements Document {
    public void open() { System.out.println("Opening Excel Spreadsheet (.xlsx)..."); }
}

// 3. ABSTRACT CREATOR (FACTORY)
abstract class DocumentFactory {
    public abstract Document createDocument();
    
    // Helper to test creation and operation together
    public void debugOpen() {
        Document doc = createDocument();
        doc.open();
    }
}

// 4. CONCRETE CREATORS
class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new WordDocument(); }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new PdfDocument(); }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new ExcelDocument(); }
}

// 5. TEST CLASS
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern ===");

        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.debugOpen();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.debugOpen();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.debugOpen();
    }
}
