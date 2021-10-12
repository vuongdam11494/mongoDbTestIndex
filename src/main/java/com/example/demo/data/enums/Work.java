package com.example.demo.data.enums;

public enum Work {

	TASKA("work task a"),
	TASKB("work task b"),
	TASKC("work task c"),
	TASKD("work task d"),
	TASKE("work task e"),
	TASKF("work task f"),
	TASKG("work task g"),
	TASKH("work task h"),
	TASKI("work task i"),
	TASKJ("work task j"),
	TASKK("work task k"),
	TASKL("work task l"),
	TASKM("work task m"),
	TASKN("work task n"),
	TASKO("work task o"),
	TASKP("work task p"),
	TASKQ("work task q"),
	TASKR("work task r"),
	TASKS("work task s"),
	TASKT("work task t"),
	TASKU("work task u"),
	TASKV("work task v"),
	TASKW("work task w"),
	TASKX("work task x"),
	TASKY("work task y"),
	TASKZ("work task z");
	
	private String taskContent;
	
	private Work(String content) {
		this.taskContent = content;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return taskContent;
	}
}
