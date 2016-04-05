package control;

import database.Database;
import view.MainWindow;

public class Controller {

    private Database database;
    private MainWindow window;

    public Controller() {
        this.database = new Database();
        this.window = new MainWindow(this);
    }
}
