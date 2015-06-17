
package com.android.mcafee.apphub.model;

import android.os.Parcel;

/**
 * {@link AppHubListLoaderData} is used to removed redundancy while inflating
 * list/details
 * 
 * @author Anukalp
 **/
public class AppHubListLoaderData {

    public static final String TAG_NAME = "name";

    public static final String TAG_PRICE = "price";

    public static final String TAG_RATING = "rating";

    private String name;

    private double price;

    private double rating;

    public void setname(String name) {
        this.name = name;
    }

    public void setprice(double price) {
        this.price = price;
    }

    public void setrating(double rating) {
        this.rating = rating;
    }

    public AppHubListLoaderData() {

    }

    public AppHubListLoaderData(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        rating = in.readDouble();
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AppHubListLoaderData [mName=" + name + ", mPrice=" + price + ", mRating=" + rating
                + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeDouble(rating);
    }
}
