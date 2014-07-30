package com.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {

	// private InputPanel panel;

	public int panel_id;

	public JTextField columnId;

	public JComboBox condition;

	public JTextField compValue;

	public JButton addOne;

	public JButton subOne;

	public InputPanel() {

	}

	private InputPanel InputPanel(int i) {
		final InputPanel panel = new InputPanel();
		panel.panel_id = i;
		columnId = new JTextField();
		columnId.setBounds(0, 0, 200, 30);
		condition = new JComboBox(new ConditionUtils().getCondition());
		condition.setBounds(260, 0, 80, 30);
		compValue = new JTextField();
		compValue.setBounds(410, 0, 200, 30);
		addOne = new JButton("+");
		addOne.setBounds(670, 0, 50, 30);
		addOne.addActionListener(new ActionListener() {
			private int panel_id = panel.panel_id;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 插入到第I个位置，I = panel_id
				InputPanel showPanel = new InputPanel()
						.getPanelImpl(panel_id + 1);
				if (panel_id < AdvanceFrame.conditionList.size()) {
					showPanel.setBounds(AdvanceFrame.conditionList
							.get(panel_id).getX(), AdvanceFrame.conditionList
							.get(panel_id).getY(), AdvanceFrame.conditionList
							.get(panel_id).getWidth(),
							AdvanceFrame.conditionList.get(panel_id)
									.getHeight());
					// 调整位置
					AdvanceFrame.conditionList.add(null);
					for (int i = AdvanceFrame.conditionList.size() - 1; i > panel_id; i--) {
						AdvanceFrame.conditionList.get(i - 1)
								.setBounds(
										AdvanceFrame.conditionList.get(i - 1)
												.getX(),
										AdvanceFrame.conditionList.get(i - 1)
												.getY() + 31,
										AdvanceFrame.conditionList.get(i - 1)
												.getWidth(),
										AdvanceFrame.conditionList.get(i - 1)
												.getHeight());
						AdvanceFrame.conditionList.set(i,
								AdvanceFrame.conditionList.get(i - 1));
						AdvanceFrame.conditionList.get(i).panel_id++;
					}
					AdvanceFrame.conditionList.set(panel_id, showPanel);
				} else {
					System.out.println("get    " + panel_id);
					showPanel
							.setBounds(
									AdvanceFrame.conditionList
											.get(panel_id - 1).getX(),
									AdvanceFrame.conditionList
											.get(panel_id - 1).getY() + 31,
									AdvanceFrame.conditionList
											.get(panel_id - 1).getWidth(),
									AdvanceFrame.conditionList
											.get(panel_id - 1).getHeight());
					AdvanceFrame.conditionList.add(showPanel);
				}
				for (InputPanel p : AdvanceFrame.conditionList)
					System.out.println(" " + p.panel_id + " |\n");
				System.out.println("aover");
				AdvanceFrame.cPanel.add(showPanel);
				AdvanceFrame.cPanel.repaint();
			}

		});
		subOne = new JButton("-");
		subOne.setBounds(730, 0, 50, 30);
		subOne.addActionListener(new ActionListener() {
			private int panel_id = panel.panel_id;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 移除第I-1个位置，I = panel_id
				InputPanel showPanel = AdvanceFrame.conditionList
						.get(panel_id - 1);
				if (panel_id < AdvanceFrame.conditionList.size()) {
					// 调整位置
					for (int i = panel_id; i < AdvanceFrame.conditionList
							.size(); i++) {
						AdvanceFrame.conditionList.get(i).panel_id--;
						AdvanceFrame.conditionList.get(i).setBounds(
								AdvanceFrame.conditionList.get(i).getX(),
								AdvanceFrame.conditionList.get(i).getY() - 31,
								AdvanceFrame.conditionList.get(i).getWidth(),
								AdvanceFrame.conditionList.get(i).getHeight());
						AdvanceFrame.conditionList.set(i - 1,
								AdvanceFrame.conditionList.get(i));
					}
					AdvanceFrame.conditionList
							.remove(AdvanceFrame.conditionList.size() - 1);
				} else {
					AdvanceFrame.conditionList.remove(showPanel);
				}
				for (InputPanel p : AdvanceFrame.conditionList)
					System.out.println(" " + p.panel_id + " |\n");
				System.out.println("dover");
				AdvanceFrame.cPanel.remove(showPanel);
				AdvanceFrame.cPanel.repaint();

			}

		});

		// panel = new InputPanel();
		panel.setLayout(null);
		panel.add(this.columnId);
		panel.add(this.condition);
		panel.add(this.compValue);
		panel.add(this.addOne);
		panel.add(this.subOne);
		return panel;
	}

	public InputPanel getPanelImpl(int i) {

		return this.InputPanel(i);
	}

}
