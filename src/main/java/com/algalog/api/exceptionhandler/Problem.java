package com.algalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problem {
	private Integer status;
	private LocalDateTime datelHour;
	private String title;
	private List<Field> field;
	
	public List<Field> getField() {
		return field;
	}
	public void setField(List<Field> field) {
		this.field = field;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDatelHour() {
		return datelHour;
	}
	public void setDatelHour(LocalDateTime datelHour) {
		this.datelHour = datelHour;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
