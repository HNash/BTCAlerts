import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class Main {
    static JPanel topPanel;
    static JPanel leftPanel;
    static JPanel rightPanel;
    static JPanel btmPanel;
    static JFrame frame;
    static JLabel priceLabel;
    static JLabel priceTitle;
    static Notifier notifier;
    public static double price = 0.0d;

    static boolean priceUpdated = true;

    public static void main(String[] args) {
        // Creating Alert object for sound alerts
        Alert.upPath = "alerts/defaultup.wav";
        Alert.downPath = "alerts/defaultdown.wav";

        // Setting up the frame
        frame = new JFrame("BTC Alerts");
        frame.setVisible(true);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("icon.png");
        frame.setIconImage(img.getImage());

        // Setting up top panel
        topPanel = new JPanel();
        JLabel title = new JLabel("The price is updated once every minute.");
        topPanel.add(title);
        frame.add(topPanel, BorderLayout.NORTH);

        // Setting up the left panel, which contains the buttons that allow the user to pick the alert sounds
        leftPanel = new JPanel();
        frame.add(leftPanel, BorderLayout.WEST);
        GridLayout buttonGrid = new GridLayout(4, 0);
        leftPanel.setLayout(buttonGrid);

        // Padding for the left panel to make it look better
        Border paddingLeft = BorderFactory.createEmptyBorder(50, 50, 50, 0);
        leftPanel.setBorder(paddingLeft);

        // Setting up the right panel, which contains a label which displays the price
        rightPanel = new JPanel();
        GridLayout priceGrid = new GridLayout(2, 0);
        rightPanel.setLayout(priceGrid);
        frame.add(rightPanel, BorderLayout.EAST);

        // Padding for the right panel to make it look better
        Border paddingRight = BorderFactory.createEmptyBorder(50, 50, 50, 75);
        rightPanel.setBorder(paddingRight);

        // Setting up the bottom panel, which contains buttons that allow the user to preview the alert sounds
        btmPanel = new JPanel();
        frame.add(btmPanel, BorderLayout.SOUTH);

        // Filling the button panel
        JLabel label = new JLabel("What type of alert would you like to hear?");
        leftPanel.add(label);

        JButton button = new JButton("Default");
        button.addActionListener((ActionEvent e) -> {
            Alert.upPath = "alerts/defaultup.wav";
            Alert.downPath = "alerts/defaultdown.wav";
        });
        leftPanel.add(button);

        JButton button1 = new JButton("Carlos Matos");
        button1.addActionListener((ActionEvent e) -> {
            Alert.upPath = "alerts/carlosup.wav";
            Alert.downPath = "alerts/carlosdown.wav";
        });
        leftPanel.add(button1);

        JButton button2 = new JButton("BOGGED");
        button2.addActionListener((ActionEvent e) -> {
            Alert.upPath = "alerts/bogup.wav";
            Alert.downPath = "alerts/bogdown.wav";
        });
        leftPanel.add(button2);

        // Filling the preview panel
        JButton button3 = new JButton("Preview alerts");
        button3.addActionListener((ActionEvent e) -> {
            Alert.playUp();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            Alert.playDown();
        });
        btmPanel.add(button3);

        // Filling the price display panel
        priceTitle = new JLabel("BTC Price (USD):");
        rightPanel.add(priceTitle);
        // Creating label by fetching latest price
        priceLabel = new JLabel(Double.toString(price));
        priceLabel.setFont(new Font("Serif", Font.PLAIN, 48));
        PriceFetcher.getPrice();
        rightPanel.add(priceLabel);


        frame.setVisible(true);

        notifier = new Notifier();
    }


    public static void updatePricePanel()
    {
        priceLabel.setText(Double.toString(price));
    }
}