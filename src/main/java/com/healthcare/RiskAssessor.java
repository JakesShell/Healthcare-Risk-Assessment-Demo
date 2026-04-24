package com.healthcare;

public class RiskAssessor {
    public String assessRisk(MedicalRecord record) {
        double combinedScore = (record.getFeature1() + record.getFeature2()) / 2.0;

        if (combinedScore >= 80) {
            return "High Screening Risk";
        }
        if (combinedScore >= 50) {
            return "Moderate Screening Risk";
        }
        return "Low Screening Risk";
    }

    public String explainRisk(MedicalRecord record) {
        double combinedScore = (record.getFeature1() + record.getFeature2()) / 2.0;

        if (combinedScore >= 80) {
            return "The combined feature profile falls into the higher screening range. Further review by a qualified professional would be appropriate in a real-world setting.";
        }
        if (combinedScore >= 50) {
            return "The combined feature profile falls into a moderate screening range. This demo classifies it as a case that may need closer follow-up.";
        }
        return "The combined feature profile falls into a lower screening range in this demo model.";
    }
}
