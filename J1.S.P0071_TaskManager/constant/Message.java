/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

public class Message {

    private Message() {
    }

    public static final String MENU_HEADER = "========= Task program =========\n";
    public static final String MENU_BODY
            = "1. Add task\n"
            + "2. Delete tasks\n"
            + "3. Display task\n"
            + "4. Quit";
    public static final String INPUT_CHOICE = "Your choice: ";
    public static final String INPUT_TASK_ID = "Task ID: ";
    public static final String INPUT_REQUIREMENT_NAME = "Requirement Name: ";
    public static final String INPUT_TASK_TYPE_CHOICE = "Please enter 1->4\n"
            + "ID  Name\n"
            + "1.Code\n"
            + "2.Test\n"
            + "3.Design\n"
            + "4.Review \n"
            + "Enter your choice: ";
    public static final String INPUT_DATE = "Date: ";
    public static final String INPUT_PLAN_FROM = "From:";
    public static final String INPUT_PLAN_TO = "To:";
    public static final String INPUT_ASSIGNEE = "Assignee: ";
    public static final String INPUT_REVIEWER = "Reviewer: ";

    public static final String ERROR_INVALID_GENERAL = "Invalid!";
    public static final String REAL_NUMBER_RANGE_ERROR = "Please input number in a range %.1f -> %.1f";
    public static final String INTERGER_NUMBER_RANGE_ERROR = "Please input number in a range %d -> %d";
    public static final String ERROR_INVALID_DATE_FORMAT = "Invalid! Format dd-mm-yyyy";
    public static final String ERROR_PLAN_TO_RANGE_MAX = "Just be large than plan From and less than 17.5";
    public static final String ERROR_INVALID_REAL_NUMBER = "Please enter real number!";
    
    public static final String ERROR_CANNOT_ADD = "Can not add!!!";
    public static final String ERROR_INVALID_TASK_TYPE_ID = "Invalid Task Type ID.";
    public static final String ERROR_CANNOT_DELETE = "Can not delete!!!";
    public static final String ERROR_CANNOT_FOUND = "Task does not exist!";
    public static final String ERROR_EMPTY = "List Task is empty!";

    public static final String SUCCESS_ADD_MESSAGE = "Add success!";
    public static final String SUCCESS_DELETE_MESSAGE = "Delete success!";

}
