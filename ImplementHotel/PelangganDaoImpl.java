/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementHotel;

/**
 *
 * @author Hopeless
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import EntityHotel.Pelanggan;
import ExceptionHotel.PelangganException;
import ServiceHotel.PelangganDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hopeless
 */
public class PelangganDaoImpl implements PelangganDao{
    
    private Connection connection;
    private final String insertPelanggan = "INSERT INTO PELANGGAN"
            + "(NAMA, ALAMAT, TELEPON, EMAIL, TGLIN, TGLOUT) VALUES"
            + "(?,?,?,?,?,?)";

    private final String updatePelanggan = "UPDATE PELANGGAN SET NAMA=?,ALAMAT=?,TELEPON=?,EMAIL=?,TGLIN=?,TGLOUT=? WHERE ID=?";

    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID=?";

    private final String getById = "SELECT * FROM PELANGGAN WHERE ID = ?";

    private final String getByEmail = "SELECT * FROM PELANGGAN WHERE EMAIL = ?";

    private final String selectAll = "SELECT * FROM PELANGGAN";

    public PelangganDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException {

        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPelanggan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getAlamat());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getEmail());
            statement.setString(5, pelanggan.getTglin());
            statement.setString(6, pelanggan.getTglout());
            statement.executeUpdate();
            
            ResultSet result  = statement.getGeneratedKeys();
            if (result.next()) {
                pelanggan.setId(result.getInt(1));
            }
            
            connection.commit();
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException {

        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePelanggan);
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getAlamat());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getEmail());
            statement.setString(5, pelanggan.getTglin());
            statement.setString(6, pelanggan.getTglout());
            statement.setInt(7, pelanggan.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public void deletePelanggan(Integer id) throws PelangganException {

        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePelanggan);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public Pelanggan getPelanggan(Integer id) throws PelangganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            //indeks ke 1, isinya ID dari parameter
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            Pelanggan pelanggan = null;
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                pelanggan.setTglin(result.getString("TGLIN"));
                pelanggan.setTglout(result.getString("TGLOUT"));
            } else {
                throw new PelangganException("Pelanggan dengan id "
                        + id + " tidak ditemukan");
            }
            connection.commit();
            return pelanggan;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public Pelanggan getPelanggan(String email) throws PelangganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByEmail);

            statement.setString(1, email);

            ResultSet result = statement.executeQuery();
            Pelanggan pelanggan = null;
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                pelanggan.setTglin(result.getString("TGLIN"));
                pelanggan.setTglout(result.getString("TGLOUT"));
            } else {
                throw new PelangganException("Pelanggan dengan email "
                        + email + " tidak ditemukan");
            }
            connection.commit();
            return pelanggan;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public List<Pelanggan> selectAllPelanggan() throws PelangganException {
        Statement statement = null;
        List<Pelanggan> list = new ArrayList<Pelanggan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()) {
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                pelanggan.setTglin(result.getString("TGLIN"));
                pelanggan.setTglout(result.getString("TGLOUT"));

                list.add(pelanggan);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }

        }
    }

}