package com.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AdvanceFrame {

	public static List<InputPanel> conditionList;
	
	public static JPanel cPanel;
	
	public static void main(String[] args) {
		
		conditionList = new ArrayList<>();
		
		final JFrame frame = new JFrame();

		JPanel panel = new JPanel();

		JButton button = new JButton();
		button.setText("执行");

		JButton button1 = new JButton();
		button1.setText("LOG");

		JPanel panel2 = new JPanel();

		final JTextField folderLocation = new JTextField();
		folderLocation.setEditable(false);

		final JButton folderSelect = new JButton();
		folderSelect.setText("文件");

		cPanel = new JPanel();
		cPanel.setBackground(Color.CYAN);
		cPanel.setLayout(null);
		InputPanel showPanel = new InputPanel().getPanelImpl(1);
		showPanel.setBounds(new Rectangle(0, 1, 780, 30));
		cPanel.add(showPanel);
		conditionList.add(showPanel);
		JScrollPane scroll = new JScrollPane(cPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setAutoscrolls(true);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}

		});

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}

		});

		folderSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser("D:");
//				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// 只能选择目录
				String path = null;
				File f = null;
				int flag = -1;
				try {
					flag = fc.showOpenDialog(null);
				} catch (HeadlessException head) {
					System.out.println("Open File Dialog ERROR!");
				}
				if (flag == JFileChooser.APPROVE_OPTION) {
					// 获得该文件
					f = fc.getSelectedFile();
					path = f.getPath();
					folderLocation.setText(path);
				}
			}

		});

		panel.add(button);
		panel.add(button1);

		panel2.setLayout(new BorderLayout());
		panel2.add(folderLocation);
		panel2.add(folderSelect, BorderLayout.EAST);
		panel2.setBackground(Color.red);

		frame.add(panel, BorderLayout.NORTH);
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setTitle("助手");
		frame.setSize(800, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width - frame
						.getWidth()) / 2, (Toolkit.getDefaultToolkit()
						.getScreenSize().height - frame.getHeight()) / 2);
		frame.setVisible(true);
	}
}
