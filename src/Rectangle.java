// Jacob Conrad, Practice 5, April 13, 2020, The Rectangle class extends SmartRectangularShape and makes and calls its constructor with Rectangle2D

public class Rectangle extends SmartRectangularShape {

	// Rectangle constructor, calls the SmartrectangularShape's first constructor with a RectangularShape input
	public Rectangle() {
		super(new java.awt.geom.Rectangle2D.Double());
	}
}
