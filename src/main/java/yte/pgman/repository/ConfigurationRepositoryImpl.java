package yte.pgman.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import yte.pgman.repository.pojo.ConfigurationPghba;
import yte.pgman.repository.pojo.ConfigurationPostgres;

import java.sql.*;
import java.util.List;


@Repository
public class ConfigurationRepositoryImpl implements ConfigurationRepository {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public void save(String tableName, List<ConfigurationPostgres> configurationPostgresList) throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, password);
        for (ConfigurationPostgres configurationPostgres: configurationPostgresList) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO "+tableName+"(key, value) VALUES (?, ?)");
            preparedStatement.setString(1, configurationPostgres.getKey());
            preparedStatement.setString(2, configurationPostgres.getValue());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        connection.close();
    }

    @Override
    public void savePghbaConf(String tableName, List<ConfigurationPghba> configurationPghbaList) throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, password);
        for(ConfigurationPghba configurationPghba: configurationPghbaList) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO "+tableName+"(type, database, cuser, address, method) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, configurationPghba.getType());
            preparedStatement.setString(2, configurationPghba.getDatabase());
            preparedStatement.setString(3, configurationPghba.getUser());
            preparedStatement.setString(4, configurationPghba.getAddress());
            preparedStatement.setString(5, configurationPghba.getMethod());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        connection.close();
    }

    private void createTable(String tableName) throws SQLException{
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE " + tableName + " (key VARCHAR(255) , value VARCHAR(255));");
        preparedStatement.executeQuery();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public ConfigurationPostgres getPostgresqlConfigurationWithID(int id) throws SQLException {
        String key = "";
        String value= "";
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pgman_postgresql WHERE xxx=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            key = resultSet.getString("key");
            value= resultSet.getString("value");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return new ConfigurationPostgres(id, key, value);
    }

    @Override
    public ConfigurationPghba getPghbaConfigurationWithID(int id) throws SQLException {
        String type = "";
        String database= "";
        String user = "";
        String address= "";
        String method = "";

        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pgman_pghba WHERE xxx=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            type = resultSet.getString("type");
            database= resultSet.getString("database");
            user = resultSet.getString("user");
            address= resultSet.getString("address");
            method = resultSet.getString("method");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return new ConfigurationPghba(id, type, database, user, address, method);
    }
}
