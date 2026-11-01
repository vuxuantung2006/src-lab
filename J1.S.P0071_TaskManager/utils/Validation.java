package utils;

import constant.Message;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

    private Validation() {
    }

    public static int getInt(String input, int min, int max) throws Exception {
        try {
            int check = Integer.parseInt(input);
            if (check >= min && check <= max) {
                return check;
            } else {
                throw new Exception(String.format(Message.INTERGER_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e) {
            throw new Exception(Message.ERROR_INVALID_GENERAL);
        }
    }

    public static String getString(String input, final String REGEX) throws Exception {
        if (input.matches(REGEX)) {
            return input;
        }
        throw new Exception(Message.ERROR_INVALID_GENERAL);
    }

    public static Date getDate(String input, final String REGEX) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(REGEX);
        dateFormat.setLenient(false);
        try {
            if (input.isEmpty()) {
                return null;
            }
            return dateFormat.parse(input);
        } catch (ParseException e) {
            throw new Exception(Message.ERROR_INVALID_DATE_FORMAT);
        }
    }

    public static double getDouble(String input, double min, double max) throws Exception {
        try {
            double check = Double.parseDouble(input);
            if (check >= min && check <= max) {
                if (check * 10 % 5 == 0) {
                    return check;
                }
                throw new Exception("Must be x.0 or x.5");
            } else {
                throw new Exception(String.format(Message.REAL_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e) {
            throw new Exception(Message.ERROR_INVALID_GENERAL);
        }
    }
}