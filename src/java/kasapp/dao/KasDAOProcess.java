// Package
package kasapp.dao;

// Dependency
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kasapp.model.DatabaseConfig;
import kasapp.model.Kas;
import kasapp.model.UserLogin;

// Class
public class KasDAOProcess implements KasDAO {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    @Override
    public UserLogin getLogin(String username, String password) {
        UserLogin login = null;
        try {
            String sql = "SELECT * From users where username=? and password=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                login = new UserLogin();
                login.setId(resultSet.getInt("id"));
                login.setUsername(resultSet.getString("username"));
                login.setPassword(resultSet.getString("password"));
                login.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }

    @Override
    public List<Kas> getKasIn() {
        List<Kas> list = null;
        Kas kasMasuk = null;
        try {
            list = new ArrayList<Kas>();
            String sql = "SELECT * FROM kas_in";
            connection = DatabaseConfig.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                kasMasuk = new Kas();
                kasMasuk.setId(resultSet.getInt("id"));
                kasMasuk.setKode(resultSet.getString("kode"));
                kasMasuk.setTanggal(resultSet.getString("tanggal"));
                kasMasuk.setKeterangan(resultSet.getString("keterangan"));
                kasMasuk.setJumlah(resultSet.getInt("jumlah"));
                list.add(kasMasuk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean kasInEntry(Kas kasIn) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO kas_in (kode, tanggal, keterangan, jumlah) VALUES"
                    + "(?, ?, ?, ?)";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, kasIn.getKode());
            preparedStatement.setString(2, kasIn.getTanggal());
            preparedStatement.setString(3, kasIn.getKeterangan());
            preparedStatement.setInt(4, kasIn.getJumlah());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean kasInUpdate(Kas kasIn) {
        boolean flag = false;
        try {
            String sql = "UPDATE kas_in set kode=?, tanggal=?, keterangan=?, jumlah=? where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kasIn.getKode());
            preparedStatement.setString(2, kasIn.getTanggal());
            preparedStatement.setString(3, kasIn.getKeterangan());
            preparedStatement.setInt(4, kasIn.getJumlah());
            preparedStatement.setInt(5, kasIn.getId());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean kasInDelete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE from kas_in where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Kas getaKasIn(int id) {
        Kas kasMasuk = null;
        try {
            String sql = "SELECT * FROM kas_in where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                kasMasuk = new Kas();
                kasMasuk.setId(resultSet.getInt("id"));
                kasMasuk.setKode(resultSet.getString("kode"));
                kasMasuk.setTanggal(resultSet.getString("tanggal"));
                kasMasuk.setKeterangan(resultSet.getString("keterangan"));
                kasMasuk.setJumlah(resultSet.getInt("jumlah"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kasMasuk;
    }

    @Override
    public List<Kas> getKasOut() {
        List<Kas> list = null;
        Kas kasKeluar = null;
        try {
            list = new ArrayList<Kas>();
            String sql = "SELECT * FROM kas_out";
            connection = DatabaseConfig.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                kasKeluar = new Kas();
                kasKeluar.setId(resultSet.getInt("id"));
                kasKeluar.setKode(resultSet.getString("kode"));
                kasKeluar.setTanggal(resultSet.getString("tanggal"));
                kasKeluar.setKeterangan(resultSet.getString("keterangan"));
                kasKeluar.setJumlah(resultSet.getInt("jumlah"));
                list.add(kasKeluar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Kas getaKasOut(int id) {
        Kas kasKeluar = null;
        try {
            String sql = "SELECT * FROM kas_out where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                kasKeluar = new Kas();
                kasKeluar.setId(resultSet.getInt("id"));
                kasKeluar.setKode(resultSet.getString("kode"));
                kasKeluar.setTanggal(resultSet.getString("tanggal"));
                kasKeluar.setKeterangan(resultSet.getString("keterangan"));
                kasKeluar.setJumlah(resultSet.getInt("jumlah"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kasKeluar;
    }

    @Override
    public boolean kasOutEntry(Kas kasOut) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO kas_out (kode, tanggal, keterangan, jumlah) VALUES"
                    + "(?, ?, ?, ?)";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, kasOut.getKode());
            preparedStatement.setString(2, kasOut.getTanggal());
            preparedStatement.setString(3, kasOut.getKeterangan());
            preparedStatement.setInt(4, kasOut.getJumlah());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean kasOutUpdate(Kas kasOut) {
        boolean flag = false;
        try {
            String sql = "UPDATE kas_out set kode=?, tanggal=?, keterangan=?, jumlah=? where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kasOut.getKode());
            preparedStatement.setString(2, kasOut.getTanggal());
            preparedStatement.setString(3, kasOut.getKeterangan());
            preparedStatement.setInt(4, kasOut.getJumlah());
            preparedStatement.setInt(5, kasOut.getId());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean kasOutDelete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE from kas_out where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int sumIn() {
        int totalKasMasuk = 0;
        try {
            String sql = "SELECT Sum(jumlah) from kas_in";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int c = resultSet.getInt(1);
                totalKasMasuk = totalKasMasuk + c;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalKasMasuk;
    }

    @Override
    public int sumOut() {
        int totalKasKeluar = 0;
        try {
            String sql = "SELECT Sum(jumlah) from kas_out";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int c = resultSet.getInt(1);
                totalKasKeluar = totalKasKeluar + c;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalKasKeluar;
    }

}
