/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 *
 * @author KATANA15
 */
public class Message {

    public static final String MENU_HEADER = "========= MATRIX CALCULATOR =========\n";
    public static final String MENU_BODY
            = "1. Addition Matrix\n"
            + "2. Subtraction Matrix\n"
            + "3. Multiplication Matrix\n"
            + "4. Quit";
    // Prompts
    public static final String PROMPT_CHOICE = "Enter your choice: ";
    public static final String PROMPT_ROW = "Enter Row Matrix %d: ";
    public static final String PROMPT_COL = "Enter Column Matrix %d: ";
    public static final String PROMPT_ELEMENTS = "Enter elements for Matrix %d:";
    public static final String PROMPT_MATRIX_CELL = "Matrix%d[%d][%d]: ";

    // Errors
    public static final String ERROR_INVALID_GENERAL = "Invalid!";
    public static final String REAL_NUMBER_RANGE_ERROR = "Please input number in a range %.1f -> %.1f";
    public static final String INTERGER_NUMBER_RANGE_ERROR = "Please input number in a range %d -> %d";

    // Cac thong bao loi kiem tra dieu kien ma tran
    public static final String ERR_INVALID_DIMENSION = "Row and column must be greater than 0.";
    public static final String ERR_NULL_DATA = "Data array cannot be null or empty.";
    public static final String ERR_INVALID_SIZE_ADD_SUB = "Rows and columns of the two matrices must be identical.";
    public static final String ERR_INVALID_SIZE_MULT = "Columns of matrix 1 must be equal to rows of matrix 2.";

}
