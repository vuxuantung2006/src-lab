package main;

import constant.Constants;
import constant.Message;
import controller.Controller;
import dto.TaskDTO;
import constant.TaskType;
import java.util.Date;
import java.util.Scanner;
import utils.Validation;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Controller control = new Controller();
        TaskDTO dto = new TaskDTO();
        control.setDto(dto);

        while (true) {
            System.out.println(Message.MENU_HEADER.concat(Message.MENU_BODY));
            int choice = getInt(Message.INPUT_CHOICE, 1, 4);

            switch (choice) {
                case 1:
                    inputTaskData(dto);
                    control.addTask();
                    break;
                case 2:
                    dto.setId(getInt(Message.INPUT_TASK_ID, 1, Integer.MAX_VALUE));
                    control.deleteTask();
                    break;
                case 3:
                    control.showTasks();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    /**
     * Helper method to collect all task information.
     */
    private static void inputTaskData(TaskDTO dto) {
        dto.setRequirementName(getString(Message.INPUT_REQUIREMENT_NAME, Constants.REGEX_REQUIMENT_NAME));
        dto.setTaskType(TaskType.getTaskTypeByID(getInt(Message.INPUT_TASK_TYPE_CHOICE, 1, 4)));
        dto.setDate(getDate(Message.INPUT_DATE, Constants.DATE_FORMAT_PATTERN));
        
        double planFrom = getDouble(Message.INPUT_PLAN_FROM, 8.0, 17.0);
        double planTo = getDouble(Message.INPUT_PLAN_TO, planFrom + 0.5, 17.5);
        
        dto.setPlanFrom(planFrom);
        dto.setPlanTo(planTo);
        dto.setAssign(getString(Message.INPUT_ASSIGNEE, Constants.REGEX_NAME_PEOPLE));
        dto.setReviewer(getString(Message.INPUT_REVIEWER, Constants.REGEX_NAME_PEOPLE));
    }

    // --- Các hàm điều khiển vòng lặp nhập liệu tại Main ---

    private static int getInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                return Validation.getInt(sc.nextLine(), min, max);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getString(String prompt, String regex) {
        while (true) {
            try {
                System.out.print(prompt);
                return Validation.getString(sc.nextLine(), regex);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Date getDate(String prompt, String pattern) {
        while (true) {
            try {
                System.out.print(prompt);
                return Validation.getDate(sc.nextLine(), pattern);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double getDouble(String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                return Validation.getDouble(sc.nextLine(), min, max);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}