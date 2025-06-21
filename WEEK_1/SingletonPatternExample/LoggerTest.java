public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Cognizant is a good company.");

        Logger logger2 = Logger.getInstance();
        logger2.log("I want to give my best for this opportunity.");

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances detected!");
        }
    }
}
