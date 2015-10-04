package org.nau;

/**
 * Інкапсулює периметр.
 */
public class Perimeter {
    /** Значення периметру. */
    private double value;

    public Perimeter(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public boolean equals(Perimeter perimeter) {
        return perimeter == null ? false : perimeter.getValue() == value;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
