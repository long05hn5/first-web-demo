/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Account;
import Entity.Task;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class TaskDAO extends DBContext {

    public List<Task> getAllTask(int userId) {
        List<Task> list = new ArrayList<>();
        String sql = """
                    SELECT
                                                                 t.ID, t.TaskType, t.Priority, t.Title, t.Description, 
                                                                   t.Progress, t.AssignByUser, t.CreateAt, t.CreatedBy, t.UpdatedBy, t.UpdateAt, t.DeleteAt, t.DeletedBy,
                                                                   creator.Name AS CreatorName, 
                                                                   assignee.Name AS AssignName,
                                                               updated.Name AS UpdateName,
                                                               deleted.Name AS DeleteName
                                                               FROM Task AS t
                                                               LEFT JOIN Account AS creator ON t.CreatedBy = creator.ID
                                                               LEFT JOIN Account AS assignee ON t.AssignByUser = assignee.ID
                                                               LEFT JOIN account AS updated ON t.UpdatedBy = updated.ID
                                                               LEFT JOIN account AS deleted ON t.DeletedBy = deleted.ID
                                                               Where t.Status = 1 and (creator.ID = ? or assignee.ID = ?)
                     """;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Task tasks = new Task(rs.getInt("ID"), rs.getString("TaskType"), rs.getString("Priority"), rs.getString("Title"), rs.getString("Description"), rs.getFloat("Progress"), rs.getInt("AssignByUser"), rs.getTimestamp("CreateAt"), rs.getInt("CreatedBy"), rs.getInt("UpdatedBy"), rs.getTimestamp("UpdateAt"), rs.getInt("DeletedBy"), rs.getTimestamp("DeleteAt"));
                Account acc = new Account();
                acc.setId(rs.getInt("CreatedBy"));
                acc.setName(rs.getString("CreatorName"));
                tasks.setAccountCreatedBy(acc);

                Account accUpdate = new Account();
                accUpdate.setId(rs.getInt("UpdatedBy"));
                accUpdate.setName(rs.getString("UpdateName"));
                tasks.setAccountUpdateBy(accUpdate);

                Account accAssgin = new Account();
                accAssgin.setId(rs.getInt("AssignByUser"));
                accAssgin.setName(rs.getString("AssignName"));
                tasks.setAccountAssinByUser(accAssgin);

                Account accDelete = new Account();
                accDelete.setId(rs.getInt("DeletedBy"));
                accDelete.setName(rs.getString("DeleteName"));
                tasks.setAccountDeleteBy(accDelete);

                list.add(tasks);
            }
        } catch (Exception e) {
            System.out.println("getAllTask()" + e.getMessage());
        }
        return list;
    }

    public Task getTaskById(int id) {
        String sql = """
                     SELECT 
                         t.ID, t.TaskType, t.Priority, t.Title, t.Description, 
                         t.Progress, t.AssignByUser, t.CreateAt, t.CreatedBy, t.UpdatedBy, t.UpdateAt, t.DeleteAt, t.DeletedBy,
                         creator.Name AS CreatorName, 
                         assignee.Name AS AssignName,
                     \tupdated.Name AS UpdateName,
                     \tdeleted.Name AS DeleteName
                     FROM Task AS t
                     LEFT JOIN Account AS creator ON t.CreatedBy = creator.ID
                     LEFT JOIN Account AS assignee ON t.AssignByUser = assignee.ID
                     LEFT JOIN account AS updated ON t.UpdatedBy = updated.ID
                     LEFT JOIN account AS deleted ON t.DeletedBy = deleted.ID
                     Where t.ID = ? and t.status = 1
                     """;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Task tasks = new Task(rs.getInt("ID"), rs.getString("TaskType"), rs.getString("Priority"), rs.getString("Title"), rs.getString("Description"), rs.getFloat("Progress"), rs.getInt("AssignByUser"), rs.getTimestamp("CreateAt"), rs.getInt("CreatedBy"), rs.getInt("UpdatedBy"), rs.getTimestamp("UpdateAt"), rs.getInt("DeletedBy"), rs.getTimestamp("DeleteAt"));
                Account acc = new Account();
                acc.setId(rs.getInt("CreatedBy"));
                acc.setName(rs.getString("CreatorName"));
                tasks.setAccountCreatedBy(acc);

                Account accUpdate = new Account();
                accUpdate.setId(rs.getInt("UpdatedBy"));
                accUpdate.setName(rs.getString("UpdateName"));
                tasks.setAccountUpdateBy(accUpdate);

                Account accAssgin = new Account();
                accAssgin.setId(rs.getInt("AssignByUser"));
                accAssgin.setName(rs.getString("AssignName"));
                tasks.setAccountAssinByUser(accAssgin);

                Account accDelete = new Account();
                accDelete.setId(rs.getInt("DeletedBy"));
                accDelete.setName(rs.getString("DeleteName"));
                tasks.setAccountDeleteBy(accDelete);

                return tasks;

            }
        } catch (Exception e) {
            System.out.println("getTaskById() " + e.getMessage());
        }
        return null;
    }

    public boolean updateTask(Task tasks) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String sql = "update Task set Progress = ?, UpdatedBy = ?, UpdateAt = ? where ID = ? and Status = 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setFloat(1, tasks.getProgress());
            st.setInt(2, tasks.getUpdateBy());
            st.setTimestamp(3, date);
            st.setInt(4, tasks.getIdTask());
            return st.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("UpdateTask" + e.getMessage());
        }
        return false;
    }

    public boolean deleteTask(int id, int deleteId) {
        String sql = "Update Task set Status = 0, DeletedBy = ?, DeleteAt = GETDATE() where ID = ? and status = 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, deleteId);
            st.setInt(2, id);
            return st.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("deleteTask" + e.getMessage());
        }
        return false;
    }

    public boolean createTask(Task tasks) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String sql = """
                     INSERT INTO Task (TaskType, Priority, Title, Description, Progress, AssignByUser, CreateAt, CreatedBy, Status)
                     VALUES 
                     (?, ?, ?, ?, ?, ?, ?, ?, 1)""";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tasks.getTaskType());
            st.setString(2, tasks.getPriority());
            st.setString(3, tasks.getTitle());
            st.setString(4, tasks.getDescription());
            st.setFloat(5, tasks.getProgress());
            st.setInt(6, tasks.getAssignByUser());
            st.setTimestamp(7, date);
            st.setInt(8, tasks.getCreateBy());
            return st.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("createTask" + e.getMessage());
        }
        return false;
    }
}
//GetAllTask tro thanh getByUserId
//UserID lay tu session truyen vao
//Suy ra get All task la 1 userId
