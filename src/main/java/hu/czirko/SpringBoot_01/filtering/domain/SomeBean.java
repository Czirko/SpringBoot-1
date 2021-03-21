package hu.czirko.SpringBoot_01.filtering.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@JsonFilter("beanFilter")
public class SomeBean {
    private String field1;

    private String field2;


    public SomeBean(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }
}
