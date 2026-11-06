package Controller;

import DAO.AccountDAO;
import DAO.TaskDAO;
import Entity.Task;
import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        
        AccountDAO dao = new AccountDAO();
//////        CreateAccountDTO acc = new CreateAccountDTO("long05hn5", "Libg", "123456");
////        System.out.println(dao.insertAccount(acc));
//        UpdateAccount acc = new UpdateAccount(1, "long05hn5", 13, "hanOi", "long@gmail.com", "035221321321512", "123456");
//        System.out.println(dao.updateAccount(acc));
//        System.out.println(dao.deleteAccount("53"));
        TaskDAO daos = new TaskDAO();
        Task tasks = new Task("hai", "hai", "hai", "hai", 100, 1, date, 1, true);
        System.out.println(daos.createTask(tasks));
//Timestamp now = new Timestamp(System.currentTimeMillis());
//System.out.println(now);
    }
}
