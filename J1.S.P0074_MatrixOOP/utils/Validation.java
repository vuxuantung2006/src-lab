package utils;

import constant.Message;
import model.Matrix;

public class Validation {

    private Validation() {
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

    public static boolean isValidAdd(Matrix m1, Matrix m2) {
        return m1.getRows() != m2.getRows() || m1.getCols() != m2.getCols();
    }

    public static boolean isValidMul(Matrix m1, Matrix m2) {
        return m1.getCols() != m2.getRows();
    }
}
