package com.healthcare;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowUi);
    }

    private static void createAndShowUi() {
        JFrame frame = new JFrame("Healthcare Risk Assessment Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 320);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Healthcare Risk Assessment Demo");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel noteLabel = new JLabel("Educational demo only. Not medical advice.");
        noteLabel.setForeground(new Color(180, 50, 50));

        JLabel feature1Label = new JLabel("Feature 1");
        JTextField feature1Field = new JTextField();

        JLabel feature2Label = new JLabel("Feature 2");
        JTextField feature2Field = new JTextField();

        JButton assessButton = new JButton("Assess Risk");
        JLabel resultLabel = new JLabel("Risk Category: ");
        JTextArea explanationArea = new JTextArea(4, 30);
        explanationArea.setLineWrap(true);
        explanationArea.setWrapStyleWord(true);
        explanationArea.setEditable(false);
        explanationArea.setBackground(panel.getBackground());

        RiskAssessor assessor = new RiskAssessor();

        assessButton.addActionListener(e -> {
            try {
                double feature1 = Double.parseDouble(feature1Field.getText().trim());
                double feature2 = Double.parseDouble(feature2Field.getText().trim());

                MedicalRecord record = new MedicalRecord(feature1, feature2);
                String risk = assessor.assessRisk(record);
                String explanation = assessor.explainRisk(record);

                resultLabel.setText("Risk Category: " + risk);
                explanationArea.setText(explanation);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for both features.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridy = 1;
        panel.add(noteLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 2; gbc.gridx = 0;
        panel.add(feature1Label, gbc);

        gbc.gridx = 1;
        panel.add(feature1Field, gbc);

        gbc.gridy = 3; gbc.gridx = 0;
        panel.add(feature2Label, gbc);

        gbc.gridx = 1;
        panel.add(feature2Field, gbc);

        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 2;
        panel.add(assessButton, gbc);

        gbc.gridy = 5;
        panel.add(resultLabel, gbc);

        gbc.gridy = 6;
        panel.add(explanationArea, gbc);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
