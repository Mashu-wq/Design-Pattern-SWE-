import java.util.Stack;

class DocumentMemento {
    private String content;
    private String fontName;
    private int fontSize;

    public DocumentMemento(String content, String fontName, int fontSize) {
        this.content = content;
        this.fontName = fontName;
        this.fontSize = fontSize;
    }

    public String getContent() {
        return content;
    }

    public String getFontName() {
        return fontName;
    }

    public int getFontSize() {
        return fontSize;
    }
}

// Originator class to create and restore the state of the Document
class Document {
    private String content;
    private String fontName;
    private int fontSize;
    private Stack<DocumentMemento> history = new Stack<>();

    public Document(String content, String fontName, int fontSize) {
        this.content = content;
        this.fontName = fontName;
        this.fontSize = fontSize;
        save();
    }

    public void setContent(String content) {
        this.content = content;
        save();
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
        save();
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
        save();
    }

    public void undo() {
        if (!history.isEmpty()) {
            DocumentMemento memento = history.pop();
            this.content = memento.getContent();
            this.fontName = memento.getFontName();
            this.fontSize = memento.getFontSize();
        }
    }

    private void save() {
        history.push(new DocumentMemento(content, fontName, fontSize));
    }

    @Override
    public String toString() {
        return "Document{" +
                "content='" + content + '\'' +
                ", fontName='" + fontName + '\'' +
                ", fontSize=" + fontSize +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Document document = new Document("Initial content", "Arial", 12);
        System.out.println(document);

        document.setContent("Updated content");
        document.setFontName("Times New Roman");
        document.setFontSize(14);
        System.out.println(document);

        document.undo(); // Undo the last change
        System.out.println(document);
    }
}

