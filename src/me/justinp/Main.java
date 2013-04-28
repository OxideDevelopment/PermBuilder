package me.justinp;

public class Main {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BuilderWindow window = new BuilderWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
