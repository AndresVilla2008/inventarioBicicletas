package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexion;
import model.Bicicleta;

public class BicicletaRepository {
    public void insertarBicicleta(Bicicleta bici) {
        String sql = "INSERT INTO bicicleta (codigo, marca, color, tamaño) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, bici.getCodigo());
            preparedStatement.setString(2, bici.getMarca());
            preparedStatement.setString(3, bici.getColor());
            preparedStatement.setString(4, bici.getTamaño());
            preparedStatement.execute();
            System.out.println("Bicicleta insertada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Bicicleta> listarBicicletas() {
        List<Bicicleta> bicicletas = new ArrayList<>();
        String sql = "SELECT id_bicicleta, codigo, marca, color, tamaño FROM bicicleta";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Bicicleta b = new Bicicleta(
                        resultSet.getInt("id_bicicleta"),
                        resultSet.getString("codigo"),
                        resultSet.getString("marca"),
                        resultSet.getString("color"),
                        resultSet.getString("tamaño")
                );
                bicicletas.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bicicletas;
    }

    public Bicicleta mostrarBicicleta(String codigo) {
        Bicicleta bici = null;
        String sql = "SELECT * FROM bicicleta WHERE codigo = ?";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                bici = new Bicicleta(
                        resultSet.getInt("id_bicicleta"),
                        resultSet.getString("codigo"),
                        resultSet.getString("marca"),
                        resultSet.getString("color"),
                        resultSet.getString("tamaño")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bici;
    }

    public static void eliminarBicicleta(int id) {
        String sql = "DELETE FROM bicicleta WHERE id_bicicleta = ?";

        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            Integer resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
                System.out.println("Bicicleta eliminada exitosamente!");
            } else {
                System.out.println("Bicicleta no encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizarBicicleta(Bicicleta bici) {
        String sql = "UPDATE bicicleta SET codigo = ?, marca = ?, color = ?, tamaño = ? WHERE id_bicicleta = ?";

        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, bici.getCodigo());
            preparedStatement.setString(2, bici.getMarca());
            preparedStatement.setString(3, bici.getColor());
            preparedStatement.setString(4, bici.getTamaño());
            preparedStatement.setInt(5, bici.getId_bicicleta());

            Integer resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
                System.out.println("Bicicleta actualizada exitosamente!");
            } else {
                System.out.println("Bicicleta no encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
