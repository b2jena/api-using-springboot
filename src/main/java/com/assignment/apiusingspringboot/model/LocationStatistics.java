package com.assignment.apiusingspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocationStatistics {
    private String loc;
    private String confirmedCasesIndian;
    private String confirmedCasesForeign;
    private String discharged;
    private String deaths;
    private String totalConfirmed;

    @Override
    public String toString() {
        return "LocationStats{" +
                "loc='" + loc + '\'' +
                ", confirmedCasesIndian='" + confirmedCasesIndian + '\'' +
                ", confirmedCasesForeign='" + confirmedCasesForeign + '\'' +
                ", discharged='" + discharged + '\'' +
                ", deaths='" + deaths + '\'' +
                ", totalConfirmed='" + totalConfirmed + '\'' +
                '}';
    }
}