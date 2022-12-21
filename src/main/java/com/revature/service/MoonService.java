package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Moon;
import com.revature.repository.MoonDao;

public class MoonService {

	private MoonDao dao;

	public MoonService() {
		this.dao = new MoonDao();
	}

	public List<Moon> getAllMoons() {
		// TODO Auto-generated method stub
		try {
			return this.dao.getAllMoons();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return getAllMoons();
		}
	}

	public Moon getMoonByName(String username, String moonName) {
		// TODO Auto-generated method stub
		return this.dao.getMoonByName(moonName);
	}

	public Moon getMoonById(String username, int moonId) {
		// TODO Auto-generated method stub
		return this.dao.getMoonById(moonId);
	}

	public Moon createMoon(String username, Moon m) {
		// TODO Auto-generated method stub
		return this.dao.createMoon(m);
	}

	public void deleteMoonById(int moonId) {
		// TODO Auto-generated method stub
		this.dao.deleteMoonById(moonId);
	}

	public List<Moon> getMoonsFromPlanet(int planetId) {
		// TODO Auto-generated method stub
		try {
			return this.dao.getMoonsFromPlanet(planetId);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return getMoonsFromPlanet(planetId);
		}
	}
}
