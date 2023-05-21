package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

/**
 * Clase de Acceso a Base de Datos, abstractat, que permite hacer de forma
 * simple y sin preocuparse de la sintaxis SQL, las operaciones CRUD sobre una
 * DB.
 * 
 * @author jessk
 *
 */

public abstract class DAO {

	/**
	 * Objeto conexión, desde el que se va a referenciar a la DB. La operación será
	 * conectar, usar y desconectar lo antes posible.
	 */

	private static Connection connection;

	/**
	 * Función privada que abre una conexión con un servidor de base de datos. Las
	 * propiedades de la base de datos deben esar definidas en un fichero.
	 * ./bdconfig.ini con el siguienet formate: 1ºLínea: IP o DNS del server.
	 * 2ºLínea: Puerto. 3ºLínea: Nombre BD. 4ºLínea: Usuario BD 5ºLínea: Contraseña
	 * DB
	 * 
	 * @return Statement, listo para hacer la consulta que necesitamos.
	 */

	private static Statement connect() {
		try {
			BufferedReader lector = new BufferedReader(new FileReader("./bdconfig.ini"));
			String ip = lector.readLine();
			int puerto = Integer.parseInt(lector.readLine());
			String nombreBD = lector.readLine();
			String usuario = lector.readLine();
			String password = lector.readLine();
			lector.close();

			connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + puerto + "/" + nombreBD, usuario,
					password); // jdbc:mysql//127.0.0.1:89.12.30.20/
			return connection.createStatement();

		} catch (IOException | SQLException e) {
			e.printStackTrace();
			return null;
		} // try / catch
	} // connect

	public static int insert(String table, LinkedHashMap<String, Object> campos) throws SQLException {
		Statement querier = connect();
		String query = "insert into " + table + " (";
		Iterator it = campos.keySet().iterator();

		// insert into cliente (email,nombre,telefono,contraseña,
		while (it.hasNext()) {
			String clave = (String) it.next();
			query += clave + ",";
		} // while

		query = query.substring(0, query.length() - 1) + ") values (";

		it = campos.values().iterator();
		while (it.hasNext()) {
			Object elemento = it.next();
			if (elemento.getClass() != String.class && elemento.getClass() != Character.class) {
				query += elemento + ",";
			} else {
				query += "'" + elemento + "',";
			} // if / else
		} // while
		query = query.substring(0, query.length() - 1) + ")";
		
		if (Config.verboseMode) {
			System.out.println(query);
		} // if
		int ret = querier.executeUpdate(query);
		disconnect(querier);
		return ret;
	} // insert

	public static int delete(String table, LinkedHashMap<String, Object> campos) throws SQLException {
		Statement querier = connect();

		String query = "delete from " + table + " where ";
		Iterator it = campos.entrySet().iterator();

		while (it.hasNext()) {
			Entry actual = (Entry) it.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				query += actual.getKey() + " = " + actual.getValue() + " and ";
			} else {
				query += actual.getKey() + " = '" + actual.getValue() + "' and ";
			} // if / else
		} // while

		query = query.substring(0, query.length() - 5);
		
		if (Config.verboseMode) {
			System.out.println(query);
		} // if
		int ret = querier.executeUpdate(query);
		disconnect(querier);
		return ret;
	} // delete

	public static ArrayList<Object> consult(String table, LinkedHashSet<String> camposSelect,
			LinkedHashMap<String, Object> restricciones) throws SQLException {

		Statement smt = connect();
		String query = "SELECT ";

		Iterator it = camposSelect.iterator();
		while (it.hasNext()) {
			query += (String) it.next() + ",";
		} // while

		query = query.substring(0, query.length() - 1) + " FROM " + table + (restricciones.size() > 0 ? " WHERE " : "");

		Iterator itm = restricciones.entrySet().iterator();
		while (itm.hasNext()) {
			Entry actual = (Entry) itm.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				query += actual.getKey() + " = " + actual.getValue() + " and ";
			} else {
				query += actual.getKey() + " = '" + actual.getValue() + "' and ";
			} // if / else
		} // while

		if (restricciones.size() > 0) {
			query = query.substring(0,query.length() - 5);
		} // if

		ResultSet cursor = smt.executeQuery(query);
		ArrayList<Object> fila = new ArrayList<Object>();

		while (cursor.next()) {

			Iterator hsCol = camposSelect.iterator();

			while (hsCol.hasNext()) {

				String nombreCol = (String) hsCol.next();
				try {
					fila.add(cursor.getInt(cursor.findColumn(nombreCol)));
				} catch (NumberFormatException | SQLException e) {
					fila.add(cursor.getString(cursor.findColumn(nombreCol)));
				} // try / catch
			} // while
		} // while
		
		if (Config.verboseMode) {
			System.out.println(query);
			System.out.println(fila);
		} // if
		disconnect(smt);
		return fila;
	} // consult

	public static int update(String tabla, HashMap<String, Object> datosAModificar,
			HashMap<String, Object> restricciones) throws SQLException {

		String query = "UPDATE " + tabla + " SET ";
		Iterator itm = datosAModificar.entrySet().iterator();
		while (itm.hasNext()) {
			Entry actual = (Entry) itm.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				query += actual.getKey() + " = " + actual.getValue() + ",";
			} else {
				query += actual.getKey() + " = '" + actual.getValue() + "',";
			} // if / else
		} // while
		query = query.substring(0, query.length() - 1) + " WHERE ";

		Iterator itr = restricciones.entrySet().iterator();
		while (itr.hasNext()) {
			Entry actual = (Entry) itr.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				query += actual.getKey() + " = " + actual.getValue() + " and ";
			} else {
				query += actual.getKey() + " = '" + actual.getValue() + "' and ";
			} // if / else
		} // while
		query = query.substring(0, query.length() - 5);
		
		if (Config.verboseMode) {
			System.out.println(query);
		} // if
		
		Statement smt = connect();
		System.out.println(query);
		int ret = smt.executeUpdate(query);
		disconnect(smt);

		return ret;
	} // update

	/**
	 * Función privada que cierrra en su interior tanto el statement pasado por
	 * argumentos
	 * 
	 * @param smt
	 */

	private static void disconnect(Statement smt) {
		try {
			smt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // try / catch
	} // disconnect

} // class
