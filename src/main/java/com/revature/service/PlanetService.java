package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Planet;
import com.revature.repository.PlanetDao;

public class PlanetService {

	private PlanetDao dao;

	public PlanetService(){
		this.dao = new PlanetDao();
	}

	public List<Planet> getAllPlanets(){
		try {
		    return	this.dao.getAllPlanets();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return getAllPlanets();
		}
	}


	public Planet getPlanetByName(String username, String planetName) {
		return this.dao.getPlanetByName(planetName);
	}

	public Planet getPlanetById(String username, int planetId) {
		return this.dao.getPlanetById(planetId);
	}

	public Planet createPlanet(String userName, Planet p) {
		return this.dao.createPlanet(userName, p);
	}

	public void deletePlanetById(int planetId) {
		this.dao.deletePlanetById(planetId);
	}

	public static void main(String[] args) {
		PlanetService planetService = new PlanetService();
		planetService.getAllPlanets();
	}
}

