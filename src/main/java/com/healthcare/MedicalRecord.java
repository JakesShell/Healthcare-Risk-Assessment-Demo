package com.healthcare;

public class MedicalRecord {
    private final double feature1;
    private final double feature2;

    public MedicalRecord(double feature1, double feature2) {
        this.feature1 = feature1;
        this.feature2 = feature2;
    }

    public double getFeature1() {
        return feature1;
    }

    public double getFeature2() {
        return feature2;
    }
}
