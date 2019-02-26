package ua.training.model;

import java.util.ArrayList;

public class Model{
    private Record record;

    private ArrayList<Record> users = new ArrayList<Record>();
    public Model() {
        setRecord(new Record());

        Record buff = new Record();
        buff.setLogin("ababaka123");
        buff.setName("Amanda");
        users.add(buff);

        buff = new Record();
        buff.setLogin("Luke1");
        buff.setName("Leonardo");
        users.add(buff);
    }

    public void setLogin(String str)  throws ExistedLoginException {
        for (Record user : users){
            if (user.getLogin().equals(str)){
                throw new ExistedLoginException(View.LOGIN_ALREADY_EXIST);
            }
        }
        record.setLogin(str);
        users.add(record);
        setRecord(new Record());
    }
    public void setName(String str) {
        record.setName(str);
    }
    public Record getRecord() {
        return record;
    }
    public void setRecord(Record record) {
        this.record = record;
    }
}
