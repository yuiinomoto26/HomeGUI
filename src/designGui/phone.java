package designGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class phone extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField nameText;
	private JTextField numText;
	private JTextField bdText;
	DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					phone frame = new phone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public phone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(73, 37, 37));
		contentPane.setBackground(new Color(228, 222, 207));
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		ImageIcon icon1 = new ImageIcon(System.getProperty("user.dir") +"/img/ダウンロード.png");
	    setIconImage(icon1.getImage());
		
		Object[][] rowData = {
				{"haya", "09098769211", "11/29"},
				{"seo", "09087650511", "11/05"},
				{"Bob", "09065437894", "04/14"},
				{"Alice", "09012347890", "12/20"},
				{"nami", "09046137985", "06/19"},

		};
		//列の名前の配列
		String[] colName = {"名前", "電話番号", "誕生日"};
		
		tableModel = new DefaultTableModel(rowData,colName);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//テーブルの作成
		table = new JTable(tableModel);
		table.setSelectionForeground(new Color(228, 222, 207));
		table.setForeground(new Color(73, 37, 37));
		table.setGridColor(new Color(128, 128, 128));
		table.setBackground(new Color(255, 255, 255));
		//単一選択に設定
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//スクロールバーの追加
		JScrollPane scroll = new JScrollPane(table);
		scroll.setForeground(new Color(73, 37, 37));
		scroll.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 16));
		scroll.setBackground(new Color(255, 255, 255));
		//スクロールバーのサイズ設定
		scroll.setPreferredSize(new Dimension(400, 200));
		

		contentPane.add(scroll);
		
		
		//削除ボタン
		JButton deleteButton = new JButton("削除");
		deleteButton.addActionListener(new DeleteButtonListener());
		
		//名前
		JLabel nameLabel = new JLabel("名前");
		nameText = new JTextField(5);
		//年齢
		JLabel namLabel = new JLabel("電話番号");
		numText = new JTextField(5);
		//身長
		JLabel bdLabel = new JLabel("誕生日");
		bdText = new JTextField(5);
		
		//削除ボタン
		JButton addButton = new JButton("追加");
		addButton.addActionListener(new AddButtonListener());
		//コンテントペインにボタンを追加
		//テーブル
		contentPane.add(scroll);
		//削除ボタン
		contentPane.add(deleteButton);
		//名前
		contentPane.add(nameLabel);
		contentPane.add(nameText);
		//年齢
		contentPane.add(namLabel);
		contentPane.add(numText);	
		//身長
		contentPane.add(bdLabel);
		contentPane.add(bdText);
		//追加ボタン
		contentPane.add(addButton);
		
	
	}


class DeleteButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int selectedRow = table.getSelectedRow(); 
		if (selectedRow != -1) {
			tableModel.removeRow(selectedRow);
		}
	}


}


class AddButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//名前を取得
		String name = nameText.getText();
		//年齢を取得
		String num = numText.getText();
		
		//身長を取得
		String bd = bdText.getText();
		
		//データを追加(Object型の配列を渡す)
		tableModel.addRow(new Object[] {name, num, bd});
	}		
	
}	
}	
