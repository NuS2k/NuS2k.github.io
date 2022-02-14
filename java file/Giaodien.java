package baitaplon_java;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Giaodien extends JFrame{
        JTextField txtNgay = new JTextField(5);        
        JTextField txtThang = new JTextField(5);        
        JTextField txtNam = new JTextField(5);
        JTextField txtMaKH = new JTextField(15);
        JTextField txtTenKH = new JTextField(15);
        JTextField txtSoLuong = new JTextField(15);
        JTextField txtDonGia = new JTextField(15);
        JTextField txtDTKH = new JTextField(10);
        JTextField txtDmuc = new JTextField(15);
        JTextField txtQTich = new JTextField(15);
        JRadioButton radVN = new JRadioButton("Việt Nam");
        JRadioButton radNN = new JRadioButton("Nước Ngoài");
        JButton btnThem = new JButton("Thêm");
        JButton btnRefresh = new JButton("Hiển thị toàn bộ");
        JPanel pnNhapVN = new JPanel();
        JPanel pnNhapNN = new JPanel();
        DefaultTableModel dtmVN = new DefaultTableModel();
        DefaultTableModel dtmNN = new DefaultTableModel();
        JTable tblSV = new JTable(dtmVN);
        JTable tblNN = new JTable(dtmNN);
        ArrayList<KhachhangVN> dsVN = new ArrayList();
        ArrayList<KhachhangNN> dsNN = new ArrayList();
                
        JButton btnC4 = new JButton("Câu 4");
        JButton btnC5 = new JButton("Câu 5");
        JButton btnC6 = new JButton("Câu 6");
        
      
        
        
    public Giaodien(String title){
        super(title);
        addcontrol();
        addEvent();
    }
    private boolean verifyMaKH(){
        if(radVN.isSelected()){
            for(KhachhangVN k : dsVN){
                if (k.getMaKH().equals(txtMaKH.getText().trim()))
                    return false;
            }
        }else if(radNN.isSelected()){
            for(KhachhangNN k : dsNN){
                if (k.getMaKH().equals(txtMaKH.getText().trim()))
                    return false;
            }
        }
        return true;        
    }
    private boolean verifyNgayThangNam(){
        String strNgay = txtNgay.getText().trim();
        String strThang = txtThang.getText().trim();
        String strNam = txtNam.getText().trim();
        int Ngay = Integer.parseInt(strNgay);
        int Thang = Integer.parseInt(strThang);
        int Nam = Integer.parseInt(strNam);
        switch(Thang){
            case 1: 
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(Ngay < 1 || Ngay > 31) return false;
                break;
            case 4: 
            case 6:
            case 9:
            case 11:
                if(Ngay < 1 || Ngay > 30) return false;
                break;
            case 2:
                if(Nam%400 == 0 || (Nam%4 == 0 && Nam%100 != 0 )){
                    if(Ngay < 1 || Ngay > 29) return false;
                }else if(Ngay < 1 || Ngay > 28) return false;
                break;
            default:
                return false;
        }
        return true;
    }
    private boolean checkinput(){
        boolean ok = true;
        String tb = "";        
        String strMaKH = txtMaKH.getText().trim();
        String strTenKH = txtTenKH.getText().trim();
        String strNgay = txtNgay.getText().trim();
        String strThang = txtThang.getText().trim();
        String strNam = txtNam.getText().trim();
        String strSoLuong = txtSoLuong.getText().trim();
        String strDonGia = txtDonGia.getText().trim();
        String strDTKH = txtDTKH.getText().trim();
        String strDmuc = txtDmuc.getText().trim();
        String strQTich = txtQTich.getText().trim();
        if (strMaKH.equals("")){
            ok = false;
            tb += "Hãy nhập Mã Khách Hàng\n";            
        }
        else if (!verifyMaKH()){
            ok = false;
            tb += "Mã Khách Hàng đã tồn tại\n";
        }
        if (strTenKH.equals("")){
            ok = false;
            tb += "Hãy nhập Tên Khách Hàng\n";            
        }
        try{
            Integer.parseInt(strNgay);
        } catch (NumberFormatException e){
            ok = false;
            tb += "Ngày phải là số nguyên\n"; 
        }
        try{
            Integer.parseInt(strThang);
        } catch (NumberFormatException e){
            ok = false;
            tb += "Tháng phải là số nguyên\n"; 
        }
        try{
            Integer.parseInt(strNam);
        } catch (NumberFormatException e){
            ok = false;
            tb += "Năm phải là số nguyên\n"; 
        }
        if(!verifyNgayThangNam()){
            ok = false;
            tb += "Ngày Tháng Năm không hợp lý\n"; 
        }
        try{
            Long.parseLong(strSoLuong);
        } catch (NumberFormatException e){
            ok = false;
            tb += "Số Lượng phải là số nguyên\n"; 
        }
        try{
            Long.parseLong(strDonGia);
        } catch (NumberFormatException e){
            ok = false;
            tb += "Đơn Giá phải là số nguyên\n"; 
        }
        if (radVN.isSelected()){
            try{
            Integer.parseInt(strDTKH);
            } catch (NumberFormatException e){
            ok = false;
            tb += "Đối tượng khách hàng là số nguyên\n"; 
            }
            try{
                Long.parseLong(strDmuc);
            } catch (NumberFormatException e){
                ok = false;
                tb += "Định Mức phải là số nguyên\n"; 
            }
        } else if (radNN.isSelected()){
                if(strQTich.equals("")){
                    ok = false;
                    tb += "Nhập lại Quốc Tịch\n";
                }
            }
        
        if (!ok) JOptionPane.showMessageDialog(new JPanel(), tb);
        return ok;                            
    }
    
    private void addInput(){                      
        String strMaKH = txtMaKH.getText().trim();
        String strTenKH = txtTenKH.getText().trim();
        String strNgay = txtNgay.getText().trim();
        String strThang = txtThang.getText().trim();
        String strNam = txtNam.getText().trim();
        String strSoLuong = txtSoLuong.getText().trim();
        String strDonGia = txtDonGia.getText().trim();
        String strDTKH = txtDTKH.getText().trim();
        String strDmuc = txtDmuc.getText().trim();
        String strQTich = txtQTich.getText().trim();
        
        int Ngay = Integer.parseInt(strNgay);
        int Thang = Integer.parseInt(strThang);
        int Nam = Integer.parseInt(strNam);
        long Soluong = Long.parseLong(strSoLuong);
        long DonGia = Long.parseLong(strDonGia);
        if(radVN.isSelected()){
            int DTKH = Integer.parseInt(strDTKH);
            long Dmuc = Long.parseLong(strDmuc);
            
            KhachhangVN k = new KhachhangVN(DTKH, Dmuc, strMaKH, strTenKH, Ngay, Thang, Nam, Soluong, DonGia);
            dsVN.add(k);
        }else if(radNN.isSelected()){
            KhachhangNN k = new KhachhangNN(strQTich, strMaKH, strTenKH, Ngay, Thang, Nam, Soluong, DonGia);
            dsNN.add(k);
        }
    }
    private void updateTable(){        
            dtmVN = new DefaultTableModel();
            dtmVN.addColumn("Mã Khách Hàng");
            dtmVN.addColumn("Tên Khách Hàng");
            dtmVN.addColumn("Ngày ra hoá đơn");
            dtmVN.addColumn("Đối tượng KH");
            dtmVN.addColumn("Số Lượng");
            dtmVN.addColumn("Đơn Giá");
            dtmVN.addColumn("Định mức");
            dtmVN.addColumn("Thành Tiền");
            for(KhachhangVN k : dsVN){
                String[] row = new String[8];                
                row[0] = k.getMaKH();
                row[1] = k.getHoTen();
                row[2] = "" + k.getNgay() + "/" + k.getThang() + "/" + k.getNam();
                row[3] = "" + k.getDoituong();
                row[4] = "" + k.getSoLuong();
                row[5] = "" + k.getDonGia();
                row[6] = "" + k.getDinhmuc();
                row[7] = "" + k.getThanhTien();
                
                dtmVN.addRow(row);                
            }
            tblSV.setModel(dtmVN);       
            dtmNN = new DefaultTableModel();
            dtmNN.addColumn("Mã Khách Hàng");
            dtmNN.addColumn("Tên Khách Hàng");
            dtmNN.addColumn("Ngày ra hoá đơn");
            dtmNN.addColumn("Quốc tịch");
            dtmNN.addColumn("Số Lượng");
            dtmNN.addColumn("Đơn Giá");
            dtmNN.addColumn("Thành Tiền");
            for(KhachhangNN k : dsNN){
                String[] row = new String[7];                
                row[0] = k.getMaKH();
                row[1] = k.getHoTen();
                row[2] = "" + k.getNgay() + "/" + k.getThang() + "/" + k.getNam();
                row[3] = "" + k.getQuocTich();
                row[4] = "" + k.getSoLuong();
                row[5] = "" + k.getDonGia();                
                row[6] = "" + k.getThanhTien();
                
                dtmNN.addRow(row);
            }
            tblNN.setModel(dtmNN);        
    }
    private void updateC6(){        
            dtmVN = new DefaultTableModel();
            dtmVN.addColumn("Mã Khách Hàng");
            dtmVN.addColumn("Tên Khách Hàng");
            dtmVN.addColumn("Ngày ra hoá đơn");
            dtmVN.addColumn("Đối tượng KH");
            dtmVN.addColumn("Số Lượng");
            dtmVN.addColumn("Đơn Giá");
            dtmVN.addColumn("Định mức");
            dtmVN.addColumn("Thành Tiền");
            for(KhachhangVN k : dsVN){
                if(k.getThang() == 9 && k.getNam() == 2013){
                String[] row = new String[8];                
                row[0] = k.getMaKH();
                row[1] = k.getHoTen();
                row[2] = "" + k.getNgay() + "/" + k.getThang() + "/" + k.getNam();
                row[3] = "" + k.getDoituong();
                row[4] = "" + k.getSoLuong();
                row[5] = "" + k.getDonGia();
                row[6] = "" + k.getDinhmuc();
                row[7] = "" + k.getThanhTien();
                
                dtmVN.addRow(row);}                
            }
            tblSV.setModel(dtmVN);        
            dtmNN = new DefaultTableModel();
            dtmNN.addColumn("Mã Khách Hàng");
            dtmNN.addColumn("Tên Khách Hàng");
            dtmNN.addColumn("Ngày ra hoá đơn");
            dtmNN.addColumn("Quốc tịch");
            dtmNN.addColumn("Số Lượng");
            dtmNN.addColumn("Đơn Giá");
            dtmNN.addColumn("Thành Tiền");
            for(KhachhangNN k : dsNN){
                if(k.getThang() == 9 && k.getNam() == 2013){
                String[] row = new String[7];                
                row[0] = k.getMaKH();
                row[1] = k.getHoTen();
                row[2] = "" + k.getNgay() + "/" + k.getThang() + "/" + k.getNam();
                row[3] = "" + k.getQuocTich();
                row[4] = "" + k.getSoLuong();
                row[5] = "" + k.getDonGia();                
                row[6] = "" + k.getThanhTien();
                
                dtmNN.addRow(row);
                }
            }
            tblNN.setModel(dtmNN);
        
    }
    public void addEvent(){
        radVN.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pnNhapVN.setVisible(true);
                pnNhapNN.setVisible(false);
                
                txtMaKH.setText("");
                txtTenKH.setText("");
                txtNgay.setText("");
                txtThang.setText("");
                txtNam.setText("");
                txtSoLuong.setText("");
                txtDonGia.setText("");
                txtDTKH.setText("");
                txtDmuc.setText("");
            }
        });
        radNN.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pnNhapVN.setVisible(false);
                pnNhapNN.setVisible(true);
                
                txtMaKH.setText("");
                txtTenKH.setText("");
                txtNgay.setText("");
                txtThang.setText("");
                txtNam.setText("");
                txtSoLuong.setText("");
                txtDonGia.setText("");
                txtQTich.setText("");                
            }
        });
        btnThem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkinput()) return;
                addInput();
                updateTable();
            }
        });
        btnRefresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {               
                updateTable();
            }
        });
        btnC4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String kq = "";
                long slVN = 0;
                for (KhachhangVN k: dsVN){
                    slVN += k.getSoLuong();
                }
                kq += "Tổng số lượng khách hàng Việt Nam sử dụng:" + slVN + "\n";
                long slNN = 0;
                for (KhachhangNN k: dsNN){
                    slNN += k.getSoLuong();
                }
                kq += "Tổng số lượng khách hàng Nước Ngoài sử dụng:" + slNN + "\n";
                JOptionPane.showMessageDialog(new JPanel(), kq);
            }
        });
        btnC5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String kq = "";
                long tong = 0;
                long soKH = 0;
                for (KhachhangNN k: dsNN){
                    soKH += 1;
                    tong += k.getThanhTien();                    
                }
                if(soKH == 0)soKH = 1;
                kq += "Trung bình thành tiền của khách hàng Nước Ngoài là " + (tong/soKH) + "\n";
                JOptionPane.showMessageDialog(new JPanel(), kq);
            }
        });
        btnC6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateC6();
            }
        });
    }
        
    public void addcontrol(){
        radVN.setSelected(true);
        pnNhapNN.setVisible(false);
        
        Container con = getContentPane();
        
        JPanel pnLeft = new JPanel();
        pnLeft.setLayout(new BorderLayout());
        JPanel pnRight = new JPanel();
        pnRight.setLayout(new BorderLayout());
        
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
        sp.setOneTouchExpandable(true);
        pnLeft.setPreferredSize(new Dimension(900, 0));
        
        JPanel pnRightofTop = new JPanel();
        pnRightofTop.setLayout(new BorderLayout());
        JPanel pnRightofBottom = new JPanel();
        pnRightofBottom.setLayout(new BorderLayout());
        JPanel pnLeftofTop = new JPanel();
        pnLeftofTop.setLayout(new BorderLayout());
        JPanel pnLeftofBottom = new JPanel();
        pnLeftofBottom.setLayout(new BorderLayout());
        
        JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnRightofTop, pnRightofBottom);
        spRight.setOneTouchExpandable(true);
        pnRightofTop.setPreferredSize(new Dimension(0, 250));
        pnRight.add(spRight);
        JSplitPane spLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnLeftofTop, pnLeftofBottom);
        spLeft.setOneTouchExpandable(true);
        pnLeftofTop.setPreferredSize(new Dimension(0, 250));
        pnLeft.add(spLeft);
        con.add(sp);
                
        dtmVN.addColumn("Mã Khách Hàng");
        dtmVN.addColumn("Tên Khách Hàng");
        dtmVN.addColumn("Ngày ra hoá đơn");
        dtmVN.addColumn("Đối tượng KH");
        dtmVN.addColumn("Số Lượng");
        dtmVN.addColumn("Đơn Giá");
        dtmVN.addColumn("Định mức");
        dtmVN.addColumn("Thành Tiền");
                
        JScrollPane scSV = new JScrollPane(tblSV,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnLeftofTop.add(scSV, BorderLayout.CENTER);
        
        dtmNN.addColumn("Mã Khách Hàng");
        dtmNN.addColumn("Tên Khách Hàng");
        dtmNN.addColumn("Ngày ra hoá đơn");
        dtmNN.addColumn("Quốc tịch");
        dtmNN.addColumn("Số Lượng");
        dtmNN.addColumn("Đơn Giá");
        dtmNN.addColumn("Thành Tiền");
              
        JScrollPane scNN = new JScrollPane(tblNN,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnLeftofBottom.add(scNN, BorderLayout.CENTER);
            
        JPanel pnTieuDe = new JPanel();
        pnTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTieuDe = new JLabel("Khách Hàng VN");
        pnTieuDe.add(lblTieuDe);
        pnLeftofTop.add(pnTieuDe,BorderLayout.NORTH);
        
        JPanel pnTieuDe1 = new JPanel();
        pnTieuDe1.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTieuDe1 = new JLabel("Khách Hàng NN");
        pnTieuDe1.add(lblTieuDe1);
        pnLeftofBottom.add(pnTieuDe1,BorderLayout.NORTH);
        
        JPanel pnThongTin = new JPanel();
        pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
        JPanel pnTieuDeTT = new JPanel();
        pnTieuDeTT.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTieuDeTT = new JLabel("Nhập Thông Tin");
        pnTieuDeTT.add(lblTieuDeTT);
        pnThongTin.add(pnTieuDeTT);
        
        JPanel pnLoaiKH = new JPanel();
        pnLoaiKH.setLayout(new FlowLayout());
        JLabel lblLoaiKH = new JLabel("Loại Khách hàng");
        ButtonGroup bgLoaiKH = new ButtonGroup();
        bgLoaiKH.add(radVN);
        bgLoaiKH.add(radNN);
        pnLoaiKH.add(lblLoaiKH);
        pnLoaiKH.add(radVN);
        pnLoaiKH.add(radNN);
        pnThongTin.add(pnLoaiKH);
        
        JPanel pnMaKH = new JPanel();
        pnMaKH.setLayout(new FlowLayout());
        JLabel lblMaKH = new JLabel("Mã Khách Hàng");        
        pnMaKH.add(lblMaKH);
        pnMaKH.add(txtMaKH);
        pnThongTin.add(pnMaKH);
        
        JPanel pnTenKH = new JPanel();
        pnTenKH.setLayout(new FlowLayout());
        JLabel lblTenKH = new JLabel("Tên Khách Hàng");        
        pnTenKH.add(lblTenKH);
        pnTenKH.add(txtTenKH);
        pnThongTin.add(pnTenKH);
        
        JPanel pnNgay = new JPanel();
        JLabel lblNam = new JLabel("Năm");
        JLabel lblThang = new JLabel("Tháng");
        JLabel lblNgay = new JLabel("Ngày");
        pnNgay.setLayout(new FlowLayout());
        
        pnNgay.add(lblNgay);
        pnNgay.add(txtNgay);
        pnNgay.add(lblThang);
        pnNgay.add(txtThang);
        pnNgay.add(lblNam);
        pnNgay.add(txtNam);
        pnThongTin.add(pnNgay);
   
        JPanel pnSoLuong = new JPanel();
        pnSoLuong.setLayout(new FlowLayout());
        JLabel lblSoLuong = new JLabel("Số Lượng");
        pnSoLuong.add(lblSoLuong);
        pnSoLuong.add(txtSoLuong);
        pnThongTin.add(pnSoLuong);
        
        JPanel pnDonGia = new JPanel();
        pnDonGia.setLayout(new FlowLayout());
        JLabel lblDonGia = new JLabel("Đơn Giá");        
        pnDonGia.add(lblDonGia);
        pnDonGia.add(txtDonGia);
        pnThongTin.add(pnDonGia);
        
        JPanel pnDTKH = new JPanel();
        pnDTKH.setLayout(new FlowLayout());
        JLabel lblDTKH = new JLabel("Đối tượng khách hàng");
        pnDTKH.add(lblDTKH);
        pnDTKH.add(txtDTKH);
        pnNhapVN.setLayout(new BoxLayout(pnNhapVN, BoxLayout.Y_AXIS));
        pnThongTin.add(pnNhapVN);
        pnNhapVN.add(pnDTKH);
        
        JPanel pnDMuc = new JPanel();
        pnDMuc.setLayout(new FlowLayout());
        JLabel lblDmuc = new JLabel("Định Mức");        
        pnDMuc.add(lblDmuc);
        pnDMuc.add(txtDmuc);
        pnNhapVN.add(pnDMuc);
        
        JPanel pnQTich = new JPanel();
        pnQTich.setLayout(new FlowLayout());
        JLabel lblQTich = new JLabel("Quốc Tịch");        
        pnQTich.add(lblQTich);
        pnQTich.add(txtQTich);
        pnNhapNN.setLayout(new BoxLayout(pnNhapNN, BoxLayout.Y_AXIS));
        pnThongTin.add(pnNhapNN);
        pnNhapNN.add(pnQTich);
        
        
        JPanel pnXuLy = new JPanel();
        pnXuLy.setLayout(new FlowLayout());        
        pnXuLy.add(btnThem);
        pnXuLy.add(btnRefresh);
        pnThongTin.add(pnXuLy);
        pnRightofTop.add(pnThongTin, BorderLayout.CENTER);
        
        JPanel pnThem = new JPanel();
        pnThem.setLayout(new FlowLayout());
        pnRightofBottom.add(pnThem, BorderLayout.CENTER);
        pnThem.add(btnC4);
        pnThem.add(btnC5);
        pnThem.add(btnC6);
        
    }
    public void showWindow(){
        this.setSize(1280,720);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
}
