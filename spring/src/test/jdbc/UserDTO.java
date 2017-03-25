package test.jdbc;

import java.sql.Timestamp;

public class UserDTO {
	private int num;
	private String name;
	private Timestamp reg;
	
	
	public int getNum() {		return num;	}
	public void setNum(int num) {		this.num = num;	}

	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;}

	public Timestamp getReg() {		return reg;	}
	public void setReg(Timestamp reg) {		this.reg = reg;	}

}
