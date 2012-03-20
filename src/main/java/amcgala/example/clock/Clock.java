package amcgala.example.clock;

import java.text.SimpleDateFormat;
import java.util.Date;

import amcgala.framework.animation.Animation;
import amcgala.framework.camera.Camera;
import amcgala.framework.math.Matrix;
import amcgala.framework.math.Vector3d;
import amcgala.framework.renderer.Renderer;
import amcgala.framework.shape.Circle3d;
import amcgala.framework.shape.Polygon;
import amcgala.framework.shape.Shape;

public class Clock extends Shape {

	private Polygon second, minute, hour;
	private Circle3d clockFace;

	public Clock() {
		this.clockFace = new Circle3d(0, 0, 1, 120);
		second = new Polygon(new Vector3d(-5, 0, 0), new Vector3d(5, 0, 0),
				new Vector3d(0, 5, 0), new Vector3d(0, 0, 0));
		minute = new Polygon(new Vector3d(-5, 0, 0), new Vector3d(5, 0, 0),
				new Vector3d(0, 5, 0), new Vector3d(0, 0, 0));
		hour = new Polygon(new Vector3d(-5, 0, 0), new Vector3d(5, 0, 0),
				new Vector3d(0, 5, 0), new Vector3d(0, 0, 0));

		this.setAnimation(new ClockAnimation());

	}

	@Override
	public void render(Matrix arg0, Camera arg1, Renderer arg2) {
		clockFace.render(arg0, arg1, arg2);
		second.render(arg0, arg1, arg2);
		minute.render(arg0, arg1, arg2);
		hour.render(arg0, arg1, arg2);
	}

	private class ClockAnimation extends Animation<Shape> {

		@Override
		public void animate() {
			Date dt = new Date();
			SimpleDateFormat microFormat = new SimpleDateFormat("S");
			SimpleDateFormat secondFormat = new SimpleDateFormat("ss");
			SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
			SimpleDateFormat hourFormat = new SimpleDateFormat("HH");

			double secondDegree = 360 * ((Double.parseDouble(secondFormat
					.format(dt))+Double.parseDouble(microFormat.format(dt))/1000.0) / 60.0);
			double minuteDegree = 360 * ((Double.parseDouble(minuteFormat
					.format(dt)) + Double.parseDouble(secondFormat.format(dt)) / 60.0) / 60.0);
			double hourDegree = 360 * ((Double.parseDouble(hourFormat
					.format(dt)) + Double.parseDouble(minuteFormat.format(dt)) / 60.0) / 12.0);

			double secondRadian = Math.toRadians(secondDegree);
			double minuteRadian = Math.toRadians(minuteDegree);
			double hourRadian = Math.toRadians(hourDegree);

			second = new Polygon(
					new Vector3d(5 * Math.sin(secondRadian - Math.PI / 2),
							5 * Math.cos(secondRadian - Math.PI / 2), 0),
					new Vector3d(10 * Math.sin(secondRadian + Math.PI),
							10 * Math.cos(secondRadian + Math.PI), 0),
					new Vector3d(5 * Math.sin(secondRadian + Math.PI / 2),
							5 * Math.cos(secondRadian + Math.PI / 2), 0),
					new Vector3d(100 * Math.sin(secondRadian), 100 * Math
							.cos(secondRadian), 0), new Vector3d(0, 0, 0));
			minute = new Polygon(
					new Vector3d(5 * Math.sin(minuteRadian - Math.PI / 2),
							5 * Math.cos(minuteRadian - Math.PI / 2), 0),
					new Vector3d(10 * Math.sin(minuteRadian + Math.PI),
							10 * Math.cos(minuteRadian + Math.PI), 0),
					new Vector3d(5 * Math.sin(minuteRadian + Math.PI / 2),
							5 * Math.cos(minuteRadian + Math.PI / 2), 0),
					new Vector3d(100 * Math.sin(minuteRadian), 100 * Math
							.cos(minuteRadian), 0), new Vector3d(0, 0, 0));
			hour = new Polygon(
					new Vector3d(5 * Math.sin(hourRadian - Math.PI / 2),
							5 * Math.cos(hourRadian - Math.PI / 2), 0),
					new Vector3d(10 * Math.sin(hourRadian + Math.PI),
							10 * Math.cos(hourRadian + Math.PI), 0),
					new Vector3d(5 * Math.sin(hourRadian + Math.PI / 2),
							5 * Math.cos(hourRadian + Math.PI / 2), 0),
					new Vector3d(50 * Math.sin(hourRadian), 50 * Math
							.cos(hourRadian), 0), new Vector3d(0, 0, 0));
		}

	}

}