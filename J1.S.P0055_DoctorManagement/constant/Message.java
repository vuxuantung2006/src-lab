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

    public static final String MENU_HEADER = "========= Doctor Management Program =========\n";
    public static final String MENU_BODY
            = "1. Add Doctor\n"
            + "2. Update Doctor\n"
            + "3. Delete Doctor\n"
            + "4. Search Doctor\n"
            + "5. Display All Doctors\n"
            + "6. Exit";

    public static final String INPUT_CHOICE = "Your choice: ";
    public static final String INPUT_DOCTOR_CODE = "Enter Code(Ex: DOC 1): ";
    public static final String INPUT_NAME = "Enter Name: ";
    public static final String INPUT_SPECIALIZATION = "Enter Specialization: ";
    public static final String INPUT_AVAILABILITY = "Enter Availability: ";
    public static final String INPUT_KEY = "Enter search term: ";
    public static final String ERROR_INVALID_GENERAL = "Invalid!";
    public static final String REAL_NUMBER_RANGE_ERROR = "Please input number in a range %.1f -> %.1f";
    public static final String INTERGER_NUMBER_RANGE_ERROR = "Please input number in a range %d -> %d";

    public static final String ERROR_CANNOT_ADD = "Can not add!!!";
    public static final String ERROR_DUPLICATE = "Doctor code is duplicate.";
    public static final String ERROR_CANNOT_DELETE = "Can not delete!!!";
    public static final String ERROR_CANNOT_FOUND = "Doctor does not exist!";
    public static final String ERROR_EMPTY = "List is empty!";
    public static final String ERROR_MATCH = "No matching doctors found.";
    public static final String SUCCESS_ADD_MESSAGE = "Add success!";
    public static final String SUCCESS_DELETE_MESSAGE = "Delete success!";
    public static final String SUCCESS_UPDATE_MESSAGE = "Update success!";

    public static final String REGEX_CODE = "DOC\\s\\d+";
    public static final String REGEX_NAME = "[A-Za-z0-9\\s]+";
    public static final String DATE_FORMAT_PATTERN = "dd-MM-yyyy"; // Chuỗi định dạng ngày tháng
    public static final String TIME_FORMAT_PATTERN = "%.1f"; // Chuỗi định dạng thời gian
}
