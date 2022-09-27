package uz.writer.dao.model;

import java.util.ArrayList;
import java.util.List;

public enum InMemoryUsers {
    INSTANCE;
    List<Users> values;

    public List<Users> getValues() {
        return this.values;
    }

    public void setValues(List<Users> values) {
        this.values = values;
    }

    public void addValue(Users value){
        if(this.values == null)
            this.values = new ArrayList<>();
        this.values.add(value);
    }
}
