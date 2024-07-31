import javax.swing.*;
import java.lang.string;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class atm extends JFrame implements ActionListener {
    private bankacc account;
    private JTextField amountField;
    private JLabel balanceLabel, messageLabel;

    public atm(bankacc account) {
        this.account = account;

        // Set up the UI
        setTitle("atm Machine");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        balanceLabel = new JLabel("Balance: " + account.getBalance());
        add(balanceLabel);

        add(new JLabel("Enter amount:"));
        amountField = new JTextField(10);
        add(amountField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setActionCommand("1");
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setActionCommand("2");
        depositButton.addActionListener(this);
        add(depositButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setActionCommand("3");
        checkBalanceButton.addActionListener(this);
        add(checkBalanceButton);

        messageLabel = new JLabel("");
        add(messageLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int cmd = e.getActionCommand();
        try {
            double amount = Double.parseDouble(amountField.getText());

            switch (cmd) {
                case 1: // Withdraw
                    if (account.withdraw(amount)) {
                        messageLabel.setText("Withdrawal successful!");
                    } else {
                        messageLabel.setText("Insufficient balance.");
                    }
                    break;

                case 2: // Deposit
                    account.deposit(amount);
                    messageLabel.setText("Deposit successful!");
                    break;

                case 3: // Check Balance
                    messageLabel.setText("Current balance: " + account.getBalance());
                    break;
            }
            balanceLabel.setText("Balance: " + account.getBalance());
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid amount.");
        }
    }

    public static void main(String[] args) {
        bankacc account = new bankacc(1000.0);
        atm atm = new atm(account);
        atm.setVisible(true);
    }
}
