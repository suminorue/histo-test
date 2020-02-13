package com.postgrestest.jsonpostgres.entity;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "Result")
@Data
@Table(schema = "stocks", name = "table2")
public class Result {
    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private String open;
    private String high;
    private String low;
    private String last;
    private int volume;
    public Result() {
    }
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Stock stock;
//
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Result )) return false;
//        return id != null && id.equals(((Result) o).getId());
//    }
//    @Override
//    public int hashCode() {
//        return Long.hashCode(id);
//    }
}
