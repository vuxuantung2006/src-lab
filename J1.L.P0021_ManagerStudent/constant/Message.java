/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 *
 * @author KATANA15
 */
public final class Message {

    private Message() {
    }

    public static final String MENU_HEADER = "========= STUDENT MANAGER =========\n";
    public static final String MENU_BODY
            = "1. Create\n"
            + "2. Find and Sort\n"
            + "3. Update/Delete\n"
            + "4. Report\n"
            + "5. Exit";
    public static final String INPUT_CHOICE = "Your choice: ";
    public static final String INPUT_ID = "Enter id: ";
    public static final String INPUT_NAME = "Student Name: ";
    public static final String INPUT_SEMESTER = "Enter Semester: ";
    public static final String INPUT_COURSE_CHOICE = "Only three courses:\n"
            + "1.JAVA\n"
            + "2.DOT NET\n"
            + "3.C/C++\n"
            + "Enter your choice: ";
    public static final String INPUT_YN = "Do you want to continue (Y/N)?";
    public static final String INPUT_UD = "(U) Update or (D) Delete?";
    public static final String EDIT_SEMESTER = "Enter new Semester: ";
    public static final String ERROR_INVALID_GENERAL = "Invalid!";
    public static final String REAL_NUMBER_RANGE_ERROR = "Please input number in a range %.1f -> %.1f";
    public static final String INTERGER_NUMBER_RANGE_ERROR = "Please input number in a range %d -> %d";
    public static final String ERROR_INVALID_REAL_NUMBER = "Please enter real number!";
    public static final String ERROR_CANNOT_ADD = "Can not add!!!";
    public static final String ERROR_CANNOT_DELETE = "Can not delete!!!";
    public static final String ERROR_CANNOT_UPDATE = "Can not update!!!";
    public static final String ERROR_CANNOT_FOUND = "Record student does not exist!";
    public static final String ERROR_DUPLICATE = "This record is existed!";
    public static final String ERROR_EMPTY = "List is empty!";
    public static final String EDIT_STUDENT = "Select record number (No.) to modify: ";
    public static final String SUCCESS_ADD_MESSAGE = "Add success!";
    public static final String SUCCESS_UPDATE_MESSAGE = "Update success!";
    public static final String SUCCESS_DELETE_MESSAGE = "Delete success!";
    public static final String ERROR_DUPLICATE_ID = "Error: This ID already belongs to student ";
}
