import static java.io.File.separator;

public class DiagnosticAlert {
    private final String message;
    Severity level;


    public DiagnosticAlert(String message, Severity level) {
        this.message = message;
        this.level = level;
    }


    public Severity getLevel() {
        return level;
    }


    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return separator + System.lineSeparator() +
                message + System.lineSeparator() +
                level + System.lineSeparator() +
                separator;
    }
}


