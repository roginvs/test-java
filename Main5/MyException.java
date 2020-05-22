// Lol, sonarlint complains:
//   Remove the declaration of thrown exception
//   'java.lang.NullPointerException' which is a runtime exception
// So, that's why I created this custom class
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}