package com.crossover.trial.weather.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A collected point, including some information about the range of collected values
 *
 * @author code test administrator
 */
//CR: This class should be in another package with all entities
public class DataPoint {

    private double mean = 0.0;

    private int first = 0;

    private int second = 0;

    private int third = 0;

    private int count = 0;

    /** private constructor, use the builder to create this object */
    private DataPoint() { }

    public DataPoint(int first, int second, int mean, int third, int count) {
        this.setFirst(first);
        this.setMean(mean);
        this.setSecond(second);
        this.setThird(third);
        this.setCount(count);
    }

    /** the mean of the observations */
    public double getMean() {
        return mean;
    }

    public void setMean(double mean) { this.mean = mean; }

    /** 1st quartile -- useful as a lower bound */
    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    /** 2nd quartile -- median value */
    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    /** 3rd quartile value -- less noisy upper value */
    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }

    /** the total number of measurements */
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }

    //CR: this method is not override correctly
    public boolean equals(Object that) {
        if(that instanceof DataPoint){
            return this.first == ((DataPoint)that).getFirst() &&
                   this.count == ((DataPoint)that).getCount() &&
                   this.second == ((DataPoint)that).getSecond() && 
                   this.third == ((DataPoint)that).getThird() &&
                   this.mean == ((DataPoint)that).getMean();
        }
        return false;
    }

    static public class Builder {
        int first;
        int mean;
        int median;
        int last;
        int count;

        public Builder() { }

        public Builder withFirst(int first) {
            first= first;
            return this;
        }

        public Builder withMean(int mean) {
            mean = mean;
            return this;
        }

        public Builder withMedian(int median) {
            median = median;
            return this;
        }

        public Builder withCount(int count) {
            count = count;
            return this;
        }

        public Builder withLast(int last) {
            last = last;
            return this;
        }

        public DataPoint build() {
            return new DataPoint(this.first, this.mean, this.median, this.last, this.count);
        }
    }
}