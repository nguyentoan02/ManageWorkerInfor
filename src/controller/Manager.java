package controller;

import common.Library;
import model.History;
import model.Worker;
import view.Menu;

import java.util.ArrayList;

public class Manager extends Menu<String> {

    private Library library;
    private ArrayList<Worker> workers;
    private ArrayList<History> salaryHistories;

    public Manager() {
        super("Worker Management Menu", new String[]{"Add Worker", "Increase Salary", "Decrease Salary", "Show Adjusted Salary Workers", "Quit"});
        library = new Library();
        workers = new ArrayList<>();
        salaryHistories = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                library.addWorker(workers);
                break;
            case 2:
                //tang luong
                library.changeSalary(workers, salaryHistories, 1);
                break;
            case 3:
                //giam luong
                library.changeSalary(workers, salaryHistories, -1);
                break;
            case 4:
                library.printListHistory(salaryHistories);
                break;
            case 5:
                System.exit(0);
        }
    }
}
