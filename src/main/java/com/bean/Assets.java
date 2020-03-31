package com.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Assets {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	private Integer uesrId;
	
	private Integer money;
	
	private static final long serialVersionUID = 1L;
	
	public Assets() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUesrId() {
		return uesrId;
	}

	public void setUesrId(Integer uesrId) {
		this.uesrId = uesrId;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}
	
}
