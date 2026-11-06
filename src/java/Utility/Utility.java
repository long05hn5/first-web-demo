package Utility;


import DTO.AccountDTO;
import Entity.Account;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class Utility {

    public List<AccountDTO> mappingEntityDTO(List<Account> accounts) {
        List<AccountDTO> dto = new ArrayList<AccountDTO>();
        for (Account acc : accounts) {
            int id = acc.getId();
            String account = acc.getAccount();
            String name = acc.getName();
            String age = Integer.toString(acc.getAge());
            String address = acc.getAddress();
            String phoneNumber = acc.getPhoneNumber();
            String email = acc.getEmail();
            AccountDTO accD = new AccountDTO(id, account, name, age, address, email, phoneNumber,"");
            dto.add(accD);
        }
        return dto;
    }
}
//searchByName
//filterDuLieu = Quan1
//fullbaitap