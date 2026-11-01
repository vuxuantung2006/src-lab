package utils;

import constant.Message;

public final class Validation {

    private Validation() {
    }

    public static double getDouble(String input, double min, double max) throws Exception {
        try {
            double check = Double.parseDouble(input);
            //kiem tra so co nam trong khoang gia tri khong
            if (check >= min && check <= max) {
                return check;
            } else {
                //in ra thong bao loi
                throw new Exception(String.format(Message.REAL_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e) {
            //in ra thong bao loi
            throw new Exception(Message.ERROR_INVALID_GENERAL);
        }
    }

    public static int getInt(String input, int min, int max) throws Exception {
        try {
            int check = Integer.parseInt(input);
            //kiem tra so co nam trong khoang gia tri khong
            if (check >= min && check <= max) {
                return check;
            } else {
                //in ra thong bao loi
                throw new Exception(String.format(Message.INTERGER_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e) {
            //in ra thong bao loi
            throw new Exception(Message.ERROR_INVALID_GENERAL);
        }
    }

    public static String getString(String input, final String REGEX) throws Exception {
        if (input.matches(REGEX)) {
            return input;
        }
        throw new Exception(Message.ERROR_INVALID_GENERAL);
    }
}
