package IndividualProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class IndividualProject {
    private JFrame frame;
    private JTextArea outputArea;
    private ArrayList<String[]> members;
    private ArrayList<String> packages;
    private ArrayList<String> trainers;

    public static void main(String[] args) {
        new IndividualProject();
    }

    public IndividualProject() {
        members = new ArrayList<>();
        packages = new ArrayList<>();
        trainers = new ArrayList<>();
        
        frame = new JFrame("He thong quan ly phong GYM");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JButton addMemberBtn = new JButton("Them thanh vien");
        JButton removeMemberBtn = new JButton("Xoa thanh vien");
        JButton addPackageBtn = new JButton("Them goi tap");
        JButton registerTrainerBtn = new JButton("Dang ky PT");
        JButton listMembersBtn = new JButton("Danh sach thanh vien");
        JButton listPackagesBtn = new JButton("Danh sach goi tap");
        JButton listTrainersBtn = new JButton("Danh sach PT");
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        
        addMemberBtn.addActionListener(e -> addMember());
        removeMemberBtn.addActionListener(e -> removeMember());
        addPackageBtn.addActionListener(e -> addPackage());
        registerTrainerBtn.addActionListener(e -> addTrainer());
        listMembersBtn.addActionListener(e -> showList("Thanh vien", members));
        listPackagesBtn.addActionListener(e -> showList("Goi tap", packages));
        listTrainersBtn.addActionListener(e -> showList("PT", trainers));
        
        frame.add(addMemberBtn);
        frame.add(removeMemberBtn);
        frame.add(addPackageBtn);
        frame.add(registerTrainerBtn);
        frame.add(listMembersBtn);
        frame.add(listPackagesBtn);
        frame.add(listTrainersBtn);
        frame.add(outputArea);
        
        frame.setVisible(true);
    }

    private void addMember() {
        JTextField nameField = new JTextField(15);
        JTextField phoneField = new JTextField(15);
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("Nhap ten thanh vien:"));
        panel.add(nameField);
        panel.add(new JLabel("Nhap so dien thoai:"));
        panel.add(phoneField);
        
        int result = JOptionPane.showConfirmDialog(frame, panel, "Nhap thong tin", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            if (!name.isEmpty() && phone.matches("\\d+")) {
                members.add(new String[]{name, phone});
                JOptionPane.showMessageDialog(frame, "Da them thanh cong thanh vien!", "Thong bao", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Hay nhap dung so dien thoai!.", "Loi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void removeMember() {
        JTextField nameField = new JTextField(15);
        JPanel panel = new JPanel(new GridLayout(1, 2, 5, 5));
        panel.add(new JLabel("Nhap ten thanh vien:"));
        panel.add(nameField);
        
        int result = JOptionPane.showConfirmDialog(frame, panel, "Xoa thanh vien", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText().trim();
            boolean found = members.removeIf(member -> member[0].equalsIgnoreCase(name));
            if (found) {
                JOptionPane.showMessageDialog(frame, "Xoa thanh vien thanh cong!", "Thong bao", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Khong tim thay thanh vien.", "Loi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void addPackage() {
        String packageName = JOptionPane.showInputDialog(frame, "Nhap ten goi tap:", "Nhap thong tin", JOptionPane.QUESTION_MESSAGE);
        if (packageName != null && !packageName.trim().isEmpty()) {
            packages.add(packageName);
            JOptionPane.showMessageDialog(frame, "Them goi tap thanh cong!", "Thong bao", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void addTrainer() {
        String trainerName = JOptionPane.showInputDialog(frame, "Nhap ten PT:", "Nhap thong tin", JOptionPane.QUESTION_MESSAGE);
        if (trainerName != null && !trainerName.trim().isEmpty()) {
            trainers.add(trainerName);
            JOptionPane.showMessageDialog(frame, "Them PT thanh cong!", "Thong bao", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void showList(String title, ArrayList<?> list) {
    if (list.isEmpty()) {
        JOptionPane.showMessageDialog(frame, "Chua co thong bao " + title.toLowerCase() + " nao.", "Thong bao", JOptionPane.INFORMATION_MESSAGE);
    } else {
        StringBuilder sb = new StringBuilder(title + ":\n");
        if (list == members) {
            for (String[] member : members) {
                sb.append(member[0]).append(" - ").append(member[1]).append("\n");
            }
        } else {
            for (Object item : list) {
                sb.append(item.toString()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(frame, sb.toString(), title, JOptionPane.INFORMATION_MESSAGE);
    }
}

}
