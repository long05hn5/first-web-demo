/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;


import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class Task {

    private int idTask;
    private String taskType;
    private String priority;
    private String title;
    private String description;
    private float progress;
    private int assignByUser;
    private Timestamp createAt;
    private int createBy;
    private int updateBy;
    private Timestamp updateAt;
    private int deleteBy;
    private Timestamp deleteAt;
    private boolean status;
    private Account accountCreatedBy;
    private Account accountAssinByUser;
    private Account accountDeleteBy;
    private Account accountUpdateBy;

    public Account getAccountUpdateBy() {
        return accountUpdateBy;
    }

    public void setAccountUpdateBy(Account accountUpdateBy) {
        this.accountUpdateBy = accountUpdateBy;
    }
    
    public Task() {
    }

    public Task(String taskType, String priority, String title, String description, float progress, int assignByUser, Timestamp createAt, int createBy, boolean status) {
        this.taskType = taskType;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.progress = progress;
        this.assignByUser = assignByUser;
        this.createAt = createAt;
        this.createBy = createBy;
        this.status = status;
    }
    
    

    public Task(int idTask, float progress, int updateBy, Timestamp updateAt) {
        this.idTask = idTask;
        this.progress = progress;
        this.updateBy = updateBy;
        this.updateAt = updateAt;
    }

    public Task(int idTask, String taskType, String priority, String title, String description, float progress, int assignByUser, Timestamp createAt, int createBy, int updateBy, Timestamp updateAt, int deleteBy, Timestamp deleteAt, boolean status) {
        this.idTask = idTask;
        this.taskType = taskType;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.progress = progress;
        this.assignByUser = assignByUser;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.updateAt = updateAt;
        this.deleteBy = deleteBy;
        this.deleteAt = deleteAt;
        this.status = status;
    }

    

    
    public Task(int idTask, String taskType, String priority, String title, String description, float progress, int assignByUser, Timestamp createAt, int createBy, int updateBy, Timestamp updateAt, int deleteBy, Timestamp deleteAt) {
        this.idTask = idTask;
        this.taskType = taskType;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.progress = progress;
        this.assignByUser = assignByUser;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.updateAt = updateAt;
        this.deleteBy = deleteBy;
        this.deleteAt = deleteAt;
    }
    
    

    public Task(int idTask, String taskType, String priority, String title, String description, float progress, int assignByUser, Timestamp createAt, int createBy, int updateBy, Timestamp updateAt, int deleteBy, Timestamp deleteAt, Account accountCreatedBy, Account accountAssinByUser, Account accountDeleteBy, Account accountUpdateBy) {
        this.idTask = idTask;
        this.taskType = taskType;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.progress = progress;
        this.assignByUser = assignByUser;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.updateAt = updateAt;
        this.deleteBy = deleteBy;
        this.deleteAt = deleteAt;
        this.accountCreatedBy = accountCreatedBy;
        this.accountAssinByUser = accountAssinByUser;
        this.accountDeleteBy = accountDeleteBy;
        this.accountUpdateBy = accountUpdateBy;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Timestamp getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Timestamp deleteAt) {
        this.deleteAt = deleteAt;
    }

    
    
    

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public int getAssignByUser() {
        return assignByUser;
    }

    public void setAssignByUser(int assignByUser) {
        this.assignByUser = assignByUser;
    }

    

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

   

    public int getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(int deleteBy) {
        this.deleteBy = deleteBy;
    }

   

    public Account getAccountCreatedBy() {
        return accountCreatedBy;
    }

    public void setAccountCreatedBy(Account accountCreatedBy) {
        this.accountCreatedBy = accountCreatedBy;
    }

    public Account getAccountAssinByUser() {
        return accountAssinByUser;
    }

    public void setAccountAssinByUser(Account accountAssinByUser) {
        this.accountAssinByUser = accountAssinByUser;
    }

    public Account getAccountDeleteBy() {
        return accountDeleteBy;
    }

    public void setAccountDeleteBy(Account accountDeleteBy) {
        this.accountDeleteBy = accountDeleteBy;
    }


    
    
}
