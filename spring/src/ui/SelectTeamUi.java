package ui;

import java.util.Iterator;
import java.util.List;

import dao.TeamDao;

import model.Team;

public class SelectTeamUi extends AbstractUi {

    private TeamDao teamDao;

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void show() {
        showTeamList(this.teamDao.getTeamList());
        System.out.println("Enter�� ���� �ֽʽÿ�.");
        getInputedString();
    }

    protected void showTeamList(List teamList) {
        System.out.println("--------------------");
        System.out.println("     ��   �� �� ");
        System.out.println("");
        System.out.println("ID  �� ��");
        for (Iterator iter = teamList.iterator(); iter.hasNext();) {
            Team team = (Team) iter.next();
            System.out.println(team.getId() + "  " + team.getName());
        }
    }
}
