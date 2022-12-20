package com.revature.repository;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Planet;
import com.revature.utilities.ConnectionUtil;

public class PlanetDao {

	public List<Planet> getAllPlanets() throws SQLException {
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "select * from planets";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			List<Planet> planets = new ArrayList<>();
			while (rs.next()) {
				Planet planet = new Planet();
				planet.setId(rs.getInt(1));
				planet.setName(rs.getString(2));
				planet.setOwnerId(rs.getInt(3));
				planets.add(planet);
			}
			return planets;
		}
	}

	public Planet getPlanetByName(String planetName) {
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "select * from planets where name = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, planetName);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Planet planet = new Planet();
			planet.setId(rs.getInt(1));
			planet.setName(rs.getString(2));
			planet.setOwnerId(rs.getInt(3));
			return planet;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return new Planet();
		}
	}

	public Planet getPlanetById(int planetId) {
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "select * from planets where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, planetId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Planet planet = new Planet();
			planet.setId(rs.getInt(1));
			planet.setName(rs.getString(2));
			planet.setOwnerId(rs.getInt(3));
			return planet;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return new Planet();
		}
	}

	public Planet createPlanet(Planet p) {
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "insert into planets values (default,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getOwnerId());
			ResultSet rs = ps.executeQuery();
			rs.next();
			Planet newPlanet = new Planet();
			newPlanet.setId(rs.getInt(1));
			newPlanet.setName(rs.getString(2));
			newPlanet.setOwnerId(rs.getInt(3));
			return newPlanet;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return new Planet();
		}
	}

	public void deletePlanetById(int planetId) {
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "delete from planets where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, planetId);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		PlanetDao planetDao = new PlanetDao();
		Planet p = new Planet();
		p.setName("Saturn");
		p.setOwnerId(3);
		System.out.println(planetDao.createPlanet(p));
	}
}
