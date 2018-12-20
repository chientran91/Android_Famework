package core.chiennd.utility;

public class Constants {
    public interface Validate {
        char[] NAME = new char[] {
                '*', '<', '>', '[', ']', '\\', '\"', '“'
        };
        String BLOCK_CHARACTER_SET = ",-(*#  ";
        int MAX_LENGTH_NUMBER_MOBILE = 15;
        int MIN_LENGTH_PASSWORD = 8 ;
        int MIN_CLICK_INTERVAL = 1000;
    }
}
