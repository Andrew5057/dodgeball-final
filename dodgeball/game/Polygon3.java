package dodgeball.game;

import java.awt.Color;

/**
 * A polygon with an arbitrary number of sides in three dimensions. Defining a
 * Polgyon3 with
 * non-coplanar points will result in unexpected behavior, as will defining a
 * convex Polygon3.
 *
 * @author Andrew Yim
 * @version 11-12-2023
 */
public class Polygon3 implements Cloneable {
  private double[] xCoords;
  private double[] yCoords;
  private double[] zCoords;
  private int length;
  private Color color;
  private Vector3[] points;

  /**
   * Define a Polygon3 in terms of its vertices as Vector3s and its fill color.
   */
  public Polygon3(Vector3[] points, Color color) {
    this.length = points.length;
    xCoords = new double[length];
    yCoords = new double[length];
    zCoords = new double[length];
    this.points = points.clone();
    for (int i = 0; i < length; i++) {
      Vector3 point = points[i];
      xCoords[i] = point.x;
      yCoords[i] = point.y;
      zCoords[i] = point.z;
    }
    this.color = color;
  }

  /**
   * Define a Polygon2 in terms of its vertices as Vector3s. Fill color defaults
   * to black.
   */
  public Polygon3(Vector3[] points) {
    this(points, Color.BLACK);
  }

  /**
   * Deep copy a Polygon3.
   */
  @Override
  public Polygon3 clone() {
    return new Polygon3(points.clone(), color);
  }

  /**
   * Get the number of points the Polygon3 is composed of.
   * 
   * @return The number of vertices in the Polygon3 as an int.
   */
  public int length() {
    return length;
  }

  /**
   * Get an array containing the Polygon3's x-coordinates.
   *
   * @return A new double[] containing the Polygon3's x-coordinates in sequential
   *         order.
   */
  public double[] xCoords() {
    return xCoords.clone();
  }

  /**
   * Get an array containing the Polygon3's y-coordinates.
   *
   * @return A new double[] containing the Polygon3's y-coordinates in sequential
   *         order.
   */
  public double[] yCoords() {
    return yCoords.clone();
  }

  /**
   * Get an array containing the Polygon3's z-coordinates.
   *
   * @return A new double[] containing the Polygon3's z-coordinates in sequential
   *         order.
   */
  public double[] zCoords() {
    return zCoords.clone();
  }

  /**
   * Get an array containing the Polygon3's vertices.
   *
   * @return A new Vector3[] containing the Polygon3's vertices in sequential
   *         order.
   */
  public Vector3[] points() {
    return points.clone();
  }

  /**
   * Get a given one of the Polygon3's points.
   *
   * @param index The index number of the desired point.
   * @return The point at the given index as a Vector3.
   */
  public Vector3 point(int index) {
    if (index < 0 || index > length) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of range [0, " + length
          + "].");
    }
    return points[index];
  }

  /**
   * Get the Polygon3's fill color.
   *
   * @return A Color representing the Polygon3's fill color.
   */
  public Color color() {
    return color;
  }

  /**
   * Set the Polygon3's fill color.
   *
   * @param color The desired fill color for the Polygon3.
   */
  public void setColor(Color color) {
    this.color = color;
  }

  /**
   * Translate every point in the Polygon3 by a certain displacement amount.
   *
   * @param displacement The desired change in x, y, and z, respectively, as a
   *                     Vector3.
   */
  public void translate(Vector3 displacement) {
    for (int i = 0; i < length; i++) {
      points[i] = points[i].add(displacement);
      xCoords[i] = points[i].x;
      yCoords[i] = points[i].y;
      zCoords[i] = points[i].z;
    }
  }

  /**
   * Rotate every point in the Polygon3 around a common center.
   *
   * @param center The center around which the Polygon3 should be rotated.
   * @param yaw    The number of degrees of clockwise rotation desired.
   */
  public void rotate(Vector3 center, double yaw) {
    yaw = -Math.toRadians(yaw);
    double sinYaw = Math.sin(yaw);
    double cosYaw = Math.cos(yaw);
    Vector3 vecFromC;
    double x0;
    double z0;
    double xf;
    double zf;
    for (int i = 0; i < length; i++) {
      vecFromC = points[i].subtract(center);
      x0 = vecFromC.x;
      z0 = vecFromC.z;
      xf = x0 * cosYaw + z0 * sinYaw;
      zf = -x0 * sinYaw + z0 * cosYaw;
      points[i] = new Vector3(xf, vecFromC.y, zf).add(center);
      xCoords[i] = points[i].x;
      yCoords[i] = points[i].y;
      zCoords[i] = points[i].z;
    }
  }

  /**
   * Rotate every point in the Polygon3 around a common center.
   *
   * @param center The center around which the Polygon3 should be rotated.
   * @param sinYaw The sine of the desired rotation angle.
   * @param cosYaw The cosine of the desired rotation angle.
   */
  public void rotate(Vector3 center, double sinYaw, double cosYaw) {
    Vector3 vecFromC;
    Vector3 finalVec;
    double x0;
    double z0;
    double xf;
    double zf;
    for (int i = 0; i < length; i++) {
      vecFromC = points[i].subtract(center);
      x0 = vecFromC.x;
      z0 = vecFromC.z;
      xf = x0 * cosYaw + z0 * sinYaw;
      zf = -x0 * sinYaw + z0 * cosYaw;
      finalVec = new Vector3(xf, vecFromC.y, zf).add(center);
      points[i] = finalVec;
      xCoords[i] = points[i].x;
      yCoords[i] = points[i].y;
      zCoords[i] = points[i].z;
    }
  }

  /**
   * Get the minimum x-value of all the points that make up the Polygon3.
   *
   * @return The minimum x-value of all the Polygon3's vertices as a double.
   */
  public double minX() {
    double x = points[0].x;
    for (int i = 1; i < points.length; i++) {
      if (points[i].x < x) {
        x = points[i].x;
      }
    }
    return x;
  }

  /**
   * Get the maximum x-value of all the points that make up the Polygon3.
   *
   * @return The maximum x-value of all the Polygon3's vertices as a double.
   */
  public double maxX() {
    double x = points[0].x;
    for (int i = 1; i < points.length; i++) {
      if (points[i].x > x) {
        x = points[i].x;
      }
    }
    return x;
  }

  /**
   * Get the minimum y-value of all the points that make up the Polygon3.
   *
   * @return The minimum y-value of all the Polygon3's vertices as a double.
   */
  public double minY() {
    double y = points[0].y;
    for (int i = 1; i < points.length; i++) {
      if (points[i].y < y) {
        y = points[i].y;
      }
    }
    return y;
  }

  /**
   * Get the maximum y-value of all the points that make up the Polygon3.
   *
   * @return The maximum y-value of all the Polygon3's vertices as a double.
   */
  public double maxY() {
    double y = points[0].y;
    for (int i = 1; i < points.length; i++) {
      if (points[i].y > y) {
        y = points[i].y;
      }
    }
    return y;
  }

  /**
   * Get the minimum z-value of all the points that make up the Polygon3.
   *
   * @return The minimum z-value of all the Polygon3's vertices as a double.
   */
  public double minZ() {
    double z = points[0].z;
    for (int i = 1; i < points.length; i++) {
      if (points[i].z < z) {
        z = points[i].z;
      }
    }
    return z;
  }

  /**
   * Get the maximum z-value of all the points that make up the Polygon3.
   *
   * @return The maximum z-value of all the Polygon3's vertices as a double.
   */
  public double maxZ() {
    double z = points[0].z;
    for (int i = 1; i < points.length; i++) {
      if (points[i].z > z) {
        z = points[i].z;
      }
    }
    return z;
  }

  /**
   * Returns a double[] containing the min x, max x, min y, max y, min z, and max
   * z coordinates of
   * the Polygon3 in that order.
   *
   * @return A double array whose elements are min-x, max-x, min-y, max-y, min-z,
   *         and max-z.
   */
  public double[] bounds() {
    Vector3 firstPoint = points[0];
    double minX = firstPoint.x;
    double maxX = minX;
    double minY = firstPoint.y;
    double maxY = minY;
    double minZ = firstPoint.z;
    double maxZ = firstPoint.z;
    Vector3 point;
    for (int i = 1; i < points.length; i++) {
      point = points[i];
      if (point.x < minX) {
        minX = point.x;
      }
      if (point.x > maxX) {
        maxX = point.x;
      }
      if (point.y < minY) {
        minY = point.y;
      }
      if (point.y > maxY) {
        maxY = point.y;
      }
      if (point.z < minZ) {
        minZ = point.z;
      }
      if (point.z > maxZ) {
        maxZ = point.z;
      }
    }
    return new double[] { minX, maxX, minY, maxY, minZ, maxZ };
  }

  // =========================STATICS=========================

  /**
   * Sort an array of Polygon3s in descending order of min-z coordinates.
   * Non-destructive; any
   * Polygon3s passed as part of the array will be cloned rather than referenced.
   *
   * @param polygons An array containing the polygons to be sorted.
   */
  public static Polygon3[] sort(Polygon3[] polygons) {
    // qSort works on polgyons itself - if we don't clone the parameter, it'll get
    // sorted directly
    Polygon3[] polys = polygons.clone();
    sort(polys, 0, polys.length - 1);
    return polys;
  }

  /**
   * An in-place QuickSort algorithm that is called internally by
   * <code>sort</code>.
   */
  private static void sort(Polygon3[] polygons, int start, int end) {
    if (start >= end) {
      return;
    }

    int index = start; // Represents the index of the next known item that is ready to be swapped
    // Select a pivot at random - other implementations call for multiple pivots,
    // but this should
    // be sufficient for our purposes.
    int pivotIndex = (int) (Math.random() * (end - start + 1)) + start;
    double pivot = polygons[pivotIndex].minZ();

    Polygon3 temp = polygons[pivotIndex];
    polygons[pivotIndex] = polygons[end];
    polygons[end] = temp;
    for (int i = start; i < end; i++) {
      if (polygons[i].minZ() >= pivot) {
        temp = polygons[i];
        polygons[i] = polygons[index];
        polygons[index] = temp;
        index++;
      }
    }
    temp = polygons[index];
    polygons[index] = polygons[end];
    polygons[end] = temp;
    sort(polygons, start, index - 1); // Resort left partition
    sort(polygons, index + 1, end); // Resort right partition
  }

  @Override
  public String toString() {
    String str = "Polygon3:\nColor: " + color;
    for (int i = 0; i < length; i++) {
      str += "\n" + points[i].toString();
    }
    return str;
  }
}
