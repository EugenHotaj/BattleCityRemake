package com.TopDown2DGame;

import main.Game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopGame {
	public static void main (String[] args) {
		new LwjglApplication(new Game(), "Battle City - Remake", 416, 416, false);
	}
}
