package utilities;

import java.time.LocalDateTime;

public class TimeStamp {

    public static String currentTimeStamp() {

        LocalDateTime now = LocalDateTime.now();

        String str = now.toString().replace("-", "").replace(":", "").replace(".", "");

        str = str.substring(0, (str.length() - 2));

        return str;


    }

}
