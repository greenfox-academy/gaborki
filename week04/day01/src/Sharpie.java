/**
 * Created by Gabor on 03/04/2017.
 */
public class Sharpie {
  String color;
  float width;
  float inkAmount;

  public Sharpie( String color, float width) {
    this.inkAmount = 100;
    this.color = color;
    this.width = width;
  }
  boolean isUseable() {
    return this.inkAmount > 0;
  }
  public void use() {
    this.inkAmount -= 2;
  }
}
