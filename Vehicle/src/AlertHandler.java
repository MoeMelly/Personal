public class AlertHandler {

    public String handleAlert(DiagnosticAlert alert) {
        switch (alert.getLevel()) {
            case NORMAL -> {
               return ("LOG: " + alert.getMessage());
            }
            case MINOR -> {
                return ("DASHBOARD WARNING: " + alert.getMessage());
            }
            case MAJOR -> {
                return ("FLASHING ALERT: " + alert.getMessage() + " " + "Action Needed Soon!");
            }
            case SEVERE -> {
                return ("!!! SEVERE ALERT !!!: " + alert.getMessage() + " " + "SERVICE IMMEDIATELY!");
            }
            case CRITICAL -> {
                return (alert.getMessage() + " " + "!!! ENGINE SERVICE IMMEDIATELY !!!");
            }
            default -> throw new IllegalStateException("Unexpected value: " + alert.getLevel());
        }
    }
}
