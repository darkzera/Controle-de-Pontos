package com.dio.controleacesso.config;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {

    public Connection getConnection() {
        // 1 - Declarar objeto conexão (irá receber uma conexão após executar os passos abaixo)
        Connection connection = null;
        String urlConnection = "jdbc:mysql://localhost/digital_in";

        // 2 - Carregar arquivo de propriedades para pegar parâmetros necessários para se comunicar com o banco de dados
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("connection.properties")) {

            // 3 - Definir parâmetros para se conectar ao banco de dados MySQL.
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            // 4 - Construção da string de conexão.
            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString(); //sb.toString() == "jdbc:mysql://localhost/digital_innovation_one"

            // 5 - Criar conexão usando o DriverManager, passando como parâmetros a string de conexão, usuário e senha do usuário.
            try {
                connection = DriverManager.getConnection(connectionUrl, user, password);
            } catch (SQLException e) {
                System.out.println("FALHA ao tentar criar conexão");
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            System.out.println("FALHA ao tentar carregar aquivos de propriedades");
            e.printStackTrace();
        }

        return connection;
    }
}
