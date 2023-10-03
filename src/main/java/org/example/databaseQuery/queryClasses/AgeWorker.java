package org.example.databaseQuery.queryClasses;

import java.sql.Date;

public class AgeWorker {
    private Type type;
    private String worker_name;
    private Date birthday;

    public AgeWorker(Type type, String worker_name, Date birthday) {
        this.type = type;
        this.worker_name = worker_name;
        this.birthday = birthday;
    }

    public Type getType() {
        return type;
    }

    public String getWorker_name() {
        return worker_name;
    }
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "AgeWorker{" +
                "type=" + type +
                ", worker_name='" + worker_name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public enum Type{
        YOUNGEST,
        OLDEST
    }
}
