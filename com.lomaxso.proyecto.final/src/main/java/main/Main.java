package main;

import java.sql.SQLException;

import entities.Enemy;
import entities.Entity;
import entities.Player;
import enums.Species;
import exceptions.EntityNotExistsExpection;
import interfaces.Window;
import maps.Map;

public class Main {

	public static void main(String[] args) {

		try {
			Entity player = new Player("Robert", Species.HUMAN, false);
			Map map = new Map();
			Window w = new Window((Player) player);
			
		} catch (SQLException | EntityNotExistsExpection e) {
			e.printStackTrace();
		} // try

	} // main
} // class
