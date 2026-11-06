/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//DAO viet tat cua data access object(Thao tac lay du lieu tu database) va maping thanh entity
package DAO;

import static DAO.DBContext.connection;
import DTO.CreateAccountDTO;
import DTO.UpdateAccount;
import Entity.Account;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AccountDAO extends DBContext {

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "Select * from Account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("ID"), rs.getString("Account"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getString("Email"), rs.getString("PhoneNumber"));
                list.add(acc);
            }
            return list;
        } catch (Exception ex) {
            System.out.println("getAllAccount()" + ex.getMessage());
        }
        return list;

    }

    public Account getAccountById(int id) {
        String sql = "select * from Account where id  = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                 Account acc = new Account(rs.getInt("ID"), rs.getString("Account"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getString("Email"), rs.getString("PhoneNumber"));
                 return acc;
            }
        } catch (Exception e) {
            System.out.println("getAccountById" + e.getMessage());
            return null;
        }
        return null;
    }

    public Account loginClothingShop(String account, String password) {
        String sql = "select * from Account where account = ? and password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("ID"), rs.getString("Account"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getString("Email"), rs.getString("PhoneNumber"));
                return acc;
            }
        } catch (Exception e) {
            System.out.println("loginClothingShop" + e.getMessage());
        }
        return null;
    }

    public List<Account> searchByName(String name) {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account where [Name] like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("ID"), rs.getString("Account"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getString("Email"), rs.getString("PhoneNumber"));
                list.add(acc);
            }
        } catch (Exception e) {
            System.out.println("searchByName()" + e.getMessage());
        }
        return list;
    }

    public List<Account> searchByQ1() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account where [address] like '%Q1%'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("ID"), rs.getString("Account"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getString("Email"), rs.getString("PhoneNumber"));
                list.add(acc);
            }
        } catch (Exception e) {
            System.out.println("searchByName()" + e.getMessage());
        }
        return list;
    }

    public List<Account> getAccountByAgeReduce() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from account order by age desc, name asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("ID"), rs.getString("Account"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getString("Email"), rs.getString("PhoneNumber"));
                list.add(acc);
            }
            return list;
        } catch (Exception e) {
            System.out.println("getAccountByAgeReduce()" + e.getMessage());
        }
        return list;
    }

    public List<Account> getAllAccountByNameLikeNguyen() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from account where Name like 'Nguyen%'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("ID"), rs.getString("Account"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getString("Email"), rs.getString("PhoneNumber"));
                list.add(acc);
            }
            return list;
        } catch (Exception e) {
            System.out.println("getAllAccountByNameLikeNguyen()" + e.getMessage());
        }
        return list;
    }

    public List<Account> getAccountWhichAgeBetween20and25() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from account where age between 20 and 25";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("ID"), rs.getString("Account"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getString("Email"), rs.getString("PhoneNumber"));
                list.add(acc);
            }
            return list;
        } catch (Exception e) {
            System.out.println("getAccountWhichAgeBetween20and25()" + e.getMessage());
        }
        return list;
    }

    public List<Account> getAccountByEmail() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from account where Email like '%@example.com'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("ID"), rs.getString("Account"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Address"), rs.getString("Email"), rs.getString("PhoneNumber"));
                list.add(acc);
            }
            return list;
        } catch (Exception e) {
            System.out.println("getAccountByEmail()" + e.getMessage());
        }
        return list;
    }

    public int countAccount() {
        int count = 0;
        String sql = "select count(*) as 'Tong so luong tai khoan' from account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            System.out.println("countAccount()" + e.getMessage());
        }
        return count;
    }

    public int avgAgeAccount() {
        int avg = 0;
        String sql = "select AVG(age) as'So tuoi trung binh cua khach hang' from account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                avg = rs.getInt(1);
            }
            return avg;
        } catch (Exception e) {
            System.out.println("avgAgeAccount()" + e.getMessage());
        }
        return avg;
    }

    public boolean insertAccount(CreateAccountDTO acc) {
        String sql = "insert into account (account,password,name) values(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, acc.getAccount());
            st.setString(2, acc.getPassword());
            st.setString(3, acc.getName());
            return st.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("insertAccount()" + e.getMessage());
            return false;
        }
    }

    public boolean updateAccount(UpdateAccount acc) {
        String sql = "update Account set name = ?, age = ?, address = ?, Email = ?, PhoneNumber = ?, Password = ? where ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, acc.getName());
            st.setInt(2, acc.getAge());
            st.setString(3, acc.getAddress());
            st.setString(4, acc.getEmail());
            st.setString(5, acc.getPhoneNumber());
            st.setString(6, acc.getPassword());
            st.setInt(7, acc.getId());
            return st.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("updateAccount" + e.getMessage());
            return false;
        }
    }

    public boolean deleteAccount(String id) {
        String sql = "delete account where id= ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            return st.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("deleteAccount" + e.getMessage());
            return false;
        }
    }
}
