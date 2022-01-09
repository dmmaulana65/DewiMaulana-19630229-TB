/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplikasi_Kepegawain;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */

public class koneksi {

    String url  = "jdbc:mysql://localhost/kepegawaian";
    String user = "root";
    String pass = "";

     public koneksi(){}
    
     //--- KONFIGURASI KONEKSI KE DATABASE
     public Connection Connect() throws SQLException {
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return DriverManager.getConnection(url,user,pass);
    }
    
    
    public void simpanPegawai(String nip, String nama, String jk, String ttl, String agama,String no_sk, String ijazah, String no_telp, String jabatan){
        try {
            String sql = "INSERT INTO pegawai(nip, nama, jk, ttl, agama, no_sk, ijazah, no_telp, jabatan) VALUES ('"+nip+"','"+nama+"','"+jk+"','"+ttl+"','"+agama+"','"+no_sk+"','"+ijazah+"','"+no_telp+"','"+jabatan+"')";
            Statement com = Connect().createStatement();
            com.executeUpdate(sql);
            com.close();
            Connect().close();
        } catch (Exception e) {
            System.err.println("Pesan Error : " + e.getMessage());
        }
    } 
    
     public void simpanKehadiran(String nip, String nama, String jabatan, String absen, String keterangan){
        try {
            String sql = "INSERT INTO kehadiran(nip, nama, jabatan, absen, keterangan) VALUES ('"+nip+"','"+nama+"','"+jabatan+"','"+absen+"','"+keterangan+"')";
            Statement com = Connect().createStatement();
            com.executeUpdate(sql);
            com.close();
            Connect().close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    } 
     
     
    public void simpanGaji(String nip, String nama, String jabatan, String gaji){
        try {
            String sql = "INSERT INTO gaji(nip, nama, jabatan, gaji) VALUES ('"+nip+"','"+nama+"','"+jabatan+"','"+gaji+"')";
            Statement com = Connect().createStatement();
            com.executeUpdate(sql);
            com.close();
            Connect().close();
        } catch (Exception e) {
            System.err.println("Pesan Error : " + e.getMessage());
        }
    } 
    
//    public void ubahPegawai(){
//        try {
//            String sql = "INSERT INTO pegawai(nip, nama, jk, ttl, agama, no_sk, ijazah, no_telp, jabatan) VALUES ('"+nip+"','"+nama+"','"+jk+"','"+ttl+"','"+agama+"','"+no_sk+"','"+ijazah+"','"+no_telp+"','"+jabatan+"')";
//            Statement com = Connect().createStatement();
//            com.executeUpdate(sql);
//            com.close();
//            Connect().close();
//        } catch (Exception e) {
//            System.err.println("Pesan Error : " + e.getMessage());
//        }
//    }
     
     
//     public void ubahKehadiran(){
//         String SQL = "UPDATE kehadiran SET nip=?,nama=?,jabatan=?,absen=?,keterangan=? WHERE nama="+txtNama.getText()+"";
//            try{
//                PreparedStatement command = Connect().prepareStatement(sql);
//            }
//            Statement com = Connect().createStatement();
//            com.executeUpdate(SQL);           
//            com.close();
//            Connect().close();
//            JOptionPane.showMessageDialog(null, "berhasil edit");
//           
//        }catch(Exception exc){
//            System.err.println(exc.getMessage());
//        }
//     }
//    
//   
    public void hapus(String Table, String Primary, String Value){
        try {
            String sqlDelete = "DELETE FROM "+Table+" WHERE "+Primary+" = "+Value;
            Statement com = Connect().createStatement();
            com.executeUpdate(sqlDelete);
            
            com.close();
            Connect().close();
        } catch (Exception e) {
            System.err.println("Pesan Error "+e.getMessage());
        }
    }
    
     
    public Object[][] Table(String SQL, int kolom){
        Object[][] data = null;
        
        try {
            Statement command = Connect().createStatement();
            ResultSet dataset = command.executeQuery(SQL);
            dataset.last();
            int baris = dataset.getRow();
            dataset.beforeFirst();
            
            int j = 0;
            data = new Object[baris][kolom];
            while (dataset.next()) {                
                for (int i = 0; i < kolom; i++) {
                    data[j][i] = dataset.getString(i+1);
                }
                j++;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return data;
    }
    
     public void judul(JTable Table, String[] JudulKolom){
        try {
            DefaultTableModel model = new DefaultTableModel();
            Table.setModel(model);
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            
            for (int i = 0; i < JudulKolom.length; i++) {
                model.addColumn(JudulKolom[i]);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    
    
    public void tampilTable(JTable Table, String[] Judul, String SQL){
        try {
            Table.setModel(new DefaultTableModel(Table(SQL, Judul.length), Judul));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
     
    
    
    
     //======================= CEK KONEKSI KE DATABASE
    public static void main(String[] args) throws SQLException {
        try {
            koneksi cek = new koneksi();
            cek.Connect();
            System.out.println("berhasil");
        } catch (Exception e) {
            System.err.println("Koneksi Gagal" + e.getMessage());
        }
    }

}

