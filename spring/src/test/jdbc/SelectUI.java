package test.jdbc;

import java.util.Iterator;
import java.util.List;

import dao.TeamDao;

import model.Team;

public class SelectUI extends AbstractUi {

    private DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public void show() {
        showUserList(this.dao.getUserList());
        System.out.println("Enter를 눌러 주십시오.");
        getInputedString();
    }

    protected void showUserList(List userList) {
        System.out.println("--------------------");
        System.out.println("     User   관 리 ");
        System.out.println("");
        System.out.println("ID  User 명");
        for (Iterator iter = userList.iterator(); iter.hasNext();) {
            UserDTO user = (UserDTO) iter.next();
            System.out.println(user.getNum() + "  " + user.getName()+" "+user.getReg());
        }
    }
}

















