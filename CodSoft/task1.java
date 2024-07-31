import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//<applet code="task1.class" width=1000 height=1000></applet>

public class task1 extends Applet implements ActionListener {
    
    TextField[] marksFields;
    Button calculateButton = new Button("Calculate the Marks");
    Label resultLabel = new Label("Enter marks for 5 subjects");
    Label totalMarksLabel = new Label();
    Label averagePercentageLabel = new Label();
    Label gradeLabel = new Label();
    
    public void init() {
        setLayout(new FlowLayout());
        
        marksFields = new TextField[5];
        for (int i = 0; i < 5; i++) {
            marksFields[i] = new TextField(10);
            add(new Label("Subject " + (i + 1) + ":"));
            add(marksFields[i]);
        }
        
        add(resultLabel);
        add(calculateButton);
        add(totalMarksLabel);
        add(averagePercentageLabel);
        add(gradeLabel);
        
        calculateButton.addActionListener(this);
        
        setSize(500, 500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        int totalMarks = 0;
        int subjects = marksFields.length;
        boolean validInput = true;
        
        for (int i = 0; i < subjects; i++) {
            try {
                int marks = Integer.parseInt(marksFields[i].getText());
                if (marks < 0 || marks > 100) {
                    resultLabel.setText("Enter valid input b/w 0 to 100..!!");
                    validInput = false;
                    break;
                }
                totalMarks += marks;
            } catch (NumberFormatException e) {
                resultLabel.setText("Enter valid Numbers..!!");
                validInput = false;
                break;
            }
        }
        
        if (validInput) {
            int averagePercentage = totalMarks / subjects;
            char grade = calculateGrade(averagePercentage);
            
            totalMarksLabel.setText("Total Marks: " + totalMarks);
            averagePercentageLabel.setText("Average Percentage: " + averagePercentage + "%");
            gradeLabel.setText("Grade: " + grade);
        }
    }
    
    private char calculateGrade(int averagePercentage) {
        if (averagePercentage >= 80) return 'A';
        if (averagePercentage >= 70) return 'B';
        if (averagePercentage >= 60) return 'C';
        if (averagePercentage >= 50) return 'D';
        return 'F';
    }
    
    public void paint(Graphics g) {
        // No custom painting required
    }
}

