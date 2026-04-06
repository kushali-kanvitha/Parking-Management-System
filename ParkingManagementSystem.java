package project;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ParkingManagementSystem extends Frame implements ActionListener {

    private ArrayList<String> parkingSlots;
    private Queue<String> waitingQueue;

    private TextField carField;
    private Button parkBtn, removeBtn, waitBtn;

    private ParkingCanvas parkingCanvas;

    public ParkingManagementSystem() {

        setTitle("Parking Management System - Full Page");
        setExtendedState(MAXIMIZED_BOTH);   
        setLayout(new BorderLayout());
        
        parkingSlots = new ArrayList<>(Arrays.asList(null, null, null, null, null));
        waitingQueue = new LinkedList<>();

        Panel topPanel = new Panel(new FlowLayout());
        topPanel.setBackground(new Color(210, 230, 255));

        carField = new TextField(20);

        parkBtn = new Button("Park Car");
        removeBtn = new Button("Remove Car");
        waitBtn = new Button("Waiting List");

        parkBtn.setBackground(new Color(0, 180, 0));
        parkBtn.setForeground(Color.white);

        removeBtn.setBackground(new Color(180, 0, 0));
        removeBtn.setForeground(Color.white);

        waitBtn.setBackground(Color.YELLOW);
        waitBtn.setForeground(Color.BLACK);

        parkBtn.addActionListener(this);
        removeBtn.addActionListener(this);
        waitBtn.addActionListener(this);

        topPanel.add(new Label("Car No:"));
        topPanel.add(carField);
        topPanel.add(parkBtn);
        topPanel.add(removeBtn);
        topPanel.add(waitBtn);

        add(topPanel, BorderLayout.NORTH);

        parkingCanvas = new ParkingCanvas();
        parkingCanvas.setBackground(new Color(50, 50, 60));
        add(parkingCanvas, BorderLayout.CENTER);

        setVisible(true);
    }

    class ParkingCanvas extends Canvas {
        public void paint(Graphics g) {
            drawParkingVisual(g);
        }
    }

    private void drawParkingVisual(Graphics g) {

        int startX = 80;
        int startY = 150;
        int slotW = 180;
        int slotH = 80;
        int gap = 40;

        g.setFont(new Font("Arial", Font.BOLD, 22));
        g.setColor(Color.WHITE);
        g.drawString("Parking Slots", startX, startY - 30);

        int x = startX;

        for (int i = 0; i < parkingSlots.size(); i++) {

            if (parkingSlots.get(i) == null)
                g.setColor(new Color(0, 200, 0)); 
            else
                g.setColor(new Color(220, 0, 0)); 

            g.fillRect(x, startY, slotW, slotH);
            g.setColor(Color.WHITE);
            g.drawRect(x, startY, slotW, slotH);

            g.drawString("Slot " + (i + 1), x + 60, startY + 30);

            if (parkingSlots.get(i) != null)
                g.drawString(parkingSlots.get(i), x + 50, startY + 60);

            x += slotW + gap;
        }

        g.setColor(Color.WHITE);
        g.drawString("Waiting Queue:", startX, startY + 150);

        int qx = startX;
        int qy = startY + 180;

        for (String car : waitingQueue) {

            g.setColor(Color.YELLOW);
            g.fillRect(qx, qy, 80, 40);

            g.setColor(Color.BLACK);
            g.drawRect(qx, qy, 80, 40);

            g.drawString(car, qx + 20, qy + 25);

            qx += 100;
        }
    }

    public void actionPerformed(ActionEvent e) {

        String car = carField.getText().trim();

        if (e.getSource() == parkBtn && !car.isEmpty()) {
            parkCar(car);
        }

        if (e.getSource() == removeBtn && !car.isEmpty()) {
            removeCar(car);
        }

        if (e.getSource() == waitBtn) {
            showWaitingListPopup();
        }

        carField.setText("");
        parkingCanvas.repaint();
    }

    private void showWaitingListPopup() {

        StringBuilder sb = new StringBuilder("Cars in Waiting Queue:\n\n");

        if (waitingQueue.isEmpty())
            sb.append("No cars in queue.");
        else
            for (String car : waitingQueue)
                sb.append(car).append("\n");

        Dialog d = new Dialog(this, "Waiting Queue", true);
        d.setLayout(new FlowLayout());
        d.setSize(300, 300);

        TextArea ta = new TextArea(sb.toString(), 12, 30);
        ta.setEditable(false);
        d.add(ta);

        Button close = new Button("Close");
        close.addActionListener(ev -> d.dispose());
        d.add(close);

        d.setVisible(true);
    }

    private void showErrorPopup(String message) {
        Dialog d = new Dialog(this, "Error", true);
        d.setLayout(new FlowLayout());
        d.setSize(300, 150);

        Label lbl = new Label(message);
        d.add(lbl);

        Button close = new Button("OK");
        close.addActionListener(ev -> d.dispose());
        d.add(close);

        d.setVisible(true);
    }

    private void parkCar(String car) {
        if (parkingSlots.contains(car)) {
            showErrorPopup("Car already parked!");
            return;
        }

        if (waitingQueue.contains(car)) {
            showErrorPopup("Car already in waiting queue!");
            return;
        }

        for (int i = 0; i < parkingSlots.size(); i++) {
            if (parkingSlots.get(i) == null) {
                parkingSlots.set(i, car);
                return;
            }
        }

        waitingQueue.add(car);
    }

    private void removeCar(String car) {

        for (int i = 0; i < parkingSlots.size(); i++) {

            if (car.equals(parkingSlots.get(i))) {

                parkingSlots.set(i, null);

                if (!waitingQueue.isEmpty())
                    parkingSlots.set(i, waitingQueue.poll());

                return;
            }
        }
        waitingQueue.remove(car);
    }

    public static void main(String[] args) {
        new ParkingManagementSystem();
    }
}
