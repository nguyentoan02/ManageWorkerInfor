/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.Worker;

/**
 *
 * @author MSII
 */
public class Validate {

    private Scanner in = new Scanner(System.in);

    //check user input number limit
    public int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    // check id must be existed in DB.
    public boolean checkIdExist(ArrayList<Worker> lw, String id) {
        //check from first to last list id worker exist or not
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return true;
            }
        }
        return false;
    }

    //check salary must be greater than 0
    public int checkInputSalary() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < 0) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Salary must be greater than 0");
                System.out.print("Enter again: ");
            }
        }
    }

    //check worker duplicate
    public boolean checkWorkerExist(ArrayList<Worker> lw, String id,
            String name, int age, int salary, String workLocation) {
        //check from first to last list worker  worker exist or not
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())
                    && name.equalsIgnoreCase(worker.getName())
                    && age == worker.getAge()
                    && salary == worker.getSalary()) {
                return false;
            }
        }
        return true;
    }

}
