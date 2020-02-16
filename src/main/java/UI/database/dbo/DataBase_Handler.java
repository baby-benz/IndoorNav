package UI.database.dbo;

import UI.database.Entity.Line.Line;
import UI.database.Entity.Point.Point;
import org.sqlite.JDBC;
import java.sql.*;
import java.util.*;

public class DataBase_Handler {
    private Connection connection;

    // Константа, в которой хранится адрес подключения
    private static final String CON_STR =
            "jdbc:sqlite:C:\\JavaProject\\database\\locator.db";

    private static DataBase_Handler instance = null;

    public static synchronized DataBase_Handler getInstance() throws SQLException {
        if (instance == null)
            instance = new DataBase_Handler();
        return instance;
    }

    public DataBase_Handler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public void close() throws SQLException {
        this.connection.close();
    }



    public List<Point> getAllPoint() {

        // Statement используется для того, чтобы выполнить sql-запрос
        try (Statement statement = this.connection.createStatement()) {

            List<Point> points = new ArrayList<Point>();


            ResultSet resultSet = statement
                    .executeQuery("SELECT id, x, y, location FROM point");

            while (resultSet.next()) {
                points.add(new Point(resultSet.getInt("id"),
                        resultSet.getInt("x"),
                        resultSet.getInt("y"),
                        resultSet.getString("location")));
            }

            return points;

        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }


    // Добавление продукта в БД
    public void addPoint(Point point) {
        // Создадим подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO point(x, y, location) " +
                        "VALUES(?, ?, ?)")) {
            statement.setObject(1, point.x);
            statement.setObject(2, point.y);
            statement.setObject(3, point.location);

            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    // Удаление продукта по id
//        public void deleteProduct(int id) {
//            try (PreparedStatement statement = this.connection.prepareStatement(
//                    "DELETE FROM Products WHERE id = ?")) {
//                statement.setObject(1, id);
//                // Выполняем запрос
//                statement.execute();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//    }



    public List<Line> getAllLines() {

        // Statement используется для того, чтобы выполнить sql-запрос
        try (Statement statement = this.connection.createStatement()) {

            List<Line> lines = new ArrayList<Line>();


            ResultSet resultSet = statement
                    .executeQuery("SELECT pointID1, pointID2 FROM line");

            while (resultSet.next()) {
                lines.add(new Line(resultSet.getInt("pID1"),
                        resultSet.getInt("pID2")));
            }

            return lines;

        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }


    // Добавление продукта в БД
    public void addLine(Line line) {
        // Создадим подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO line(pointID1, pointID2) " +
                        "VALUES(?, ?)")) {
            statement.setObject(1, line.pID1);
            statement.setObject(2, line.pID2);

            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
