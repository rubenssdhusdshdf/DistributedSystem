package ds.client;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ds.service1.Service1Grpc;
import ds.service2.Service2Grpc;
import ds.service3.Service3Grpc;
import ds.service4.Service4Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ControllerGUI implements ActionListener {

	private JTextField entry1, reply1;
	private JTextField entry2, reply2;
	private JTextField entry3, reply3;

	private JPanel getService1JPanel() {
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("", 10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 1");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 10);
		reply1.setEditable(false);
		panel.add(reply1);

		panel.setLayout(boxlayout);

		return panel;
	}

	private JPanel getService2JPanel() {
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2 = new JTextField("", 10);
		panel.add(entry2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 2");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 10);
		reply2.setEditable(false);
		panel.add(reply2);

		panel.setLayout(boxlayout);

		return panel;
	}

	private JPanel getService3JPanel() {
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3 = new JTextField("", 10);
		panel.add(entry3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 3");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 10);
		reply3.setEditable(false);
		panel.add(reply3);

		panel.setLayout(boxlayout);

		return panel;
	}

	public static void main(String[] args) {
		ControllerGUI gui = new ControllerGUI();
		gui.build();
	}

	private void build() {
		JFrame frame = new JFrame("Service Controller Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

		panel.add(getService1JPanel());
		panel.add(getService2JPanel());
		panel.add(getService3JPanel());

		frame.setSize(300, 300);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String label = button.getActionCommand();

		if (label.equals("Invoke Service 1")) {
			System.out.println("service 1 to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			Service1Grpc.Service1BlockingStub blockingStub = Service1Grpc.newBlockingStub(channel);

			ds.service1.RequestMessage request = ds.service1.RequestMessage.newBuilder().setText(entry1.getText())
					.build();
			ds.service1.ResponseMessage response = blockingStub.service1Do(request);

			reply1.setText(String.valueOf(response.getLength()));
			channel.shutdown();

		} else if (label.equals("Invoke Service 2")) {
			System.out.println("service 2 to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			Service2Grpc.Service2BlockingStub blockingStub = Service2Grpc.newBlockingStub(channel);

			ds.service2.CheckBinStatusRequest request = ds.service2.CheckBinStatusRequest.newBuilder()
					.setBinId(entry2.getText()).build();
			ds.service2.CheckBinStatusResponse response = blockingStub.checkBinStatus(request);

			reply2.setText(response.getMessage());
			channel.shutdown();

		} else if (label.equals("Invoke Service 3")) {
			System.out.println("service 3 to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
			Service3Grpc.Service3BlockingStub blockingStub = Service3Grpc.newBlockingStub(channel);

			ds.service3.MonitorEnergyUsageRequest request = ds.service3.MonitorEnergyUsageRequest.newBuilder()
					.setAreaId(entry3.getText()).build();
			ds.service3.MonitorEnergyUsageResponse response = blockingStub.monitorEnergyUsage(request);

			reply3.setText(response.getMessage());
			channel.shutdown();
		}
	}
}